package java_swing_study.ch09.layout.silsup05;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class ColorLabelPanel extends JPanel {
	private JLabel lblNum0;
	private JLabel lblNum1;
	private JLabel lblNum2;
	private JLabel lblNum3;
	private JLabel lblNum4;
	private JLabel lblNum5;
	private JLabel lblNum6;
	private JLabel lblNum7;
	private JLabel lblNum8;
	private JLabel lblNum9;
	private JLabel lblNum10;
	private JLabel lblNum11;
	private JLabel lblNum12;
	private JLabel lblNum13;
	private JLabel lblNum14;
	private JLabel lblNum15;

	/**
	 * Create the panel.
	 */
	public ColorLabelPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 0, 0));
		
		lblNum0 = new JLabel("0");
		lblNum0.setOpaque(true);
		lblNum0.setBackground(Color.RED);
		add(lblNum0);
		
		lblNum1 = new JLabel("1");
		lblNum1.setOpaque(true);
		lblNum1.setBackground(Color.ORANGE);
		add(lblNum1);
		
		lblNum2 = new JLabel("2");
		lblNum2.setOpaque(true);
		lblNum2.setBackground(Color.YELLOW);
		add(lblNum2);
		
		lblNum3 = new JLabel("3");
		lblNum3.setOpaque(true);
		lblNum3.setBackground(Color.GREEN);
		add(lblNum3);
		
		lblNum4 = new JLabel("4");
		lblNum4.setOpaque(true);
		lblNum4.setBackground(Color.CYAN);
		add(lblNum4);
		
		lblNum5 = new JLabel("5");
		lblNum5.setOpaque(true);
		lblNum5.setBackground(Color.BLUE);
		add(lblNum5);
		
		lblNum6 = new JLabel("6");
		lblNum6.setOpaque(true);
		lblNum6.setBackground(Color.MAGENTA);
		add(lblNum6);
		
		lblNum7 = new JLabel("7");
		lblNum7.setOpaque(true);
		lblNum7.setBackground(Color.DARK_GRAY);
		add(lblNum7);
		
		lblNum8 = new JLabel("8");
		lblNum8.setOpaque(true);
		lblNum8.setBackground(Color.PINK);
		add(lblNum8);
		
		lblNum9 = new JLabel("9");
		lblNum9.setOpaque(true);
		lblNum9.setBackground(Color.LIGHT_GRAY);
		add(lblNum9);
		
		lblNum10 = new JLabel("10");
		lblNum10.setOpaque(true);
		lblNum10.setBackground(Color.WHITE);
		add(lblNum10);
		
		lblNum11 = new JLabel("11");
		lblNum11.setOpaque(true);
		lblNum11.setBackground(Color.BLACK);
		add(lblNum11);
		
		lblNum12 = new JLabel("12");
		lblNum12.setOpaque(true);
		lblNum12.setBackground(Color.BLACK);
		add(lblNum12);
		
		lblNum13 = new JLabel("13");
		lblNum13.setOpaque(true);
		lblNum13.setBackground(Color.ORANGE);
		add(lblNum13);
		
		lblNum14 = new JLabel("14");
		lblNum14.setOpaque(true);
		lblNum14.setBackground(Color.BLUE);
		add(lblNum14);
		
		lblNum15 = new JLabel("15");
		lblNum15.setOpaque(true);
		lblNum15.setBackground(Color.MAGENTA);
		add(lblNum15);
	}

}
