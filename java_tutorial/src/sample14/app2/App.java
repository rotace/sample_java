package sample14.app2;

public class App {
	public static void main(String[] args){
		UserInfo u = new UserInfo();
		u.name = "taro";
		u.eMail = u.name + "@example.jp";
		UserInfoManager manager = new UserInfoManager();
		
		manager.userInfoArray.add(u);
		UserInfo u0 = (UserInfo)manager.userInfoArray.get(0);
		System.out.println(u0.name);
		System.out.println(u0.eMail);
	}
}
