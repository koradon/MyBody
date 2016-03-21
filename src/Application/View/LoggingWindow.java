package application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Michał on 17.03.2016.
 */
public class LoggingWindow extends JFrame {
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();
    private int DEFAULT_WIDTH = screenSize.width;
    private int DEFAULT_HEIGHT = screenSize.height;

    @Override
    public void setSize(int width, int height) {
        super.setSize(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2);
    }

    public LoggingWindow(){
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.add(new JLabel(new ImageIcon("images/mainBody.jpg")));

        final JTextField username = new JTextField();
        final JPasswordField password = new JPasswordField();

        centerPanel.setLayout(new GridLayout(2,2));
        centerPanel.add(new JLabel("Username: ", SwingConstants.RIGHT));
        centerPanel.add(username);
        centerPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
        centerPanel.add(password);

        JButton logInButton = new JButton("Log me in!");
        southPanel.add(logInButton);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(logIn(username.getText())){
                    dispose();
                };

            }
        });

        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);

        pack();
    }

    public boolean logIn(String username){
        System.out.println("Logged In as: " + username);
        return true;
    }

}
