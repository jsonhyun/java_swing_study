package java_swing_study.ch09.layout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java_swing_study.ch09.layout.openchallenge.OperChallengeEx;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnFlowLayout;
	private JButton btnBorderLayout;
	private JButton btnNewButton;
	private JButton btnAbsoluteLayout;
	private JButton btnOpenChallenge;

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
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "레이아웃 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnFlowLayout = new JButton("FlowLayout");
		btnFlowLayout.addActionListener(this);
		contentPane.add(btnFlowLayout);
		
		btnBorderLayout = new JButton("BorderLayout");
		btnBorderLayout.addActionListener(this);
		contentPane.add(btnBorderLayout);
		
		btnNewButton = new JButton("GridLayout");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		btnAbsoluteLayout = new JButton("AbsoluteLayout");
		btnAbsoluteLayout.addActionListener(this);
		contentPane.add(btnAbsoluteLayout);
		
		btnOpenChallenge = new JButton("OpenChallenge");
		btnOpenChallenge.addActionListener(this);
		contentPane.add(btnOpenChallenge);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpenChallenge) {
			btnOpenChallengeActionPerformed(e);
		}
		if (e.getSource() == btnAbsoluteLayout) {
			btnAbsoluteLayoutActionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
		if (e.getSource() == btnBorderLayout) {
			btnBorderLayoutActionPerformed(e);
		}
		if (e.getSource() == btnFlowLayout) {
			btnFlowLayoutActionPerformed(e);
		}
	}
	protected void btnFlowLayoutActionPerformed(ActionEvent e) {
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);
	}
	protected void btnBorderLayoutActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		GridLayoutEx frame = new GridLayoutEx();
		frame.setVisible(true);
	}
	protected void btnAbsoluteLayoutActionPerformed(ActionEvent e) {
		AbsoluteLayoutEx frame = new AbsoluteLayoutEx();
		frame.setVisible(true);
	}
	protected void btnOpenChallengeActionPerformed(ActionEvent e) {
		OperChallengeEx frame = new OperChallengeEx();
		frame.setVisible(true);
	}
}
