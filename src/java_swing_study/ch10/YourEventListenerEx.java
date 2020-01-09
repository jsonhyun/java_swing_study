package java_swing_study.ch10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class YourEventListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btn01;
	private JButton btn02;
	private JButton btn03;
	private JButton btn04;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourEventListenerEx frame = new YourEventListenerEx();
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
	public YourEventListenerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("리스너 작성 실습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 20, 10, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC708\uB3C4\uC6B0\uBE4C\uB354\uC81C\uACF5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btn01 = new JButton("배경색 변경");
		btn01.addActionListener(this);
		panel.add(btn01, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uB3C5\uB9BD\uD074\uB798\uC2A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btn02 = new JButton("배경색 변경");
		btn02.addActionListener(new MyAction3Listener(contentPane));
		panel_1.add(btn02, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uB0B4\uBD80\uD074\uB798\uC2A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btn03 = new JButton("배경색 변경");
		btn03.addActionListener(new MyAction4Listener());
		panel_2.add(btn03, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uC775\uBA85\uD074\uB798\uC2A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btn04 = new JButton("배경색 변경");
		btn04.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contentPane.getBackground() == Color.RED) {
					contentPane.setBackground(Color.YELLOW);
				}else {
					contentPane.setBackground(Color.RED);
				}
				
			}
		});
		panel_3.add(btn04, BorderLayout.CENTER);
	}
	private class MyAction4Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(contentPane.getBackground() == Color.RED) {
				contentPane.setBackground(Color.YELLOW);
			}else {
				contentPane.setBackground(Color.RED);
			}
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			btn01ActionPerformed(e);
		}
	}
	protected void btn01ActionPerformed(ActionEvent e) {
		System.out.println(contentPane.getBackground());
		if(contentPane.getBackground() == Color.YELLOW) {
			contentPane.setBackground(Color.RED);
		}else {
			contentPane.setBackground(Color.YELLOW);
		}
		
	}
}
