package java_swing_study.ch09.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BorderLayoutEx extends JFrame {

	private JPanel contentPane;
	private JButton btnCalculate;
	private JButton btnAdd;
	private JButton btnDiv;
	private JButton btnMul;
	private JButton btnSub;

	public BorderLayoutEx() {
		initialize();
	}
	private void initialize() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(30, 20));
		setContentPane(contentPane);
		
		btnCalculate = new JButton("Calculate");
		contentPane.add(btnCalculate, BorderLayout.CENTER);
		
		btnAdd = new JButton("Add");
		contentPane.add(btnAdd, BorderLayout.NORTH);
		
		btnDiv = new JButton("Div");
		contentPane.add(btnDiv, BorderLayout.WEST);
		
		btnMul = new JButton("Mul");
		contentPane.add(btnMul, BorderLayout.EAST);
		
		btnSub = new JButton("Sub");
		contentPane.add(btnSub, BorderLayout.SOUTH);
	}

}
