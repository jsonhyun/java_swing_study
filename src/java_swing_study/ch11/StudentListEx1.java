package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;

@SuppressWarnings("serial")
public class StudentListEx1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private JPanel pList;
	private JPanel pBtns;
	private JScrollPane scrollPane;
	private JList<Student> list;
	private ArrayList<Student> std;
	private JButton btnAdd;
	private JButton btnCancel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListEx1 frame = new StudentListEx1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StudentListEx1() {
		std = new ArrayList<Student>();
		std.add(new Student(1, "서현진", 80,90,70));
		std.add(new Student(2, "이성경", 90,90,40));
		std.add(new Student(3, "이유영", 50,50,60));
		initialize();
		
		list.setListData(new Vector<Student>(std));
	}
	private void initialize() {
		setTitle("학생 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
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
		scrollPane.setViewportView(list);
		
		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		pBtns.add(btnCancel);
		
		list.setComponentPopupMenu(createPopupMenu());
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		Student newStd = pStudent.getItem();
		std.add(newStd);
		list.setListData(new Vector<Student>(std));
		pStudent.clearTf();
		
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(mypopMenuListenr);
		popMenu.add(deleteItem);

		return popMenu;
	}

	ActionListener mypopMenuListenr = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("수정")) {
				System.out.println("수정");
			}
			if (e.getActionCommand().equals("삭제")) {
				System.out.println("삭제");
				int selIdx = list.getSelectedIndex();
				System.out.println(selIdx);
				
				// list에서 선택된 것이 있는지 판단
				// 선택된 번호 또는 value를 가져온 후
				// arrlist에 일치하는 삭제
				// Jlist에서 setlistData()호출해서 변경된 arraylist를 보여주도록 한다.

			}
		}
	}; 
}
