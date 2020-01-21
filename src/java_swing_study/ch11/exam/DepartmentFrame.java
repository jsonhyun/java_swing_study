package java_swing_study.ch11.exam;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DepartmentFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private DepartmentPanel pDeptInfo;
	private JPanel pBtn;
	private DepartmentTblPanel pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Department> depts;
	private int updateIdx;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentFrame frame = new DepartmentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DepartmentFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pDeptInfo = new DepartmentPanel();
		contentPane.add(pDeptInfo);
		
		pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pTable = new DepartmentTblPanel();
		contentPane.add(pTable);
		
		depts = new ArrayList<Department>();
		depts.add(new Department(1, "영업", 8));
		depts.add(new Department(2, "기획", 10));
		depts.add(new Department(3, "개발", 9));
		depts.add(new Department(4, "인사", 7));
		depts.add(new Department(5, "마케팅", 6));
		
		pTable.loadData(depts);
		
		pTable.setPopupMenu(creatPopupMenu());
		
	}
	
	private JPopupMenu creatPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);
		return popMenu;
	}
	
	ActionListener myPopMenuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
				try{
					Department upDep = pTable.getSelectedItem();
					updateIdx = pTable.getSelectedRowIdx();
					pDeptInfo.setItem(upDep);
					btnAdd.setText("수정");
					pTable.clearSelection();
				}
				catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, "부서를 선택하세요");
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {
					pTable.removeRow();
				}catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(null, "부서를 선택하세요");
				}
			}
			
		}
	};

	@Override
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
			Department dep = pDeptInfo.getItem();
			pTable.updateRow(dep, updateIdx);
			btnAdd.setText("추가");
			pDeptInfo.clearTf();
		}else {
			Department dep = pDeptInfo.getItem();
			depts.add(dep);
			pTable.addItem(dep);
			
			pDeptInfo.clearTf();
		}
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pDeptInfo.clearTf();
	}
}
