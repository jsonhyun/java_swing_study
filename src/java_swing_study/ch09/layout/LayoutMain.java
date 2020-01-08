package java_swing_study.ch09.layout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java_swing_study.ch09.layout.openchallenge.OperChallengeEx;
import java_swing_study.ch09.layout.silsup02.ButtonEx;
import java_swing_study.ch09.layout.silsup04.TenColorButtonFrameEx;
import java_swing_study.ch09.layout.silsup05.ColorFrameEx;
import java_swing_study.ch09.layout.silsup07.OperatorEx;
import java_swing_study.ch09.layout.silsup08.StarFrameEx;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JButton btnFlow;
	private JButton btnBorder;
	private JButton btnGrid;
	private JButton btnAbsolute;
	private JButton btnOpenChallenge;
	private JPanel pRight;
	private JButton btnPracticeNo2;
	private JButton btnPracticeNo4;
	private JButton btnPracticeNo5;
	private JButton btnPracticeNo7;
	private JButton btnPracticeNo8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
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
	public LayoutMain() {
		initialize();
	}
	private void initialize() {
		setTitle("배치레이아웃예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC81C9\uC7A5 GUI \uAE30\uCD08", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uB808\uC774\uC544\uC6C3 \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnFlow = new JButton("FlowLayout");
		btnFlow.addActionListener(this);
		pLeft.add(btnFlow);
		
		btnBorder = new JButton("BorderLayout");
		btnBorder.addActionListener(this);
		pLeft.add(btnBorder);
		
		btnGrid = new JButton("GridLayout");
		btnGrid.addActionListener(this);
		pLeft.add(btnGrid);
		
		btnAbsolute = new JButton("AbsoluteLayout");
		btnAbsolute.addActionListener(this);
		pLeft.add(btnAbsolute);
		
		btnOpenChallenge = new JButton("OpenChallenge");
		btnOpenChallenge.addActionListener(this);
		pLeft.add(btnOpenChallenge);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC2E4\uC2B5\uBB38\uC81C \uD480\uC774", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnPracticeNo2 = new JButton("실습문제 2번");
		btnPracticeNo2.addActionListener(this);
		pRight.add(btnPracticeNo2);
		
		btnPracticeNo4 = new JButton("실습문제 4번");
		btnPracticeNo4.addActionListener(this);
		pRight.add(btnPracticeNo4);
		
		btnPracticeNo5 = new JButton("실습문제 5번");
		btnPracticeNo5.addActionListener(this);
		pRight.add(btnPracticeNo5);
		
		btnPracticeNo7 = new JButton("실습문제 7번");
		btnPracticeNo7.addActionListener(this);
		pRight.add(btnPracticeNo7);
		
		btnPracticeNo8 = new JButton("실습문제 8번");
		btnPracticeNo8.addActionListener(this);
		btnPracticeNo8.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(e.getButton() + ":" + e.getClickCount());
			}
			
		});
		pRight.add(btnPracticeNo8);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
//		JOptionPane.showMessageDialog(null, e.getSource());
		
		if (e.getSource() == btnPracticeNo8) {
			btnPracticeNo8ActionPerformed(e);
		}
		if (e.getSource() == btnPracticeNo7) {
			btnPracticeNo7ActionPerformed(e);
		}
		if (e.getSource() == btnPracticeNo5) {
			btnPracticeNo5ActionPerformed(e);
		}
		if (e.getSource() == btnPracticeNo4) {
			btnPracticeNo4ActionPerformed(e);
		}
		if (e.getSource() == btnOpenChallenge) {
			btnOpenChallengeActionPerformed(e);
		}
		if (e.getSource() == btnAbsolute) {
			btnAbsoluteActionPerformed(e);
		}
		if (e.getSource() == btnGrid) {
			btnGridActionPerformed(e);
		}
		if (e.getSource() == btnBorder) {
			btnBorderActionPerformed(e);
		}
		if (e.getSource() == btnFlow) {
			btnFlowActionPerformed(e);
		}
		if (e.getSource() == btnPracticeNo2) {
			btnPracticeNo2ActionPerformed(e);
		}
	}
	protected void btnPracticeNo2ActionPerformed(ActionEvent e) {
		ButtonEx frame = new ButtonEx();
		frame.setVisible(true);
	}
	protected void btnFlowActionPerformed(ActionEvent e) {
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);
	}
	protected void btnBorderActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}
	protected void btnGridActionPerformed(ActionEvent e) {
		GridLayoutEx frame = new GridLayoutEx();
		frame.setVisible(true);
	}
	protected void btnAbsoluteActionPerformed(ActionEvent e) {
		AbsoluteLayoutEx frame = new AbsoluteLayoutEx();
		frame.setVisible(true);
	}
	protected void btnOpenChallengeActionPerformed(ActionEvent e) {
		OperChallengeEx frame = new OperChallengeEx();
		frame.setVisible(true);
	}
	protected void btnPracticeNo4ActionPerformed(ActionEvent e) {
		TenColorButtonFrameEx frame = new TenColorButtonFrameEx();
		frame.setVisible(true);
	}
	protected void btnPracticeNo5ActionPerformed(ActionEvent e) {
		ColorFrameEx frame = new ColorFrameEx();
		frame.setVisible(true);
	}
	protected void btnPracticeNo7ActionPerformed(ActionEvent e) {
		OperatorEx frame = new OperatorEx();
		frame.setVisible(true);
	}
	protected void btnPracticeNo8ActionPerformed(ActionEvent e) {
		StarFrameEx frame = new StarFrameEx();
		frame.setVisible(true);
	}
}
