package java_swing_study.ch14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OptionPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel ptop;
	private JPanel pCenter;
	private JPanel pPopupDlg;
	private JPanel pFileDlg;
	private JPanel pColorDlg;
	private JButton btnPopupInput;
	private JButton btnPopupConfirm;
	private JButton btnPopupMsg;
	private JLabel lblPopup;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionPaneEx frame = new OptionPaneEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OptionPaneEx() {
		initialize();
	}
	private void initialize() {
		setTitle("팝업 다이얼로그, 파일 다이얼로그, 컬러 다이얼로그");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ptop = new JPanel();
		contentPane.add(ptop, BorderLayout.NORTH);
		ptop.setLayout(new GridLayout(0, 3, 0, 0));
		
		pPopupDlg = new JPanel();
		pPopupDlg.setBorder(new TitledBorder(null, "\uD31D\uC5C5 \uB2E4\uC774\uC5BC\uB85C\uADF8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ptop.add(pPopupDlg);
		pPopupDlg.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnPopupInput = new JButton("입력 다이얼로그");
		
		pPopupDlg.add(btnPopupInput);
		
		btnPopupConfirm = new JButton("확인 다이얼로그");
		
		pPopupDlg.add(btnPopupConfirm);
		
		btnPopupMsg = new JButton("메시지 다이얼로그");
		
		pPopupDlg.add(btnPopupMsg);
		
		lblPopup = new JLabel("New label");
		lblPopup.setHorizontalAlignment(SwingConstants.CENTER);
		pPopupDlg.add(lblPopup);
		
		pFileDlg = new JPanel();
		ptop.add(pFileDlg);
		
		pColorDlg = new JPanel();
		ptop.add(pColorDlg);
		
		pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		btnPopupInput.addActionListener(this);
		btnPopupConfirm.addActionListener(this);
		btnPopupMsg.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPopupConfirm) {
			btnPopupConfirmActionPerformed(e);
		}
		if (e.getSource() == btnPopupInput) {
			btnPopupInputActionPerformed(e);
		}
		if (e.getSource() == btnPopupMsg) {
			btnPopupMsgActionPerformed(e);
		}
	}
	
	protected void btnPopupMsgActionPerformed(ActionEvent e) {
		ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\images\\icon1.png");
		JOptionPane.showMessageDialog(null, "열심히", "자바 프로젝트", JOptionPane.ERROR_MESSAGE, icon);
	}
	
	protected void btnPopupInputActionPerformed(ActionEvent e) {
		
//		parentComponent the parent Component for thedialog
//		message the Object to display
//		title the String to display in thedialog title bar
//		messageType the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, 
//		WARNING_MESSAGE, QUESTION_MESSAGE,or PLAIN_MESSAGE
//		icon the Icon image to display
//		selectionValues an array of Objects thatgives the possible selections
//		initialSelectionValue the value used to initialize the inputfield
		
		String[] selectionValues = {"국어","영어","수학"};
		String res = (String)JOptionPane.showInputDialog(this, "과목을 선택하세요", "과목 선택", JOptionPane.QUESTION_MESSAGE, null, selectionValues, selectionValues[0]);
		if(res==null) {
			lblPopup.setText("선택없음");
			return;
		}
		lblPopup.setText(res);
	}
	
	protected void btnPopupConfirmActionPerformed(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(this, "잠오니 상원아?", "졸음 체크", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		System.out.println(res);
		if(res == JOptionPane.YES_OPTION) {
			lblPopup.setText("예");
		}
		if(res == JOptionPane.NO_OPTION) {
			lblPopup.setText("아니오");
		}
		if(res == JOptionPane.CANCEL_OPTION) {
			lblPopup.setText("취소");
		}
		if(res == JOptionPane.CLOSED_OPTION) {
			lblPopup.setText("창을 닫음");
		}
	}
}














