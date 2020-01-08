package java_swing_study.ch09.layout.silsup08;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BottomPanel extends JPanel {
	private JButton btnWorld;
	private JTextField tfInput;

	/**
	 * Create the panel.
	 */
	public BottomPanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.YELLOW);
		
		btnWorld = new JButton("World Input");
		add(btnWorld);
		
		tfInput = new JTextField();
		add(tfInput);
		tfInput.setColumns(25);
	}

}
