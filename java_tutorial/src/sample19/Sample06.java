package sample19;

import java.util.List;
import java.util.LinkedList;

public class Sample06 {
	
	static class Queue<T> {
		final int SIZE = 5;
		private List<T> values = new LinkedList<T>();
		
		boolean enqueue(T data) {
			if ( data == null ) return false;
			if (values.size() == SIZE){
				return false;
			}
			values.add(data);
			return true;
		}
		
		T dequeue(){
			T data = null;
			if (values.size() != 0){
				data = values.remove(0);
			}
			return data;
		}
		
		boolean isEmpty(){
			return (values.size() == 0);
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Long> q = new Queue<Long>();
		q.enqueue(1L);
		q.enqueue(2L);
		q.enqueue(3L);
		q.enqueue(4L);
		q.enqueue(5L);
		q.enqueue(6L);
		System.out.println(q.dequeue());
		q.enqueue(7L);
		while(!q.isEmpty()){
			long data = q.dequeue();
			System.out.print(data+",");
		}
		System.out.println("");
	}

}
