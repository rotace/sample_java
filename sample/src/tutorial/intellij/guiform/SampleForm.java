package tutorial.intellij.guiform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Intellij IDEA Design UI Quick Tutorial
 * URL: https://www.youtube.com/watch?v=G4jMzEGMKfg
 * Created by Shibata on 15/11/22.
 */
@SuppressWarnings("Convert2Lambda")
public class SampleForm extends JFrame {
    private JButton clickMeButton;
    private JPanel rootPanel;

    public SampleForm() {
        super("Hello World");

        setContentPane(rootPanel);
        pack();
        //noinspection MagicConstant
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(SampleForm.this, "you clicked the button!");
            }
        });

        setVisible(true);
    }

}
