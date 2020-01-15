package java_swing_study.ch11.exam;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pTop;
	private JPanel pMiddle;
	private JPanel pBottom;
	private JButton btnAdd;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pTop = new StudentPanel();
		pTop.setBounds(5, 6, 424, 237);
		contentPane.add(pTop);
		
		pMiddle = new JPanel();
		pMiddle.setBounds(5, 253, 424, 33);
		contentPane.add(pMiddle);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pMiddle.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pMiddle.add(btnCancel);
		
		pBottom = new JPanel();
		pBottom.setBounds(5, 296, 424, 184);
		contentPane.add(pBottom);
		pBottom.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		pBottom.add(scrollPane);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
//		System.out.println(pTop.getItem());
		ta.append(pTop.getItem().toString()+"\n");
		pTop.clearTf();
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		
	}
}
