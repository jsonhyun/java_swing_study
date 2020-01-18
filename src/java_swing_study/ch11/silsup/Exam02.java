package java_swing_study.ch11.silsup;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfInput;
	private JComboBox<String> combo;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam02 frame = new Exam02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Exam02() {
		initialize();
	}
	private void initialize() {
		setTitle("실습문제 2번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfInput = new JTextField();
		tfInput.addActionListener(this);
		contentPane.add(tfInput);
		tfInput.setColumns(10);
		
		combo = new JComboBox<>();
		contentPane.add(combo);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfInput) {
			tfInputActionPerformed(e);
		}
	}
	protected void tfInputActionPerformed(ActionEvent e) {
		combo.addItem(tfInput.getText().trim());
		tfInput.setText("");
	}
}
