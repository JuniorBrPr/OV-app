package screens;

import json.Json;
import json.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;


// makes the class for SignUp


public class Login
{

    //Declarations
    private JTextField t1, t2;
    private JButton b1, b2;
    private JLabel l1, l2;
    private JPanel loginScreen;
    private JPanel signUpScreen;
    private JPanel loginScreenView;
    private JPanel accountScreen;
    private Json json = new Json();
    private int userIdInstance = 0;
    private boolean matched = false;

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public int getUserId() {
        return userIdInstance;
    }

    public void setUserId(int userId) {
        this.userIdInstance = userId;
    }

    //Maakt de login screen
    public JPanel getLoginScreen(Locale locale, int userId){
        if(userId!=0){
            setMatched(true);
        }


        setUserId(userId);
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);
        signUpScreen = SignUp(locale);
        accountScreen = account(locale, userId);


        loginScreenView = new JPanel();
        loginScreenView.setSize(400, 400);
        loginScreenView.setLayout(new FlowLayout());
        loginScreenView.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));
        //set the layout and close: Niels van Gortel

        loginScreen = new JPanel();
        loginScreen.setLayout(new GridLayout(0,1));
        loginScreen.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));

        //set the label login with a font and a color: Niels van Gortel
        l1 = new JLabel(bundle.getString("inloggen"));
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(120,10,300,65);

        // makes the textfield and buttons
        t1 = new JTextField(40);
        t2 = new JPasswordField(40);
        b1 = new JButton(bundle.getString("inloggen"));
        b2 = new JButton(bundle.getString("registreren"));

        l2 = new JLabel("");

        // add the textfield to the frame
        loginScreen.add(l1);
        loginScreen.add(t1);
        loginScreen.add(t2);
        // add the button to the frame
        loginScreen.add(b1);
        loginScreen.add(b2);
        // add the label to the frame
        loginScreen.add(l2);

        //Makes sure that the button login will make a action
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username = t1.getText().toString();
                String password = t2.getText().toString();

                try {
                    int userIdGet = json.login(username,password);
                    setUserId(userIdGet);
                    if (userIdGet!=0){
                        matched = true;
                        userIdInstance = userIdGet;
                    }
                }catch (Exception e){}

                if(matched){
                    System.out.println("It works");
                    System.out.println(json.getUser(userIdInstance).getUserName());
                    System.out.println("UserId: "+userIdInstance);
                    l2.setText("");
                    loginScreen.setVisible(false);
                    signUpScreen.setVisible(false);
                    accountScreen = account(locale, userIdInstance);
                    accountScreen.setVisible(true);
                    loginScreenView.add(accountScreen);
                    loginScreenView.revalidate();
                    //Yet to add
                }else{
                    l2.setText(bundle.getString("verkeerdeGegevens"));
                }
            }
        });
        this.b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                signUpScreen.setVisible(true);
                loginScreen.setVisible(false);
            }
        });

        this.b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                signUpScreen.setVisible(true);
                loginScreen.setVisible(false);
            }
        });

        loginScreenView.add(signUpScreen);
        loginScreenView.add(loginScreen);
        loginScreenView.add(accountScreen);

        loginScreen.setVisible(true);
        signUpScreen.setVisible(false);
        loginScreenView.setVisible(false);

        if(matched){
            System.out.println("It works");
            l2.setText("");
            loginScreen.setVisible(false);
            signUpScreen.setVisible(false);
            accountScreen = account(locale, userId);
            accountScreen.setVisible(true);
            loginScreenView.add(accountScreen);
            loginScreenView.revalidate();
        }

        return loginScreenView;
    }

    //Maakt de sign up screen
    public JPanel SignUp(Locale locale)  {
        JTextField t1, t2;
        JButton b1;
        JLabel l3,l4;
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);

        JPanel signUpScreenView = new JPanel();
        signUpScreenView.setLayout(new GridLayout(0,1));
        signUpScreenView.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));


        //makes the textfield and button of the registration panel: Niels van Gortel

        t1 = new JTextField(40);
        t2 = new JPasswordField(40);
        b1 = new JButton(bundle.getString("bevestig"));

        l3 = new JLabel(bundle.getString("registratie"));
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        l3.setForeground(Color.BLUE);

        l4 = new JLabel();
        l4.setFont(new Font("Arial", Font.BOLD, 10));
        l4.setForeground(Color.RED);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Json json = new Json();
                    if(t1.getText().length()!=0 && t2.getText().length()!=0) {

                        var user = new User();
                        user.setUserName(t1.getText());
                        user.setPassword(t2.getText());
                        json.addUser(user);
                        Frame f = new JFrame();
                        JOptionPane.showMessageDialog(f, bundle.getString("accountAangemaakt"));
                        signUpScreenView.setVisible(false);
                        loginScreen.setVisible(true);
                    }else {
                        l4.setText("Invalid input");

                    }
                } catch (Exception e) {
                }
            }
        });

        signUpScreenView.add(l3);
        signUpScreenView.add(t1);
        signUpScreenView.add(t2);
        signUpScreenView.add(b1);
        signUpScreenView.add(l4);
        signUpScreenView.setVisible(false);
        return signUpScreenView;

    }

    public JPanel account (Locale locale, int userId){
        accountScreen = new JPanel();
        accountScreen.setLayout(new FlowLayout());
        accountScreen.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));
        accountScreen.setPreferredSize(new Dimension(650, 550));

        accountScreen.setBackground(Color.CYAN);

        User user = json.getUser(userId);
        JLabel userName = new JLabel(user.getUserName());
        userName.setFont(new Font("Arial",Font.BOLD,30));


        JButton logOut = new JButton("logout");
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUserId(0);
                matched = false;
                loginScreenView.remove(accountScreen);
                accountScreen.setVisible(false);
                signUpScreen.setVisible(false);
                loginScreen.setVisible(true);
                loginScreenView.revalidate();
                loginScreenView.repaint();
            }
        });


        accountScreen.add(userName);
        accountScreen.add(logOut);
        accountScreen.setVisible(false);
        return accountScreen;
    }
}
// sets the class and the size of the application