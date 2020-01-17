package java_swing_study.ch11.silsup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OpenChallenge extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblImg;
	private JPanel pBtn;
	private JPanel pLeft;
	private JPanel pRight;
	private ArrayList<ImageIcon> image;
	private JButton btnPrev;
	private JButton btnNext;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenChallenge frame = new OpenChallenge();
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
	public OpenChallenge() {
		image = new ArrayList<ImageIcon>();
		String imgDirPath = System.getProperty("user.dir")+"\\images\\";
		image.add(new ImageIcon(imgDirPath+"iron.jpg"));
		image.add(new ImageIcon(imgDirPath+"capameri.jpg"));
		image.add(new ImageIcon(imgDirPath+"capmavel.jpg"));
		image.add(new ImageIcon(imgDirPath+"spa.jpg"));
		
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImg, BorderLayout.CENTER);
		
		pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pBtn.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		btnPrev = new JButton("");
		btnPrev.addActionListener(this);
		btnPrev.setIcon(new ImageIcon("D:\\workspace\\wokrspace_java\\java_swing_study\\images\\back_icon-icons.com_74430.png"));
		pLeft.add(btnPrev, BorderLayout.NORTH);
		
		pRight = new JPanel();
		pBtn.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));
		
		btnNext = new JButton("");
		btnNext.addActionListener(this);
		btnNext.setIcon(new ImageIcon("D:\\workspace\\wokrspace_java\\java_swing_study\\images\\next_icon-icons.com_74443.png"));
		pRight.add(btnNext, BorderLayout.NORTH);
		
		lblImg.setIcon(new ImageIcon("D:\\workspace\\wokrspace_java\\java_swing_study\\images\\iron.jpg"));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			btnNextActionPerformed(e);
		}
		if (e.getSource() == btnPrev) {
			btnPrevActionPerformed(e);
		}
	}
	protected void btnPrevActionPerformed(ActionEvent e) {
		i--;
		if(i == -1) {
			i = 3;
		}
		lblImg.setIcon(image.get(i));
		
		
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		i++;
		if(i==4) {
			i = 0;
		}
		lblImg.setIcon(image.get(i));
	}
}
