package java_swing_study.ch14.exam.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java_swing_study.ch14.exam.dto.Student;
import java_swing_study.ch14.exam.ui.panel.StudentPanel;
import java_swing_study.ch14.exam.ui.panel.StudentTblPanel;

@SuppressWarnings("serial")
public class StudentMainPanel extends JPanel implements ActionListener {
	private StudentPanel pStd;
	private JPanel pBtn;
	private StudentTblPanel pStdTbl;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Student> stdList;
	private int updateIdx;


	public StudentMainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pStd = new StudentPanel();
		add(pStd);
		
		pBtn = new JPanel();
		add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pStdTbl = new StudentTblPanel();
		add(pStdTbl);
		
		pStdTbl.setPopupMenu(creatPopupMenu());
		
		stdList = new ArrayList<Student>();
		stdList.add(new Student(1, "권수진", 57, 55, 72));
		stdList.add(new Student(2, "정아름", 75, 61, 60));
		stdList.add(new Student(3, "장현서", 65, 98, 82));
		stdList.add(new Student(4, "황태원", 71, 77, 82));
		stdList.add(new Student(5, "현재승", 98, 53, 96));
		stdList.add(new Student(6, "이동주", 57, 90, 68));
		stdList.add(new Student(7, "황하나", 91, 41, 45));
		stdList.add(new Student(8, "유경진", 54, 58, 51));
		stdList.add(new Student(9, "이상원", 75, 53, 60));
		stdList.add(new Student(10, "박인선", 71, 89, 61));
		
		pStdTbl.loadData(stdList);
	}

	private JPopupMenu creatPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenu);
		popMenu.add(updateItem);
		
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(myPopMenu);
		popMenu.add(delItem);
		return popMenu;
	}
	
	ActionListener myPopMenu = new ActionListener() {
	

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
				try {
					Student upStd = pStdTbl.getSelectedItem();
					updateIdx = pStdTbl.getSelectedRowIdx();
					pStd.setItem(upStd);
					btnAdd.setText("수정");
					pStdTbl.clearSelection();
				}catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, "학생을 선택하세요.");
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {
					pStdTbl.removeRow();
				}catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(null, "학생을 선택하세요.");
				}
			}
		}		
	};
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("수정")) {
			Student std = pStd.getItem();
			pStdTbl.updateRow(std, updateIdx);
			btnAdd.setText("추가");
			pStd.clearTf();
		}else {
		Student std = pStd.getItem();
		stdList.add(std);
		pStdTbl.addItem(std);
		pStd.clearTf();
		}
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pStd.clearTf();
		btnAdd.setText("추가");
	}
}
