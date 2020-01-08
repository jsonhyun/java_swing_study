package java_swing_study.ch09.layout.silsup08;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class MiddlePanel extends JPanel {
	private JLabel lblStar01;
	private JLabel lblStar02;
	private JLabel lblStar03;
	private JLabel lblStar04;
	private JLabel lblStar05;
	private JLabel lblStar06;
	private JLabel lblStar07;
	private JLabel lblStar08;
	private JLabel lblStar09;
	private JLabel lblStar10;

	/**
	 * Create the panel.
	 */
	public MiddlePanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblStar01 = new JLabel("*");
		lblStar01.setForeground(Color.RED);
		lblStar01.setBounds(34, 64, 57, 15);
		add(lblStar01);
		
		lblStar02 = new JLabel("*");
		lblStar02.setForeground(Color.RED);
		lblStar02.setBounds(83, 95, 57, 15);
		add(lblStar02);
		
		lblStar03 = new JLabel("*");
		lblStar03.setForeground(Color.RED);
		lblStar03.setBounds(297, 38, 57, 15);
		add(lblStar03);
		
		lblStar04 = new JLabel("*");
		lblStar04.setForeground(Color.RED);
		lblStar04.setBounds(269, 78, 57, 15);
		add(lblStar04);
		
		lblStar05 = new JLabel("*");
		lblStar05.setForeground(Color.RED);
		lblStar05.setBounds(226, 169, 57, 15);
		add(lblStar05);
		
		lblStar06 = new JLabel("*");
		lblStar06.setForeground(Color.RED);
		lblStar06.setBounds(338, 188, 57, 15);
		add(lblStar06);
		
		lblStar07 = new JLabel("*");
		lblStar07.setForeground(Color.RED);
		lblStar07.setBounds(370, 213, 57, 15);
		add(lblStar07);
		
		lblStar08 = new JLabel("*");
		lblStar08.setForeground(Color.RED);
		lblStar08.setBounds(34, 230, 57, 15);
		add(lblStar08);
		
		lblStar09 = new JLabel("*");
		lblStar09.setForeground(Color.RED);
		lblStar09.setBounds(297, 254, 57, 15);
		add(lblStar09);
		
		lblStar10 = new JLabel("*");
		lblStar10.setForeground(Color.RED);
		lblStar10.setBounds(69, 169, 57, 15);
		add(lblStar10);
	}

}
