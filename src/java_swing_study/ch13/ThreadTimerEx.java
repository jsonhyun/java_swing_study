package java_swing_study.ch13;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ThreadTimerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTimer;
	private JPanel pbtns;
	private JButton btnStart;
	private JButton btnStop;
	private TimerThread th;
	private GugudanThread guTh;
	private JPanel pLbls;
	private JLabel lblRunableTimer;
	private Thread th2;
	private JPanel pPicker;
	private JLabel lbl;
	private FlickeringLable lblNewLabel;
	private FlickeringLable lblNewLabel_2;

	public ThreadTimerEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		pbtns = new JPanel();
		contentPane.add(pbtns, BorderLayout.SOUTH);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		pbtns.add(btnStart);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		pbtns.add(btnStop);

		
		pLbls = new JPanel();
		contentPane.add(pLbls, BorderLayout.CENTER);
		pLbls.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 80));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		pLbls.add(lblTimer, BorderLayout.CENTER);
		
		lblRunableTimer = new JLabel("");
		lblRunableTimer.setOpaque(true);
		lblRunableTimer.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 80));
		lblRunableTimer.setHorizontalAlignment(SwingConstants.CENTER);
		pLbls.add(lblRunableTimer);
		
		th = new TimerThread(lblTimer);
		guTh = new GugudanThread();
		TimerRunable tr = new TimerRunable(lblRunableTimer);
		
		pPicker = new JPanel();
		pLbls.add(pPicker);
		
		lblNewLabel = new FlickeringLable("깜박",500);
		pPicker.add(lblNewLabel);
		
		lbl = new JLabel("안깜박");
		pPicker.add(lbl);
		
		lblNewLabel_2 = new FlickeringLable("여기도 깜박", 300);
		pPicker.add(lblNewLabel_2);
		th2 = new Thread(tr);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStop) {
			btnStopActionPerformed(e);
		}
		if (e.getSource() == btnStart) {
			btnStartActionPerformed(e);
		}
	}
	protected void btnStartActionPerformed(ActionEvent e) {
//		th = new TimerThread(lblTimer);
		System.out.println(th.getState());
		if(th.getState() == Thread.State.TERMINATED) {
			th = new TimerThread(lblTimer);
		}
		if(guTh.getState()== Thread.State.TERMINATED) {
			guTh = new GugudanThread();
		}
		if(th2.getState()==Thread.State.TERMINATED) {
			th2 = new Thread(new TimerRunable(lblRunableTimer));
		}
		
		th2.start();
		guTh.start();
		th.start();
	}
	protected void btnStopActionPerformed(ActionEvent e) {
		th.interrupt();
	}
}
