package sample14.app1;

public class App {
	public static void main(String[] args){
		UserInfo u = new UserInfo();
		u.name = "taro";
		u.eMail = u.name + "@example.jp";
		UserInfoManager manager = new UserInfoManager();
		manager.userInfoArray[0] = u;
		System.out.println(manager.userInfoArray[0].name);
		System.out.println(manager.userInfoArray[0].eMail);
	}
}
