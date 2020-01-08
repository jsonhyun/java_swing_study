package java_swing_study.ch09.layout.silsup02;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ButtonEx extends JFrame {

	private JPanel contentPane;
	private ButtonPanel buttonPanel;

	
	public ButtonEx() {
		initialize();
	}
	private void initialize() {
		setTitle("BorderLayout Pratice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		buttonPanel = new ButtonPanel();
		contentPane.add(buttonPanel, BorderLayout.CENTER);
	}

}
