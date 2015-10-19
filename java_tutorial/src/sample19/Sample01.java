package sample19;

public class Sample01 {
	
	static class Queue {
		final int SIZE = 5;
		private int[] values = new int[SIZE+1];
		private int head = 0;
		private int tail = 0;
		
		boolean enqueue(int data) {
			if (data < 0) return false;
			if (((tail + 1) % values.length) == head ){
				return false;
			}
			values[tail++] = data;
			tail = tail % values.length;
			return true;
		}
		
		int dequeue(){
			int data = -1;
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
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue());
		q.enqueue(7);
		while(!q.isEmpty()){
			int data = q.dequeue();
			System.out.print(data+",");
		}
		System.out.println("");
	}

}
