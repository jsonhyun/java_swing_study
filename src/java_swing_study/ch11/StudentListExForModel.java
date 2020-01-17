package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;

@SuppressWarnings("serial")
public class StudentListExForModel extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private JPanel pList;
	private JPanel pBtns;
	private JScrollPane scrollPane;
	private JList<Student> list;
	private JButton btnAdd;
	private JButton btnCancel;
	
	private DefaultListModel<Student> model;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListExForModel frame = new StudentListExForModel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentListExForModel() {
		initialize();
		
		ArrayList<Student> stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		for(Student element : stds) {
			model.addElement(element);
		}

	}

	private void initialize() {
		setTitle("학생 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pStudent = new StudentPanel();
		contentPane.add(pStudent, BorderLayout.NORTH);

		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);

		list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultListModel<Student>();
		list.setModel(model);
		scrollPane.setViewportView(list);

		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		list.setComponentPopupMenu(createPopupMenu());
		model.addListDataListener(myListDataLintener);
	}

	ListDataListener myListDataLintener = new ListDataListener() {
		@Override
		public void intervalRemoved(ListDataEvent e) {
			showMsg("삭제", e);
		}
		
		@Override
		public void intervalAdded(ListDataEvent e) {
			showMsg("추가", e);		
		}
		
		@Override
		public void contentsChanged(ListDataEvent e) {
			showMsg("수정", e);
		}
		
		private void showMsg(String msg, ListDataEvent e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, msg + "되었습니다.");	
		}
	};
	
	private JPopupMenu createPopupMenu() {
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
			if (e.getActionCommand().equals("수정")) {
				pStudent.setItem(list.getSelectedValue());
				btnAdd.setText("수정");
				list.clearSelection();
			}
			if (e.getActionCommand().equals("삭제")) {
				model.removeElement(list.getSelectedValue());
				pStudent.clearTf();
			}
		}
	}; 
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			if (e.getActionCommand().equals("추가")) {
				btnAddActionPerformed(e);
			}else {
				btnUpdateActionPerformed(e);
			}
		}
	}

	private void btnUpdateActionPerformed(ActionEvent e) {
		Student updateStd = pStudent.getItem();
		int updateIdx = model.indexOf(updateStd);
		model.set(updateIdx, updateStd);
		btnAdd.setText("추가");
		pStudent.clearTf();
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		Student student = pStudent.getItem();
		model.addElement(student);
		pStudent.clearTf();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
	
}
