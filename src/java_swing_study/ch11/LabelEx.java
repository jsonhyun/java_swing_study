package java_swing_study.ch11;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LabelEx extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelEx frame = new LabelEx();
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
	public LabelEx() {
		initialize();
	}
	private void initialize() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked()");
			}
			
		});
		String dirPath = System.getProperty("user.dir") + "\\images\\";
		System.out.println(dirPath);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_1 = new JLabel("사랑합니다.");
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setIcon(new ImageIcon(dirPath + "beauty.jpg"));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("보고싶으면 전화하세요");
		lblNewLabel_2.setIcon(new ImageIcon(dirPath+"normalIcon.gif"));
		contentPane.add(lblNewLabel_2);
	}

}
