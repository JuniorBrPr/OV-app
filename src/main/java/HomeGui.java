import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomeGui extends JFrame {
    private JPanel homescreen;
    private ImageIcon logo;
    private JLabel logoLabel;
    private JButton Account, Reisplanner, Taal, Home;

    HomeGui() {
        //Change locale to "nl" "NL", to make the homescreen dutch again
        Locale locale = new Locale("us", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);

        getContentPane().setLayout(new FlowLayout());
        homescreen = new JPanel();
        homescreen.setSize(300,40);
        homescreen.setLayout(new GridLayout(1,0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(homescreen, BorderLayout.CENTER);

        Account = new JButton("Account");
        homescreen.add(Account);

        Reisplanner = new JButton(bundle.getString("reisplanner"));
        homescreen.add(Reisplanner, BorderLayout.SOUTH);

        Taal = new JButton(bundle.getString("taal"));
        homescreen.add(Taal);

        JPanel loginScreen = new Login().getLoginScreen(locale);

        JPanel reisplannerScreenTest = new Reisplanner(locale);


        Home = new JButton("Home");
        Home.setBounds(100,60,120,20);
        Home.setVisible(false);
        add(Home, BorderLayout.NORTH);

        add(loginScreen,BorderLayout.CENTER);
        add(reisplannerScreenTest);

        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homescreen.setVisible(true);
                loginScreen.setVisible(false);
                reisplannerScreenTest.setVisible(false);
                Home.setVisible(false);
                repaint();
            }
        });

        Account.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent d) {
                loginScreen.setVisible(true);
                reisplannerScreenTest.setVisible(false);
                homescreen.setVisible(false);
                Home.setVisible(true);
                repaint();
            }
        });

        Reisplanner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginScreen.setVisible(false);
                reisplannerScreenTest.setVisible(true);
                homescreen.setVisible(false);
                Home.setVisible(true);
                repaint();
            }
        });

        Taal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginScreen.setVisible(false);
                reisplannerScreenTest.setVisible(false);
                homescreen.setVisible(false);
                Home.setVisible(true);
                repaint();
            }
        });
    }
}


