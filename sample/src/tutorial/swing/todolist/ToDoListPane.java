package tutorial.swing.todolist;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("FieldCanBeLocal")
public class ToDoListPane extends JPanel {
	
	
	
	

	private DefaultListModel toDoListModel;

	// JComponents
	private JList toDoList;
	private JTextField toDoInputField;
	private JScrollPane listScrollPane;
	private JPanel buttonPanel;
	
	private JButton addButton;
	private JButton modifyButton;
	private JButton removeButton;
	
	public ToDoListPane() {
		super( new BorderLayout() );
		// 一覧を生成
		toDoListModel = new DefaultListModel();
		toDoList = new JList(toDoListModel);
		listScrollPane = new JScrollPane(toDoList);
		// ToDoリストにリスナを設定
		toDoList.addListSelectionListener(new ToDoListSelectionHandler());
		// ToDo追加用テキストフィールドの生成
		toDoInputField = new JTextField();
		// 各ボタンの生成
		buttonPanel = new JPanel();
		addButton = new JButton("追加");
		modifyButton = new JButton("編集");
		removeButton = new JButton("削除");
		// ボタンにリスナを設定
		addButton.addActionListener(new AddActionHandler());
		modifyButton.addActionListener(new ModifyActionHandler());
		removeButton.addActionListener(new RemoveActionHandler());
		buttonPanel.add(addButton);
		buttonPanel.add(modifyButton);
		buttonPanel.add(removeButton);
		add(listScrollPane, BorderLayout.NORTH);
		add(toDoInputField, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void setButtonsEnabled(boolean enabled) {
		addButton.setEnabled(enabled);
		modifyButton.setEnabled(enabled);
		removeButton.setEnabled(enabled);
	}

	private void doLongTask() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ex) {
		}
	}
	
	public class ToDoListSelectionHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODOリストのどの行も選択されていない場合や，
			// 複数行が選択されている場合は，何もしません
			if (toDoList.getSelectedIndices().length!=1) {
				return;
			}
			toDoInputField.setText((String)toDoList.getSelectedValue());
		}

	}
	
	public class AddActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// テキストフィールドの内容をリストモデルに追加
			toDoListModel.addElement(toDoInputField.getText());
		}

	}
	
	public class ModifyActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// テキストフィールドの内容でリストモデルを編集
			// TODOリストのどの行も選択されていない場合や，
			// 複数行が選択されている場合は，何もしません
			if (toDoList.getSelectedIndices().length!=1) {
				return;
			}
			toDoListModel.set(toDoList.getSelectedIndex(), toDoInputField.getText() );
		}

	}
	
	public class RemoveActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODOリストのどの行も選択されていない場合や，
			// 複数行が選択されている場合は，何もしません
			if (toDoList.getSelectedIndices().length!=1) {
				return;
			}
			setButtonsEnabled(false);
			Thread removeThread = new RemoveThread(toDoList.getSelectedIndex());
			removeThread.start();
		}

	}
	
	public class RemoveThread extends Thread {
		int index;
		RemoveThread(int index) {
			this.index = index;
		}
		public void run() {
			// 時間のかかる処理を実行
			doLongTask();
			// イベントディスパッチスレッドでボタンを変更
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					toDoListModel.remove(index);
					setButtonsEnabled(true);
				}

			});
		}
	}


}
