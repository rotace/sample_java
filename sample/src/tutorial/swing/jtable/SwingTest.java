package tutorial.swing.jtable;

import javax.swing.*;
import java.awt.*;

/**
 * Test
 * Created by Yasunori on 2015/12/30.
 */
public class SwingTest extends JFrame {

    private String[][] tabledata = {
            {"日本", "３勝", "０敗", "１分"},
            {"クロアチア", "３勝", "１敗", "０分"},
            {"オーストラリア", "１勝", "２敗", "０分"},
            {"ブラジル", "２勝", "２敗", "０分"}
    };

    private String[] columnNames = {"COUNTRY", "WIN", "LOST", "EVEN"};

    public static void main(String[] args) {
        SwingTest test = new SwingTest("SwingTest");

        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }

    SwingTest(String title) {
        setTitle(title);
        setBounds(10,10,300,200);

        JTable table = new JTable(tabledata, columnNames);

        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(250, 70));

        JPanel p = new JPanel();
        p.add(sp);

        getContentPane().add(p, BorderLayout.CENTER);
    }
}
