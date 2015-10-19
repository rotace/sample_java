package sample14.app5;

public class App {
	public static void main(String[] args){
		UserInfo u = new UserInfo();
		u.setName("taro");
		u.seteMail(u.getName() + "@example.jp");
		UserInfoManager manager = new UserInfoManager();
		
		manager.add(u);
		System.out.println(manager.getUserName(0));
		System.out.println(manager.getUserEmail(0));
		
//		アクセスできないフィールド
//		manager.userInfoArray.add(u);
	}
}
