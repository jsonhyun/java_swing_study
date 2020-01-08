package java_swing_study.ch09.layout.silsup04;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class ColorButtonPanel extends JPanel {
	private JButton btnNum0;
	private JButton btnNum1;
	private JButton btnNum2;
	private JButton btnNum3;
	private JButton btnNum4;
	private JButton btnNum5;
	private JButton btnNum7;
	private JButton btnNum8;
	private JButton btnNum6;
	private JButton btnNum9;

	/**
	 * Create the panel.
	 */
	public ColorButtonPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNum0 = new JButton("0");
		btnNum0.setBackground(Color.RED);
		btnNum0.setForeground(Color.BLACK);
		add(btnNum0);
		
		btnNum1 = new JButton("1");
		btnNum1.setBackground(Color.ORANGE);
		add(btnNum1);
		
		btnNum2 = new JButton("2");
		btnNum2.setBackground(Color.YELLOW);
		add(btnNum2);
		
		btnNum3 = new JButton("3");
		btnNum3.setBackground(Color.GREEN);
		add(btnNum3);
		
		btnNum4 = new JButton("4");
		btnNum4.setBackground(Color.CYAN);
		add(btnNum4);
		
		btnNum5 = new JButton("5");
		btnNum5.setBackground(Color.BLUE);
		add(btnNum5);
		
		btnNum6 = new JButton("6");
		btnNum6.setBackground(new Color(128, 0, 128));
		add(btnNum6);
		
		btnNum7 = new JButton("7");
		btnNum7.setBackground(Color.DARK_GRAY);
		add(btnNum7);
		
		btnNum8 = new JButton("8");
		btnNum8.setBackground(Color.PINK);
		add(btnNum8);
		
		btnNum9 = new JButton("9");
		btnNum9.setBackground(Color.LIGHT_GRAY);
		add(btnNum9);
	}

}
