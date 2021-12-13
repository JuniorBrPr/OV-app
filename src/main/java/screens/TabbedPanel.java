package screens;

import javax.swing.*;
import java.util.Locale;

public class TabbedPanel {
    JTabbedPane mainPanel;
    JPanel login;
    Reisplanner reisplanner;
    Locale locale;

    JTabbedPane TabbedPanel(){
        locale = new Locale("us", "US");
        mainPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        login = new Login().getLoginScreen(locale);
        reisplanner = new Reisplanner(locale);
        login.setVisible(true);
        reisplanner.setVisible(true);

        mainPanel.addTab("Reisplanner", reisplanner);
        mainPanel.addTab("Account", login);

        return mainPanel;
    }
}
