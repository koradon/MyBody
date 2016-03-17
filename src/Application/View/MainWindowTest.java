package Application.View;

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
                final AddBodyDataWindow addBodyDataWindow = new AddBodyDataWindow();
                addBodyDataWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addBodyDataWindow.setTitle("MyBody! - Log your body");
                addBodyDataWindow.setVisible(false);


                LoggingWindow loggingFrame = new LoggingWindow();
                loggingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loggingFrame.setTitle("MyBody!");
                loggingFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(final WindowEvent e) {
                        super.windowDeactivated(e);
                        //test if login successful
                        addBodyDataWindow.setVisible(true);

                    }
                });
                loggingFrame.setVisible(true);



            }
        });
    }
}
