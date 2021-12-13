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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Declarations
    private JTextField t1, t2;
    private JButton b1, b2;
    private JLabel l1, l2;
    private JPanel loginScreen;
    private JPanel signUpScreen;
    private JPanel loginScreenView;
    private Json json = new Json();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Maakt de login screen
    public JPanel getLoginScreen(Locale locale){
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);
        signUpScreen = SignUp(locale);
        loginScreenView = new JPanel();
        loginScreenView.setSize(400, 400);
        loginScreenView.setLayout(new FlowLayout());
        loginScreenView.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));
        //set the layout and close: Niels van Gortel

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        loginScreen = new JPanel();
        loginScreen.setSize(400, 400);
        loginScreen.setLayout(new GridLayout(0,1));
        loginScreen.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //set the label login with a font and a color: Niels van Gortel
        l1 = new JLabel(bundle.getString("inloggen"));
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(120,10,300,65);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // makes the textfield and buttons
        t1 = new JTextField(40);
        t2 = new JPasswordField(40);
        b1 = new JButton(bundle.getString("inloggen"));
        b2 = new JButton(bundle.getString("registreren"));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // set the size of the button and the textfield
        t1.setBounds(100,60,90,20);
        t2.setBounds(100,90,90,20);
        b1.setBounds(100,120,90,30);
        b2.setBounds(100,150,90,30);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        l2 = new JLabel("");
        l2.setBounds(250,80,300,30);

        // add the textfield to the frame
        loginScreen.add(l1);
        loginScreen.add(t1);
        loginScreen.add(t2);
        // add the button to the frame
        loginScreen.add(b1);
        loginScreen.add(b2);
        // add the label to the frame
        loginScreen.add(l2);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Makes sure that the button login will make a action
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean matched = false;
                String username = t1.getText().toString();
                String password = t2.getText().toString();

                try {
                    int userId = json.login(username,password);
                    if (userId!=0){
                        matched = true;
                    }
                }catch (Exception e){}

                if(matched){
                    System.out.println("It works");
                    //Yet to add
                }else{
                    l2.setText(bundle.getString("verkeerdeGegevens"));
                }

                /*if(t1.getText().toString().equals("admin") && t2.getText().toString().equals("admin"))
                {
                    //opens a new window
                    dispose();
                    MyFrame g = new MyFrame();
                    g.setBounds(400,200,600,300);
                    g.setVisible(true);
                }
                else
                    l2.setText("Verkeerde gebruikersnaam of wachtwoord");*/
            }
        });
        this.b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                signUpScreen.setVisible(true);
                loginScreen.setVisible(false);
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        this.b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                signUpScreen.setVisible(true);
                loginScreen.setVisible(false);
            }
        });
        loginScreenView.add(signUpScreen);
        loginScreenView.add(loginScreen);

        loginScreen.setVisible(true);
        signUpScreen.setVisible(false);
        loginScreenView.setVisible(false);
        return loginScreenView;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Maakt de sign up screen
    public JPanel SignUp(Locale locale)  {
        JTextField t1, t2;
        JButton b1;
        JLabel l3;
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);

        JPanel signUpScreenView = new JPanel();
        signUpScreenView.setLayout(new GridLayout(0,1));
        signUpScreenView.setSize(400, 300);
        signUpScreenView.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));


        //makes the textfield and button of the registration panel: Niels van Gortel

        t1 = new JTextField(40);
        t2 = new JPasswordField(40);
        b1 = new JButton(bundle.getString("bevestig"));

        t1.setBounds(100,60,90,20);
        t2.setBounds(100,90,90,20);
        b1.setBounds(100, 100, 80, 30);

        l3 = new JLabel(bundle.getString("registratie"));
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        l3.setForeground(Color.BLUE);
//        l3.setBounds(120, 10, 300, 30);
//        l3.setBorder(BorderFactory.createEmptyBorder(60,30,30,30));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Json json = new Json();
                    var user = new User();
                    user.setUserName(t1.getText());
                    user.setPassword(t2.getText());
                    json.addUser(user);
                    Frame f = new JFrame();
                    JOptionPane.showMessageDialog(f, bundle.getString("accountAangemaakt"));
                    signUpScreenView.setVisible(false);
                    loginScreen.setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        signUpScreenView.add(l3);
        signUpScreenView.add(t1);
        signUpScreenView.add(t2);
        signUpScreenView.add(b1);
        signUpScreenView.setVisible(false);
        return signUpScreenView;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
// sets the class and the size of the application