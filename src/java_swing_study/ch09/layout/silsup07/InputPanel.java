package java_swing_study.ch09.layout.silsup07;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	private JLabel lblInput;
	private JTextField tfInput;

	/**
	 * Create the panel.
	 */
	public InputPanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.GRAY);
		
		lblInput = new JLabel("수식입력");
		lblInput.setFont(new Font("굴림", Font.PLAIN, 14));
		add(lblInput);
		
		tfInput = new JTextField();
		add(tfInput);
		tfInput.setColumns(20);
	}

}
