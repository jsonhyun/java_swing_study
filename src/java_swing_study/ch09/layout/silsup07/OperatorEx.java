package java_swing_study.ch09.layout.silsup07;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OperatorEx extends JFrame {

	private JPanel contentPane;
	private InputPanel pInput;
	private OperatorPanel pOper;
	private OutputPanel pOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorEx frame = new OperatorEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OperatorEx() {
		initialize();
	}
	private void initialize() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pInput = new InputPanel();
		contentPane.add(pInput, BorderLayout.NORTH);
		
		pOper = new OperatorPanel();
		contentPane.add(pOper, BorderLayout.CENTER);
		
		pOutput = new OutputPanel();
		contentPane.add(pOutput, BorderLayout.SOUTH);
	}

}
