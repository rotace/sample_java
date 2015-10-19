package sample19;

public class Sample03 {
	
	static class Queue<T> {
		final int SIZE = 5;
		private Object[] values = new Object[SIZE+1];
		private int head = 0;
		private int tail = 0;
		
		boolean enqueue(T data) {
			if ( data == null ) return false;
			if (((tail + 1) % values.length) == head ){
				return false;
			}
			values[tail++] = data;
			tail = tail % values.length;
			return true;
		}
		
		T dequeue(){
			T data = null;
			if (tail != head){
				data = (T)values[head++];
				head = head % values.length;
			}
			return data;
		}
		
		boolean isEmpty(){
			return (tail == head);
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
