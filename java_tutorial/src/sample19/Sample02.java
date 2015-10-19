package sample19;

public class Sample02 {
	
	static class Queue {
		final int SIZE = 5;
		private Object[] values = new Object[SIZE+1];
		private int head = 0;
		private int tail = 0;
		
		boolean enqueue(Object data) {
			if ( data == null ) return false;
			if (((tail + 1) % values.length) == head ){
				return false;
			}
			values[tail++] = data;
			tail = tail % values.length;
			return true;
		}
		
		Object dequeue(){
			Object data = null;
			if (tail != head){
				data = values[head++];
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
		Queue q = new Queue();
		q.enqueue(1L);
		q.enqueue(2L);
		q.enqueue(3L);
		q.enqueue(4L);
		q.enqueue(5L);
		q.enqueue(6L);
		System.out.println(q.dequeue());
		q.enqueue(7L);
		while(!q.isEmpty()){
			long data = (Long)q.dequeue();
			System.out.print(data+",");
		}
		System.out.println("");
	}

}
