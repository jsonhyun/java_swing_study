package java_swing_study.ch14.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java_swing_study.ch14.exam.ui.DepartmentMainPanel;
import java_swing_study.ch14.exam.ui.StudentMainPanel;

@SuppressWarnings("serial")
public class ERPFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMng;
	private JMenuItem mntmStd;
	private JMenuItem mntmDept;
	private JMenuItem mntmExit;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JPanel pDisplay;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERPFrame frame = new ERPFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ERPFrame() {
		initialize();
	}
	private void initialize() {
		setLocationByPlatform(true);
		setTitle("관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 400);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMng = new JMenu("관리");
		menuBar.add(mnMng);
		
		mntmStd = new JMenuItem("학생정보관리");
		mntmStd.addActionListener(this);
		mntmStd.setHorizontalAlignment(SwingConstants.CENTER);
		mnMng.add(mntmStd);
		
		mntmDept = new JMenuItem("부서정보관리");
		mntmDept.addActionListener(this);
		mntmDept.setHorizontalAlignment(SwingConstants.CENTER);
		mnMng.add(mntmDept);
		
		separator = new JSeparator();
		mnMng.add(separator);
		
		mntmExit = new JMenuItem("종료");
		mntmExit.addActionListener(this);
		mntmExit.setHorizontalAlignment(SwingConstants.CENTER);
		mnMng.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		pDisplay = new JPanel();
		scrollPane.setViewportView(pDisplay);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmDept) {
			mntmDeptActionPerformed(e);
		}
		if (e.getSource() == mntmExit) {
			mntmExitActionPerformed(e);
		}
		if (e.getSource() == mntmStd) {
			mntmStdActionPerformed(e);
		}
	}
	protected void mntmStdActionPerformed(ActionEvent e) {
		pDisplay.removeAll();
		StudentMainPanel newStd = new StudentMainPanel();
		pDisplay.add(newStd, BorderLayout.SOUTH);
		revalidate();
		repaint();
	}

	protected void mntmDeptActionPerformed(ActionEvent e) {	
		pDisplay.removeAll();
		DepartmentMainPanel newDept = new DepartmentMainPanel();
		pDisplay.add(newDept, BorderLayout.SOUTH);
		revalidate();
		repaint();
	}
	protected void mntmExitActionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
