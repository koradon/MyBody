package application.view.windows.swing.UserLoggin;

import application.model.database.SQLiteDatabase;
import application.model.user.NotLoggedUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Michał on 17.03.2016.
 */
public class UserLoggingWindow extends JFrame {
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();
    private int DEFAULT_WIDTH = screenSize.width;
    private int DEFAULT_HEIGHT = screenSize.height;

    JPanel centerPanel, northPanel, southPanel;
    final JTextField usernameTextField;
    final JPasswordField passwordField;
    final JButton logInButton;

    private NotLoggedUser notLoggedUser;

    @Override
    public void setSize(int width, int height) {
        super.setSize(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2);
    }

    public UserLoggingWindow(){
        this.centerPanel = new JPanel();
        this.northPanel = new JPanel();
        this.southPanel = new JPanel();
        this.usernameTextField = new JTextField();
        this.passwordField = new JPasswordField();
        this.logInButton = new JButton("Log me in!");
        this.notLoggedUser = new NotLoggedUser();

        createNorthPanel();
        createCenterPanel();
        createSouthPanel();

        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);

        pack();
    }



    private void createNorthPanel(){
        northPanel.add(new JLabel(new ImageIcon("images/mainBody.jpg")));
    }

    private void createCenterPanel(){
        centerPanel.setLayout(new GridLayout(2,2));

        addUsernameTextFieldToPanel(centerPanel);
        addPasswordFieldToPanel(centerPanel);
    }

    private void addUsernameTextFieldToPanel(JPanel panel){
        panel.add(new JLabel("Username: ", SwingConstants.RIGHT));
        panel.add(usernameTextField);
    }

    private void addPasswordFieldToPanel(JPanel panel){
        panel.add(new JLabel("Password: ", SwingConstants.RIGHT));
        panel.add(passwordField);
    }

    private void createSouthPanel(){
        addLogInButtonToPanel(southPanel);
    }

    private void addLogInButtonToPanel(JPanel panel){
        panel.add(logInButton);
        setActionWhenLogInButtonPressed();
    }

    private void setActionWhenLogInButtonPressed(){
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readUsernameAndPasswordFields();

                if(logIn()){
                    dispose();
                } else {
                    System.out.println("Invalid password. Try again");
                }
            }
        });
    }

    private void readUsernameAndPasswordFields(){
        notLoggedUser.setUsername(usernameTextField.getText());
        notLoggedUser.setPassword(passwordField.getText());
    }

    public boolean logIn(){
        SQLiteDatabase database = new SQLiteDatabase();

        database.findUserId(notLoggedUser);

        System.out.println("Logged In as: " + notLoggedUser.getUsername());
        return true;
    }
}
