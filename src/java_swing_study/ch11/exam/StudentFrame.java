package java_swing_study.ch11.exam;

import java.awt.BorderLayout;
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
public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pContent;
	private StudentTblPanel pList;
	private StudentPanel pStudent;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnCancel;
	private int updateIdx;
	private ArrayList<Student> stds;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentFrame() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));
		
		pStudent = new StudentPanel();
		pContent.add(pStudent, BorderLayout.CENTER);
		
		pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pList = new StudentTblPanel();
		contentPane.add(pList);
		
		pList.setPopupMenu(creatPopupMenu());
		
		
		stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		pList.loadData(stds);
//		pList.setLayout(new BorderLayout(0, 0));
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
				try{Student upStd = pList.getSelectedItem();
				System.out.println(upStd);
				updateIdx = pList.getSelectedRowIdx();
				pStudent.setItem(upStd);
				btnAdd.setText("수정");
				pList.clearSelection();
				}catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {
					pList.removeRow();
				}catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
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
			Student std = pStudent.getItem();
			pList.updateRow(std, updateIdx);
			btnAdd.setText("추가");
		}else {
			Student std = pStudent.getItem();
			stds.add(std);
			pList.addItem(std);
		}
//		ta.append(std.toString() + "\n");
		pStudent.clearTf();
	}
	
	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}
