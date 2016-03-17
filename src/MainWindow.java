import javax.swing.*;
import java.awt.*;

/**
 * Created by Michał on 17.03.2016.
 */
public class MainWindow extends JFrame {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    private int DEFAULT_WIDTH = screenSize.width;
    private int DEFAULT_HEIGHT = screenSize.height;

    @Override
    public void setSize(int width, int height) {
        super.setSize(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2);
    }

    public MainWindow(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


}
