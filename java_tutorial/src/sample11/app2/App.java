package sample11.app2;

public class App {

	public static void main(String[] args) {
		AppInfo appInfo = new AppInfo("サンプルアプリ", 1, 0);
		Message message = new Message(appInfo);
		message.print("Hello");
		Calc calc = new Calc();
		calc.exec(appInfo);
	}

}
