package sample20;

public class Sample06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.ArrayList<String> setExpression = new java.util.ArrayList<String>();
		setExpression.add("第一回");
		setExpression.add("第二回");
		setExpression.add("第三回");
		setExpression.add("第四回");
		setExpression.add("第五回");
		for (String element : setExpression){
			if("第二回".equals(element)) {
				continue;
			}
			System.out.println(element);
		}

	}

}