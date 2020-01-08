package java_swing_study.ch09.layout.silsup02;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	private JButton btnNorth;
	private JButton btnWest;
	private JButton btnCenter;
	private JButton btnEast;
	private JButton btnSouth;

	/**
	 * Create the panel.
	 */
	public ButtonPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(5, 7));
		
		btnNorth = new JButton("North");
		add(btnNorth, BorderLayout.NORTH);
		
		btnWest = new JButton("West");
		add(btnWest, BorderLayout.WEST);
		
		btnCenter = new JButton("Center");
		add(btnCenter, BorderLayout.CENTER);
		
		btnEast = new JButton("East");
		add(btnEast, BorderLayout.EAST);
		
		btnSouth = new JButton("South");
		add(btnSouth, BorderLayout.SOUTH);
	}

}
