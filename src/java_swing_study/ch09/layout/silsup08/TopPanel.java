package java_swing_study.ch09.layout.silsup08;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TopPanel extends JPanel {
	private JButton btnOpen;
	private JButton btnClose;
	private JButton btnExit;

	/**
	 * Create the panel.
	 */
	public TopPanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.GRAY);
		
		btnOpen = new JButton("열기");
		add(btnOpen);
		
		btnClose = new JButton("닫기");
		add(btnClose);
		
		btnExit = new JButton("나가기");
		add(btnExit);
	}

}
