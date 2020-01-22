package java_swing_study.ch14.exam.ui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import java_swing_study.ch14.exam.dto.Department;
import java_swing_study.ch14.exam.ui.panel.DepartmentPanel;
import java_swing_study.ch14.exam.ui.panel.DepartmentTblPanel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class DepartmentMainPanel extends JPanel implements ActionListener {
	private DepartmentPanel pDept;
	private JPanel pBtn;
	private DepartmentTblPanel pDeptList;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Department> deptList;
	private int updateIdx;

	public DepartmentMainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pDept = new DepartmentPanel();
		add(pDept);
		
		pBtn = new JPanel();
		add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pDeptList = new DepartmentTblPanel();
		add(pDeptList);
		
		pDeptList.setPopupMenu(createPopupMenu());
		
		deptList = new ArrayList<Department>();
		deptList.add(new Department(1, "영업", 8));
		deptList.add(new Department(2, "기획", 9));
		deptList.add(new Department(3, "개발", 10));
		deptList.add(new Department(4, "인사", 11));
		deptList.add(new Department(5, "마케팅", 12));
		
		pDeptList.loadData(deptList);
	}
	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(popMenuAction);
		popMenu.add(updateItem);
		
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(popMenuAction);
		popMenu.add(delItem);
		
		return popMenu;
	}
	
	ActionListener popMenuAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
				try {
					Department upDept = pDeptList.getSelectedItem();
					updateIdx = pDeptList.getSelectedRowIdx();
					pDept.setItem(upDept);
					btnAdd.setText("수정");
					pDeptList.clearSelection();
				}catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, "부서를 선택하세요.");
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {
					pDeptList.removeRow();
				}catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(null, "부서를 선택하세요.");
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
			Department upDept = pDept.getItem();
			pDeptList.updateRow(upDept, updateIdx);
			btnAdd.setText("추가");
			pDept.clearTf();
		}
		Department dept = pDept.getItem();
		deptList.add(dept);
		pDeptList.addItem(dept);
		pDept.clearTf();
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pDept.clearTf();
		btnAdd.setText("추가");
	}
}
