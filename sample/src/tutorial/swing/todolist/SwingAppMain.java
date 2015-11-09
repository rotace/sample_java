package tutorial.swing.todolist;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



/**
 * 【連載】SwingでJavaに強くなる
 *  URL: http://www.atmarkit.co.jp/fjava/index/index_swing.html
 */
public class SwingAppMain {

	public static void main(String[] args) {
		
		System.out.println("main : "
				+ SwingUtilities.isEventDispatchThread() );
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowTodoList();
				
			}
			
			}
		);

	}
	
	private static void createAndShowTodoList() {
		System.out.println("createAndShowToDoList : "
				+ SwingUtilities.isEventDispatchThread() );
		
		JFrame mainFrame = new JFrame("Todo List");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = mainFrame.getContentPane();
		// Todo List を作成
		JComponent newContentPane = new ToDoListPane();
		contentPane.add(newContentPane, BorderLayout.CENTER);
		// Windowsサイズを調整
		mainFrame.pack();
		// 表示
		mainFrame.setVisible(true);
	}

}
