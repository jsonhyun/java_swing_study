package java_swing_study.ch09.layout.silsup07;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class OperatorPanel extends JPanel {
	private JButton btnNo0;
	private JButton btnNo1;
	private JButton btnNo2;
	private JButton btnNo4;
	private JButton btnNo3;
	private JButton btnNo6;
	private JButton btnNo7;
	private JButton btnNo8;
	private JButton btnNo5;
	private JButton btnCE;
	private JButton btnOper;
	private JButton btnSum;
	private JButton btnNo9;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;

	/**
	 * Create the panel.
	 */
	public OperatorPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 5, 5));
		
		btnNo0 = new JButton("0");
		add(btnNo0);
		
		btnNo1 = new JButton("1");
		add(btnNo1);
		
		btnNo2 = new JButton("2");
		add(btnNo2);
		
		btnNo3 = new JButton("3");
		add(btnNo3);
		
		btnNo4 = new JButton("4");
		add(btnNo4);
		
		btnNo5 = new JButton("5");
		add(btnNo5);
		
		btnNo6 = new JButton("6");
		add(btnNo6);
		
		btnNo7 = new JButton("7");
		add(btnNo7);
		
		btnNo8 = new JButton("8");
		add(btnNo8);
		
		btnNo9 = new JButton("9");
		add(btnNo9);
		
		btnCE = new JButton("CE");
		add(btnCE);
		
		btnOper = new JButton("계산");
		add(btnOper);
		
		btnSum = new JButton("+");
		btnSum.setBackground(new Color(0, 191, 255));
		add(btnSum);
		
		btnSub = new JButton("-");
		btnSub.setBackground(new Color(0, 191, 255));
		add(btnSub);
		
		btnMul = new JButton("X");
		btnMul.setBackground(new Color(0, 191, 255));
		add(btnMul);
		
		btnDiv = new JButton("/");
		btnDiv.setBackground(new Color(0, 191, 255));
		add(btnDiv);
	}

}
