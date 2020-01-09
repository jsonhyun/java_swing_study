package java_swing_study.ch10;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EventListenerEx extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btn01;
	private JButton btn03;
	private JButton btn04;
	private JButton btn06;
	private JButton btn07;
	private JPanel panel;
	private JButton btn08;
	private JButton btn09;
	private JButton btn10;

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
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		btn01 = new JButton("독립클래스");
		btn01.addActionListener(new MyActionListener());
		contentPane.add(btn01);
		
		JButton btn02 = new JButton("독립클래스 2");
		btn02.addActionListener(new MyActionListener());
		btn02.addActionListener(new MyAction2Listener());
		contentPane.add(btn02);
		
		btn03 = new JButton("내부클래스");
		btn03.addActionListener(new MyAction3Listener());
		contentPane.add(btn03);
		
		btn04 = new JButton("익명클래스");
		btn04.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
				
			}
		});
		contentPane.add(btn04);
		
		JButton btn05 = new JButton("내부클래스2");
		btn05.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
				
			}
		});
		contentPane.add(btn05);
		
		btn06 = new JButton("부모클래스");
		btn06.addActionListener(this);
		contentPane.add(btn06);
		
		btn07 = new JButton("부모클래스2");
		btn07.addActionListener(this);
		contentPane.add(btn07);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		btn08 = new JButton("익명(윈도우빌더)");
		btn08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "윈도우빌더-익명");
			}
		});
		contentPane.add(btn08);
		
		btn09 = new JButton("내부클래스(윈도우빌더)");
		btn09.addActionListener(new Btn09ActionListener());
		contentPane.add(btn09);
		
		btn10 = new JButton("부모클래스(윈도우빌더)");
		btn10.addActionListener(this);
		contentPane.add(btn10);
	}
	
	class MyAction3Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "내부클래스 이벤트 리스너");
			
		}
		
	}
	private class Btn09ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "잠온다");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn10) {
			btn10ActionPerformed(e);
		}
		if(e.getSource() == btn06) {
			JOptionPane.showMessageDialog(null, "btn06 " + e.getActionCommand());
		}
		
		if(e.getSource() == btn07) {
			actionPerformedBtn07(e);
		}
		
	}

	private void actionPerformedBtn07(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "btn07 " + e.getActionCommand());
		
	}

	protected void btn10ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "정말 잠온다....from 상원");
	}
}
