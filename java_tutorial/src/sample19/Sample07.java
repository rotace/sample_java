package sample19;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sample07 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Long> q = new ArrayDeque<Long>();
		q.offer(1L);
		q.offer(2L);
		q.offer(3L);
		q.offer(4L);
		q.offer(5L);
		q.offer(6L);
		System.out.println(q.poll());
		q.offer(7L);
		while(!q.isEmpty()){
			long data = q.poll();
			System.out.print(data+",");
		}
		System.out.println("");
	}

}
