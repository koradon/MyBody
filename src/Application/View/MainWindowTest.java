package application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Michał on 17.03.2016.
 */
public class MainWindowTest {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                final AddNewBodyToDatabaseWindow addBodyDataWindow = new AddNewBodyToDatabaseWindow();
                addBodyDataWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addBodyDataWindow.setTitle("MyBody! - Log your body");
                addBodyDataWindow.setVisible(false);


                UserLoggingWindow loggingFrame = new UserLoggingWindow();
                loggingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loggingFrame.setTitle("MyBody!");
                loggingFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(final WindowEvent e) {
                        super.windowDeactivated(e);
                        addBodyDataWindow.setVisible(true);

                    }
                });
                loggingFrame.setVisible(true);



            }
        });
    }
}
