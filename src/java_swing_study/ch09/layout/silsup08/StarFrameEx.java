package java_swing_study.ch09.layout.silsup08;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StarFrameEx extends JFrame {

	private JPanel contentPane;
	private TopPanel pTop;
	private BottomPanel pMiddle;
	private MiddlePanel pBottom;

	public StarFrameEx() {
		initialize();
	}
	private void initialize() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pTop = new TopPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		
		pMiddle = new BottomPanel();
		contentPane.add(pMiddle, BorderLayout.SOUTH);
		
		pBottom = new MiddlePanel();
		contentPane.add(pBottom, BorderLayout.CENTER);
	}

}
