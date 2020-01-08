package java_swing_study.ch09.layout.silsup07;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class OutputPanel extends JPanel {
	private JLabel lblOutput;
	private JTextField tfOutput;

	/**
	 * Create the panel.
	 */
	public OutputPanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.YELLOW);
		
		lblOutput = new JLabel("계산 결과");
		lblOutput.setFont(new Font("굴림", Font.PLAIN, 14));
		add(lblOutput);
		
		tfOutput = new JTextField();
		add(tfOutput);
		tfOutput.setColumns(20);
	}

}
