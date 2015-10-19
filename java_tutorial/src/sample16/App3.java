package sample16;

public class App3 {
	
	class ResultView {
		
		public long getStartTime() {
			return startTime;
		}

		public void setStartTime(long startTime) {
			this.startTime = startTime;
		}

		public long getStopTime() {
			return stopTime;
		}

		public void setStopTime(long stopTime) {
			this.stopTime = stopTime;
		}

		public int getStartValue() {
			return startValue;
		}

		public void setStartValue(int startValue) {
			this.startValue = startValue;
		}

		long startTime;
		long stopTime;
		int startValue;

		void update() {
		System.out.println("");
		System.out.println("開始時刻：" + startTime);
		System.out.println("カウント：" + startValue);
		System.out.println("終了時刻：" + stopTime);
		}

	}



	class ProgressView {

		private int count;
		private String printValue = "";

		public void countUp(int v) {
			count += v;
			StringBuilder sb = new StringBuilder();
			for ( int i=0; i<v; i++){
				sb.append(".");
			}
			printValue  = sb.toString();
		}

		public void update() {
			System.out.print(printValue);
			if (count % 10 == 0 && count != 0){
				System.out.println("");
			}
		}
		

	}
	

	final static long INTERVAL = 1000;
	private ResultView resultView = new ResultView();
	private ProgressView progressView = new ProgressView();
	private int count;
	
	public App3() {
		count = 12;
		resultView.setStartValue(count);
	}
	
	public void execute() throws Exception {
		resultView.setStartTime(System.currentTimeMillis());
		while (count > 0){
			Thread.sleep(INTERVAL);
			count --;
			progressView.countUp(1);
			progressView.update();
		}
		resultView.setStopTime(System.currentTimeMillis());
		resultView.update();

	}
	
	public static void main(String[] args)
	throws Exception {
		App3 app = new App3();
		app.execute();
	}

}
