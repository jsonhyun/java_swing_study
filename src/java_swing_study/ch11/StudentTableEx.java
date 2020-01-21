package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class StudentTableEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private StudentTblPanel pList;
	private JPanel pBtns;
	private ArrayList<Student> stds;
	private JButton btnAdd;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private StudentTblPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTableEx frame = new StudentTableEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentTableEx() {
		stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		initialize();
		
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

		pList = new StudentTblPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);
		
		panel = new StudentTblPanel();
		scrollPane.setViewportView(panel);

		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		panel.setPopupMenu(createPopupMenu());
		
		loadData();
	}
	
	private void loadData() {
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[stds.size()][];
		for(int i=0;i<rows.length;i++) {
			rows[i] = toArray(stds.get(i));
		}
		return rows;
	}

	private Object[] toArray(Student std) {
		return new Object[] {std.getStdNo(),std.getStdName(),std.getKor(),std.getEng(),std.getMath(),std.total(),std.avg()};
	}

	private String[] getColumnNames() {
		return new String[] {"학생번호", "학생명", "국어", "영어", "수학", "총점", "평균"};
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
//	ActionListener myPopMenuListener = new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if (e.getActionCommand().equals("수정")) {
//				pStudent.setItem(list.getSelectedValue());
//				btnAdd.setText("수정");
//				list.clearSelection();
//			}
//			if (e.getActionCommand().equals("삭제")) {
//				stds.remove(list.getSelectedValue());
//				list.setListData(new Vector<>(stds));
//				pStudent.clearTf();
//			}
//		}
//	}; 

	
	
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
//		Student updateStd = pStudent.getItem();
//		stds.set(stds.indexOf(updateStd), updateStd);
//		list.setListData(new Vector<Student>(stds));
//		btnAdd.setText("추가");
	}

	protected void btnAddActionPerformed(ActionEvent e) {
//		Student student = pStudent.getItem();
//		stds.add(student);
//		list.setListData(new Vector<Student>(stds));
//		pStudent.clearTf();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
