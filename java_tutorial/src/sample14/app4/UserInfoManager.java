package sample14.app4;

public class UserInfoManager {
	private java.util.List userInfoArray = new java.util.ArrayList();
	
	public void add(UserInfo userInfo){
		userInfoArray.add(userInfo);
	}
	public UserInfo get(int id){
		return (UserInfo)userInfoArray.get(id);
	}
	public String getUserName(int id){
		return get(id).name;
	}
	public String getUserEmail(int id){
		return get(id).eMail;
	}
}
