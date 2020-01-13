package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CheckBoxItemEventEx extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JLabel lbl1;
	private JCheckBox chk1;
	private JCheckBox chk2;
	private JCheckBox chk3;
	private JLabel lbl2;
	private int sum = 0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxItemEventEx frame = new CheckBoxItemEventEx();
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
	public CheckBoxItemEventEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uC608\uC81C11-5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		lbl1 = new JLabel("사과 100원, 배 500원, 체리 20000원");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lbl1, BorderLayout.NORTH);
		
		chk1 = new JCheckBox("사과");
		chk1.addItemListener(this);
		chk1.setSize(new Dimension(50, 50));
		chk1.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(chk1, BorderLayout.WEST);
		
		chk2 = new JCheckBox("배");
		chk2.addItemListener(this);
		chk2.setSize(new Dimension(50, 50));
		chk2.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(chk2, BorderLayout.CENTER);
		
		chk3 = new JCheckBox("체리");
		chk3.addItemListener(this);
		chk3.setSize(new Dimension(50, 50));
		chk3.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(chk3, BorderLayout.EAST);
		
		lbl2 = new JLabel("현재 0원입니다.");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lbl2, BorderLayout.SOUTH);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "Selected/Unselected", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 10, 10));
		
		btn1 = new JButton("사과선택");
		btn1.addActionListener(this);
		pRight.add(btn1);
		
		btn2 = new JButton("배 선택");
		btn2.addActionListener(this);
		pRight.add(btn2);
		
		btn3 = new JButton("체리 선택");
		btn3.addActionListener(this);
		pRight.add(btn3);
		
		btn4 = new JButton("모든 과일 선택");
		btn4.addActionListener(this);
		pRight.add(btn4);
		
		btn5 = new JButton("선택한 과일 확인");
		btn5.addActionListener(this);
		pRight.add(btn5);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			if(e.getItem() == chk1) {
				sum +=100;
				btn1.setText("사과취소");
			}else if(e.getItem() == chk2) {
				sum += 500;
				btn2.setText("배취소");
			}else if(e.getItem() == chk3) {
				sum += 20000;
				btn3.setText("체리취소");
			}
		}else {
			if(e.getItem() == chk1) {
				sum -=100;
				btn1.setText("사과선택");
			}else if(e.getItem() == chk2) {
				sum -= 500;
				btn2.setText("배선택");
			}else if(e.getItem() == chk3) {
				sum -= 20000;
				btn3.setText("체리선택");
			}
		}
		lbl2.setText("현재 "+sum+"원 입니다.");
		if(chk1.isSelected() && chk2.isSelected() && chk3.isSelected()) {
			btn4.setText("모든 과일 취소");
		}else {
			btn4.setText("모든 과일 선택");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn5) {
			btn5ActionPerformed(e);
		}
		if (e.getSource() == btn4) {
			btn4ActionPerformed(e);
		}
		if (e.getSource() == btn3) {
			btn3ActionPerformed(e);
		}
		if (e.getSource() == btn2) {
			btn2ActionPerformed(e);
		}
		if (e.getSource() == btn1) {
			btn1ActionPerformed(e);
		}
	}
	protected void btn1ActionPerformed(ActionEvent e) {
		if(chk1.isSelected()==false) {
			chk1.setSelected(true);
			btn1.setText("사과취소");
		}else {
			chk1.setSelected(false);
			btn1.setText("사과선택");
		}
		
	}
	protected void btn2ActionPerformed(ActionEvent e) {
		if(chk2.isSelected()==false) {
			chk2.setSelected(true);
			btn2.setText("배취소");
		}else {
			chk2.setSelected(false);
			btn2.setText("배선택");
		}
	}
	protected void btn3ActionPerformed(ActionEvent e) {
		if(chk3.isSelected()==false) {
			chk3.setSelected(true);
			btn3.setText("체리취소");
		}else {
			chk3.setSelected(false);
			btn3.setText("체리선택");
		}
	}
	protected void btn4ActionPerformed(ActionEvent e) {
		if(chk1.isSelected()==false || chk2.isSelected()==false || chk3.isSelected()==false) {
			chk1.setSelected(true);
			chk2.setSelected(true);
			chk3.setSelected(true);
			btn4.setText("모든 과일 취소");
		}else if(chk1.isSelected() && chk2.isSelected() && chk3.isSelected()) {
			chk1.setSelected(false);
			chk2.setSelected(false);
			chk3.setSelected(false);
			btn4.setText("모든 과일 선택");
		}
	}
	protected void btn5ActionPerformed(ActionEvent e) {
		if(chk1.isSelected()) {
			if(chk1.isSelected()&&chk2.isSelected()) {
				if(chk1.isSelected()&&chk2.isSelected()&&chk3.isSelected()) {
					JOptionPane.showMessageDialog(null, "선택한 과일은 사과, 배, 체리입니다.");
					return;
				}
				JOptionPane.showMessageDialog(null, "선택한 과일은 사과, 배입니다.");
				return;
			}else if(chk1.isSelected()&&chk3.isSelected()) {
				JOptionPane.showMessageDialog(null, "선택한 과일은 사과, 체리입니다.");
				return;
			}
			JOptionPane.showMessageDialog(null, "선택한 과일은 사과입니다.");
			
		}else if(chk2.isSelected()) {
			if(chk2.isSelected()&&chk3.isSelected()) {
				JOptionPane.showMessageDialog(null, "선택한 과일은 배, 체리입니다.");
				return;
			}
			JOptionPane.showMessageDialog(null, "선택한 과일은 배입니다.");
			
		}else if(chk3.isSelected()) {
			JOptionPane.showMessageDialog(null, "선택한 과일은 체리입니다.");
		}
		
	}
}
