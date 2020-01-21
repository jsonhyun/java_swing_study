package java_swing_study.ch11.exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class StudentTblPanel_Test extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private NotEditableModel model;

	public StudentTblPanel_Test() {
		initialize();
	}
	
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(table);	
	}
	
	public void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}
	
	public void loadData(ArrayList<Student> stds) {
		model = new NotEditableModel(getRows(stds),	getColNames());
		table.setModel(model);

		setTblWidthAlign();
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		table.getColumnModel().getColumn(2).setCellRenderer(new ReturnTableCellRenderer());
	}
	
	private void setTblWidthAlign() {
		//각 컬럼의 폭과 셀의 수평정렬
		tableSetWidth(50, 150, 50, 50, 50, 70, 70);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 4);
		tableCellAlign(SwingConstants.RIGHT, 5, 6);
		tableCellAlign(SwingConstants.LEFT, 3);
	}
	
	private void tableCellAlign(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	private void tableSetWidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	private String[] getColNames() {
		return new String[] {"번호", "학생명", "국어", "영어", "수학", "총점", "평균"};
	}
	
	private Object[][] getRows(ArrayList<Student> stds) {
		Object[][] rows = new Object[stds.size()][];
		for(int i=0; i<rows.length; i++) {
			rows[i] = toArray(stds.get(i));
		}
		return rows;
	}
	
	private Object[] toArray(Student std) {
		return new Object[] {
				String.format("%03d", std.getStdNo()), 
				std.getStdName(), 
				std.getKor(), 
				std.getEng(), 
				std.getMath(), 
				std.total(), 
				String.format("%.2f", std.avg())};
	}
	
	public void removeRow(){
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}
	
	public void updateRow(Student std, int updateIdx) {
		model.setValueAt(String.format("%03d", std.getStdNo()), updateIdx, 0);//학생번호
		model.setValueAt(std.getStdName(), updateIdx, 1);
		model.setValueAt(std.getKor(), updateIdx, 2);
		model.setValueAt(std.getEng(), updateIdx, 3);
		model.setValueAt(std.getMath(), updateIdx, 4);
		model.setValueAt(std.total(), updateIdx, 5);
		model.setValueAt(String.format("%.2f", std.avg()), updateIdx, 6);
	}
	
	public void addItem(Student std) {
		model.addRow(toArray(std));
	}
	
	public int getSelectedRowIdx() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1) {
			throw new RuntimeException("해당 학생을 선택하세요");
		}
		return selectedIdx;
	}
	
	public Student getSelectedItem() {
		int selectedIdx = getSelectedRowIdx();
		int stdNo = Integer.parseInt((String)model.getValueAt(selectedIdx, 0));
		String stdName = (String) model.getValueAt(selectedIdx, 1);
		int kor = (int) model.getValueAt(selectedIdx, 2);
		int math = (int) model.getValueAt(selectedIdx, 3);
		int eng = (int) model.getValueAt(selectedIdx, 4);
		return new Student(stdNo, stdName, kor, math, eng);
	}
	
	//수정금지하기위한 모델 선언
	private class NotEditableModel extends DefaultTableModel{

		public NotEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}
	
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (value==null) return this;
			setText(value.toString());
			setOpaque(true);
			setHorizontalAlignment(JLabel.CENTER);
			
			if (Integer.parseInt(table.getValueAt(row, 2).toString())>=90) {
				setBackground(Color.CYAN);
			}else if(Integer.parseInt(table.getValueAt(row, 2).toString())>=80) {
				setBackground(Color.LIGHT_GRAY);
			}
			else {
				setBackground(Color.WHITE);
			}
			if (isSelected) {
				setBackground(Color.orange);
			}
			return this;
		}
	}

	public void clearSelection() {
		table.clearSelection();
	}
	
}








