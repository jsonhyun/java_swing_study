package java_swing_study.ch10;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EventListenerEx extends JFrame {

	private JPanel contentPane;
	private JButton btn01;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventListenerEx frame = new EventListenerEx();
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
	public EventListenerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("이벤트리스너작성방법");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btn01 = new JButton("독립클래스");
		btn01.addActionListener(new MyActionListener());
		contentPane.add(btn01);
		
		JButton btn02 = new JButton("독립클래스 2");
		btn02.addActionListener(new MyActionListener());
		contentPane.add(btn02);
	}

}
