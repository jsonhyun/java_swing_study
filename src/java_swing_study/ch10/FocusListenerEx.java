package java_swing_study.ch10;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.omg.CORBA.INTERNAL;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FocusListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblNo;
	private JTextField tfNo;
	private JLabel lblDept;
	private JTextField tfDept;
	private JLabel lblSubj;
	private JTextField tfSubj;
	private JLabel lblRes;
	private JPasswordField pw1;
	private JPasswordField pw2;
	private JLabel lblConfirm;
	private JButton btnOk;
	private JButton btnCancel;

	public FocusListenerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setSize(300, 200);
//		setLocation(100, 100);
		setBounds(100, 100, 300, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				msg();
			}
			
			public void msg() {
				lblRes.setText(String.format("%s 길이 : %d", tfName.getText(), tfName.getText().length()));
			}
		});
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		lblNo = new JLabel("학번");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(tfNo.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "학번을 입력하세요.");
					tfNo.requestFocus();
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
				
			}
		});
		tfNo.setColumns(10);
		contentPane.add(tfNo);
		
		lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		contentPane.add(tfDept);
		
		lblSubj = new JLabel("과목");
		lblSubj.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubj);
		
		tfSubj = new JTextField();
		tfSubj.setColumns(10);
		contentPane.add(tfSubj);
		
		tfSubj.setRequestFocusEnabled(true);
		
		lblRes = new JLabel("이름필드 글자수");
		contentPane.add(lblRes);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 20));
		lblConfirm.setForeground(Color.RED);
		contentPane.add(lblConfirm);
		
		pw1 = new JPasswordField();
		pw1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkPass();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkPass();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				checkPass();
				
			}

			private void checkPass() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				System.out.printf("pw1 : %s pw2 : %s%n", pass1, pass2);
				
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				}else {
					lblConfirm.setText("일치하지 않음");
				}
			}
		});
		contentPane.add(pw1);
		
		pw2 = new JPasswordField();
		pw2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();
				
			}

			private void isEqualPw() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				System.out.printf("pw1 : %s pw2 : %s%n", pass1, pass2);
				
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
					
				}else {
					lblConfirm.setText("일치하지 않음");
				}
			}
		});
		contentPane.add(pw2);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		contentPane.add(btnOk);
		
		btnCancel = new JButton("취소");
		contentPane.add(btnCancel);
	}
	
	public JTextField getTfSubj() {
		return tfSubj;
	}

	
	public static void main(String[] args) {
		FocusListenerEx frame = new FocusListenerEx();
		frame.setVisible(true);
		
		frame.getTfSubj().requestFocus();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		String name = tfName.getText().trim();
		int stdNo = Integer.parseInt(tfNo.getText().trim());
		String dept = tfDept.getText().trim();
		String subj = tfSubj.getText().trim();
		Student student = new Student(name, stdNo, dept, subj);
//		student.getName(),student.getStdNo(), student.getDept(),student.getSubj()
		JOptionPane.showMessageDialog(null, student.toString());
	}
}


