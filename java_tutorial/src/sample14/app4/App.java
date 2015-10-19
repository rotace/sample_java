package sample14.app4;

public class App {
	public static void main(String[] args){
		UserInfo u = new UserInfo();
		u.name = "taro";
		u.eMail = u.name + "@example.jp";
		UserInfoManager manager = new UserInfoManager();
		
		manager.add(u);
		System.out.println(manager.getUserName(0));
		System.out.println(manager.getUserEmail(0));
		
//		アクセスできないフィールド
//		manager.userInfoArray.add(u);
	}
}
