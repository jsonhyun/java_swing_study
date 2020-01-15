package java_swing_study.ch11;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class TextEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lbl1;
	private JTextField tfInput;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEx frame = new TextEx();
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
	public TextEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl1 = new JLabel("입력 후 <Enter> 키를 입력하세요");
		lbl1.setFont(new Font("굴림", Font.BOLD, 12));
		lbl1.setBounds(5, 10, 424, 35);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl1);
		
		tfInput = new JTextField();
		tfInput.addActionListener(this);
		tfInput.setBounds(5, 50, 424, 35);
		contentPane.add(tfInput);
		tfInput.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 95, 422, 156);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfInput) {
			tfInputActionPerformed(e);
		}
	}
	protected void tfInputActionPerformed(ActionEvent e) {
	}
}
