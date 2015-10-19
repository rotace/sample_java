package sample18;

import java.util.List;

public class Sample05 {

	static class App {

		public void print(Object v) {
			if (v instanceof Integer){
				Integer i = (Integer)v;
				System.out.println("Object -> Integer: " + i);
			} else {
				System.out.println(v.toString());
			}
		}

		public List createList() {
			return new java.util.LinkedList();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App app = new App();
		java.util.List list = app.createList();
		list.add(Integer.valueOf(1));
		list.add(Boolean.valueOf(true));
		list.add((Object)"Hello");
		list.add(app);
		
		for(Object o: list){
			app.print(o);
		}
		app  = null;
		list = null;
	}

}
