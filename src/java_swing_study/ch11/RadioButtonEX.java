package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RadioButtonEX extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JPanel pRdbBtns;
	private JPanel pLblImg;
	private JRadioButton rdbtnApple;
	private JRadioButton rdbtnPear;
	private JRadioButton rdbtnCherry;
	private JLabel lblImg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private HashMap<String, ImageIcon> icons;
	private JButton btnApple;
	private JButton btnPear;
	private JButton btnCherry;
	private JButton btnConfirm;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButtonEX frame = new RadioButtonEX();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RadioButtonEX() {
		icons = new HashMap<String, ImageIcon>();
		String imgDirPath = System.getProperty("user.dir")+"\\images\\";
		icons.put("사과", new ImageIcon(imgDirPath+"apple.jpg"));
		icons.put("배", new ImageIcon(imgDirPath+"pear.jpg"));
		icons.put("체리", new ImageIcon(imgDirPath+"cherry.jpg"));
		initialize();
	}
	private void initialize() {
		setTitle("라디오버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "라디오버튼 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));
		
		pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pRdbBtns = new JPanel();
		pLeft.add(pRdbBtns, BorderLayout.NORTH);
		
		rdbtnApple = new JRadioButton("사과");
		buttonGroup.add(rdbtnApple);
		pRdbBtns.add(rdbtnApple);
		
		rdbtnPear = new JRadioButton("배");
		buttonGroup.add(rdbtnPear);
		pRdbBtns.add(rdbtnPear);
		
		rdbtnCherry = new JRadioButton("체리");
		buttonGroup.add(rdbtnCherry);
		pRdbBtns.add(rdbtnCherry);
		
		pLblImg = new JPanel();
		pLblImg.setBorder(new EmptyBorder(10, 10, 10, 10));
		pLeft.add(pLblImg, BorderLayout.CENTER);
		pLblImg.setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		pLblImg.add(lblImg, BorderLayout.CENTER);
		
		pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnApple = new JButton("사과 선택");
		btnApple.addActionListener(this);
		pRight.add(btnApple);
		
		btnPear = new JButton("배 선택");
		btnPear.addActionListener(this);
		pRight.add(btnPear);
		
		btnCherry = new JButton("체리 선택");
		btnCherry.addActionListener(this);
		pRight.add(btnCherry);
		
		btnConfirm = new JButton("선택한 과일 확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);
		
		textField = new JTextField();
		textField.setText("하이");
		pRight.add(textField);
		textField.setColumns(10);
		
		rdbtnApple.addItemListener(this);
		rdbtnPear.addItemListener(this);
		rdbtnCherry.addItemListener(this);
		rdbtnApple.setSelected(true);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbtnCherry) {
			rdbtnCherryItemStateChanged(e);
		}
		if (e.getSource() == rdbtnPear) {
			rdbtnPearItemStateChanged(e);
		}
		if (e.getSource() == rdbtnApple) {
			rdbtnAppleItemStateChanged(e);
		}
	}
	protected void rdbtnAppleItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, rdbtnApple.getText());
			lblImg.setIcon(icons.get(rdbtnApple.getText()));
		}
	}
	protected void rdbtnPearItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, ((JRadioButton)e.getItem()).getText());
			lblImg.setIcon(icons.get(rdbtnPear.getText()));
		}
	}
	protected void rdbtnCherryItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, ((JRadioButton)e.getItem()).getText());
			lblImg.setIcon(icons.get(rdbtnCherry.getText()));
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnApple) {
			btnAppleActionPerformed(e);
		}
		if (e.getSource() == btnPear) {
			btnPearActionPerformed(e);
		}
		if (e.getSource() == btnCherry) {
			btnCherryActionPerformed(e);
		}
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
		
	}
	protected void btnAppleActionPerformed(ActionEvent e) {
		rdbtnApple.setSelected(true);
	}
	protected void btnPearActionPerformed(ActionEvent e) {
		rdbtnPear.setSelected(true);
	}
	protected void btnCherryActionPerformed(ActionEvent e) {
		rdbtnCherry.setSelected(true);
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		if(rdbtnApple.isSelected()) {
			JOptionPane.showMessageDialog(null, "사과");
		}else if(rdbtnPear.isSelected()) {
			JOptionPane.showMessageDialog(null, "배");
		}else {
			JOptionPane.showMessageDialog(null, "체리");
		}
	}
	
}
