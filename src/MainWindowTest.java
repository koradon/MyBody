import javax.swing.*;
import java.awt.*;

/**
 * Created by Michał on 17.03.2016.
 */
public class MainWindowTest {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setTitle("My Main Window1");
                mainWindow.setVisible(true);
            }
        });
    }
}
