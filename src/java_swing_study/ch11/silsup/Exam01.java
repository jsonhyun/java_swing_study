package java_swing_study.ch11.silsup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class Exam01 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JCheckBox chckbxDisable;
	private JCheckBox chckbxHidden;
	private JButton btn1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam01 frame = new Exam01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Exam01() {
		initialize();
	}
	private void initialize() {
		setTitle("실습문제 1번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		chckbxDisable = new JCheckBox("버튼 비활성화");
		
		panel.add(chckbxDisable);
		
		chckbxHidden = new JCheckBox("버튼 감추기");
		chckbxHidden.addChangeListener(this);
		panel.add(chckbxHidden);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(20, 0, 0, 0));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		btn1 = new JButton("test button");
		panel_1.add(btn1);
		
		chckbxDisable.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == chckbxHidden) {
			chckbxHiddenStateChanged(e);
		}
		if (e.getSource() == chckbxDisable) {
			chckbxDisableStateChanged(e);
		}
	}
	protected void chckbxDisableStateChanged(ChangeEvent e) {
		if(chckbxDisable.isSelected()) {
			btn1.setEnabled(false);
		}else {
			btn1.setEnabled(true);
		}
	}
	protected void chckbxHiddenStateChanged(ChangeEvent e) {
		if(chckbxHidden.isSelected()) {
			btn1.setVisible(false);
		}else {
			btn1.setVisible(true);
		}
	}
}
