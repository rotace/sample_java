package sample19;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sample08 {
	
	void print(Queue<?> q){
		while (!q.isEmpty()){
			System.out.print(q.poll()+",");
		}
		System.out.println("");
	}
	
	void exec(){
		Queue<Long> q0 = new ArrayDeque<Long>();
		q0.offer(1L);
		q0.offer(2L);
		q0.offer(3L);
		print(q0);
		Queue<Integer> q1 = new ArrayDeque<Integer>();
		q1.offer(1);
		q1.offer(2);
		q1.offer(3);
		print(q1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sample08 app = new Sample08();
		app.exec();
	}

}
