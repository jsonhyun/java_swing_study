package java_swing_study.ch09.layout.silsup04;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TenColorButtonFrameEx extends JFrame {

	private JPanel contentPane;
	private ColorButtonPanel pColorButton;

	public TenColorButtonFrameEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pColorButton = new ColorButtonPanel();
		contentPane.add(pColorButton, BorderLayout.CENTER);
	}

}
