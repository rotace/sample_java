package sample20;

import java.util.Iterator;

public class Sample05 {
	
	
	static class SampleIterable implements Iterable<String> {
		@Override
		public Iterator<String> iterator() {
			return new SampleIterator();
		}
	}



	static class SampleIterator implements Iterator<String> {
		
		private java.util.Iterator<String> it;
		
		public SampleIterator() {
			java.util.ArrayList<String> list = new java.util.ArrayList<String>();
			list.add("第一回");
			list.add("第二回");
			list.add("第三回");
			list.add("第四回");
			list.add("第五回");
			it = list.iterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public String next() {
			return it.next();
		}

		@Override
		public void remove() {
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleIterable iterable = new SampleIterable();
		for (String element : iterable){
			System.out.println(element);
		}

	}

}
