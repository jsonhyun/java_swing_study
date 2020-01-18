package java_swing_study.ch11.silsup;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Exam05 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider slider;
	private JLabel lblNum;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam05 frame = new Exam05();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Exam05() {
		initialize();
	}
	private void initialize() {
		setTitle("실습문제 5번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		slider = new JSlider();
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinimum(100);
		slider.setMaximum(200);
		slider.setMajorTickSpacing(20);
		contentPane.add(slider);
		
		lblNum = new JLabel("0");
		lblNum.setBackground(Color.GREEN);
		lblNum.setForeground(Color.BLACK);
		contentPane.add(lblNum);
		
		slider.addChangeListener(this);
		slider.setValue(150);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		String num = slider.getValue()+"";
		lblNum.setText(num);
	}
}
