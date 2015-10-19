package sample24;

public class SampleApp2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] users = { "Sara", "Akira", "Akira", "Jacky", "" };
		String[] passwords = { "?", "777", "111", "abc", "xyz" };
		SampleUserList2 sample = new SampleUserList2();
		
		for (int i=0; i<users.length; i++){
			try {
				System.err.print("i=" + i + ":");
				boolean isLogin = sample.login(users[i], passwords[i]);
				if (isLogin){
					System.err.println("ログインに成功しました（" + users[i] + "）");
				} else {
					System.err.println("ログインに失敗しました");
				}
			} catch(SampleException3 e) {
				e.printStackTrace();
			}
			System.err.println("");
		}

	}

}
