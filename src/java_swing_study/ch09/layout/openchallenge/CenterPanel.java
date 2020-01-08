package java_swing_study.ch09.layout.openchallenge;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	private JLabel lblHello;
	private JLabel lblJava;
	private JLabel lblLove;

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		lblHello = new JLabel("Hello");
		lblHello.setBounds(152, 63, 57, 15);
		add(lblHello);
		
		lblJava = new JLabel("Java");
		lblJava.setBounds(66, 203, 57, 15);
		add(lblJava);
		
		lblLove = new JLabel("Love");
		lblLove.setBounds(334, 168, 57, 15);
		add(lblLove);
	}

}
