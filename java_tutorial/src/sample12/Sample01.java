package sample12;

public class Sample01 {
	Object[] o = new Object[3];
	String[] s = new String[3];
	Sample01() {
		
		o[0] = new Object();
		o[1] = new Object();
		o[2] = o[0];
		
		s[0] = new String("s0");
		s[1] = new String("s1");
		s[2] = s[0];
		
	}
	
	void printObjectInfo(String title, Object o){
		System.out.println("printObjectInfo:" + title);
		System.out.println("\t" + o.hashCode());
		System.out.println("\t" + o.toString());
	}
	
	void printStringInfo(String title, String s){
		System.out.println("printStringInfo:" + title);
		System.out.println("\t" + s.hashCode());
		System.out.println("\t" + s.toString());
	}
	
	void printEqual() {
		System.out.println("o[0]:o[1]:"+o[0].equals(o[1]));
		System.out.println("o[0]:o[2]:"+o[0].equals(o[2]));
		System.out.println("o[1]:o[2]:"+o[1].equals(o[2]));
		System.out.println("s[0]:s[1]:"+s[0].equals(s[1]));
		System.out.println("s[0]:s[2]:"+s[0].equals(s[2]));
		System.out.println("s[1]:s[2]:"+s[1].equals(s[2]));
	}
	
	void execGetClass() {
		System.out.println("o[0].getClass():"+o[0].getClass());
		System.out.println("o[1].getClass():"+o[1].getClass());
		System.out.println("o[2].getClass():"+o[2].getClass());
		System.out.println("s[0].getClass():"+s[0].getClass());
		System.out.println("s[1].getClass():"+s[1].getClass());
		System.out.println("s[2].getClass():"+s[2].getClass());
	}
	
	void run(){
		for (int i=0; i<o.length; i++){
			printObjectInfo("o[" + i + "]", o[i]);
		}
		for (int i=0; i<s.length; i++){
			printStringInfo("s[" + i + "]", s[i]);
		}
		for (int i=0; i<o.length; i++){
			printObjectInfo("s[" + i + "]", s[i]);
		}
		printEqual();
		execGetClass();
	}
	
	public static void main(String[] args){
		new Sample01().run();
	}
}
