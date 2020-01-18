package java_swing_study.ch11.silsup;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class Exam07 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider slider;
	private JLabel lblSize;
	private String name;
	private int style;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam07 frame = new Exam07();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Exam07() {
		initialize();
	}
	private void initialize() {
		setTitle("실습문제 7번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		slider = new JSlider();
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.setMinimum(1);
		contentPane.add(slider, BorderLayout.NORTH);
		
		lblSize = new JLabel("I Love Java");
		lblSize.setFont(new Font("굴림", Font.PLAIN, 50));
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSize, BorderLayout.CENTER);
		slider.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		Font size = new Font(name, style, slider.getValue());
		lblSize.setFont(size);
	}
}
