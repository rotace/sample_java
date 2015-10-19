package sample19;

public class Sample04 {
	
	public static void main(String[] args) {
		Sample03.Queue<Integer> q = new Sample03.Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue());
		q.enqueue(7);
		while(!q.isEmpty()){
			long data = q.dequeue();
			System.out.print(data+",");
		}
		System.out.println("");
	}

}
