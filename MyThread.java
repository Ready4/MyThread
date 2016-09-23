public class MyThread extends Thread {

	private long startTime;
	private int _ta;
	private int _tw;
	private String _message;

	public MyThread(int ta, int tw, String message) {
		_ta = ta;
		_tw = tw;
		_message = message;
	}

	@Override
	public void run() {
		startTime = System.currentTimeMillis();
		while (true) {
			try {
				if (_tw <= System.currentTimeMillis() - startTime) {
					this.interrupt();
					return;
				}

				System.out.println(_message);
				Thread.sleep(_ta);
			} catch (Exception e) {
				System.err.println("init6");
			}

		}

	}

	public static void main(String[] args) {

		MyThread thread = new MyThread(2000, 6000, "ACCESS GRANTED");

		thread.run();

	}

}
