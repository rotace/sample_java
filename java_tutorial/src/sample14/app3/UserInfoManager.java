package sample14.app3;

public class UserInfoManager {
	java.util.List userInfoArray = new java.util.ArrayList();
	
	void add(UserInfo userInfo){
		userInfoArray.add(userInfo);
	}
	UserInfo get(int id){
		return (UserInfo)userInfoArray.get(id);
	}
	String getUserName(int id){
		return get(id).name;
	}
	String getUserEmail(int id){
		return get(id).eMail;
	}
}
