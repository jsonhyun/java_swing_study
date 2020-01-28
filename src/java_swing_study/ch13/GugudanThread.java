package java_swing_study.ch13;

public class GugudanThread extends Thread {

	@Override
	public void run() {
		try {
			for(int i=2;i<10;i++) {
				for(int c =1;c<10;c++) {
					System.out.printf("%d*%d = %2d%n", i, c, i*c);
					sleep(1000);
				}
			}
		}catch (InterruptedException e) {
			return;
		}
	}
}

