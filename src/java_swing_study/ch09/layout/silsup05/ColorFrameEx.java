package java_swing_study.ch09.layout.silsup05;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ColorFrameEx extends JFrame {

	private JPanel contentPane;
	private ColorLabelPanel pColorLabel;

	public ColorFrameEx() {
		initialize();
	}
	private void initialize() {
		setTitle("4X4 Color Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pColorLabel = new ColorLabelPanel();
		contentPane.add(pColorLabel, BorderLayout.CENTER);
	}

}
