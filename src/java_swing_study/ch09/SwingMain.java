package java_swing_study.ch09;

import java.awt.EventQueue;

public class SwingMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentPaneExcercise frame = new ContentPaneExcercise();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
