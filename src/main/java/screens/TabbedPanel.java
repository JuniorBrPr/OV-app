package screens;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class TabbedPanel {
    JTabbedPane mainPanel;
    JPanel login;
    Reisplanner reisplanner;
    Login loginInstance = new Login();


    JTabbedPane TabbedPane(Locale locale, int userId) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);
        mainPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        login = loginInstance.getLoginScreen(locale, userId);
        reisplanner = new Reisplanner(locale);
        login.setVisible(true);
        reisplanner.setVisible(true);
        mainPanel.addTab(bundle.getString("reisplanner"), reisplanner);
        mainPanel.addTab(bundle.getString("account"), login);
        return mainPanel;
    }
}