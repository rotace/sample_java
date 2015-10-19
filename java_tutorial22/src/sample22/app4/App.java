package sample22.app4;

public class App {
	
	public static class User {
		
		private String name;
		
		public User(String name){
			this.name = name;
		}

		@Deprecated
		public String get_name() {
			return getName();
		}

		public String getName() {
			return name;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user1 = new User("koyama");
		User user2 = new User("shibata");
		System.out.println(user1.get_name());
		System.out.println(user2.getName());

	}

}
