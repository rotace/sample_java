package sample17;


public class App4 {
	
	class RemainView implements Observer {

		@Override
		public void update() {
			System.out.println("残り時間：" + count + "[sec]");
		}

	}


	class Observable {
		java.util.List observers = new java.util.LinkedList();
		void addObserver(Observer o){
			observers.add(o);
		}
		void notifyObservers(){
			for (int i=0; i<observers.size(); i++){
				Observer o = (Observer)observers.get(i);
				o.update();
			}
		}
	}


	interface Observer {
		void update();
	}


	class ResultView implements Observer {
		
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

		@Override
		public void update() {
		System.out.println("");
		System.out.println("開始時刻：" + startTime);
		System.out.println("カウント：" + startValue);
		System.out.println("終了時刻：" + stopTime);
		}

	}



	class ProgressView implements Observer {

		int count = 0;
		String printValue = "";

		public void countUp(int v) {
			count += v;
			printValue = String.valueOf(count);
		}

		@Override
		public void update() {
			System.out.print("\n\n経過時間:");
			System.out.print(printValue + "[sec]");
		}
		

	}
	

	final static long INTERVAL = 1000;
	ResultView resultView = new ResultView();
	ProgressView progressView = new ProgressView();
	Observable view = new Observable();
	int count;
	
	App4() {
		count = 12;
		resultView.setStartValue(count);
		view.addObserver(progressView);
		view.addObserver(resultView);
	}
	
	public void execute() throws Exception {
		resultView.setStartTime(System.currentTimeMillis());
		while (count > 0){
			Thread.sleep(INTERVAL);
			count --;
			progressView.countUp(1);
			view.notifyObservers();
		}
		resultView.setStopTime(System.currentTimeMillis());
		view.notifyObservers();

	}
	
	public static void main(String[] args)
	throws Exception {
		App4 app = new App4();
		app.execute();
	}

}
