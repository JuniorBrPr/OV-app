package screens;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class HomeGui extends JFrame {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Declarations
    private JPanel homescreen;
    private ImageIcon logo;
    private JLabel logoLabel;
    private JButton Account, Reisplanner, Taal, Home;
    private JTabbedPane mainPanel;
    private Locale baseLocale;
    private Locale usLocale;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Constructor
    public HomeGui() {
        //I will add comments and make it more readable ASAP JJBP
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        baseLocale = new Locale("nl", "NL");
        usLocale = new Locale("us", "US");

        TabbedPanel tabbedPanel = new TabbedPanel();
        mainPanel = tabbedPanel.TabbedPaneTest(baseLocale);

        Locale[] locales = new Locale[]{
                baseLocale, usLocale
        };

        JComboBox<Locale> comboBox = new JComboBox<>(locales);
        comboBox.addActionListener(event -> {
            JComboBox comboBox1 = (JComboBox) event.getSource();
            Object selected = comboBox1.getSelectedItem();
            if (selected!=baseLocale) {
                baseLocale = (Locale) selected;
                int panelIndex = mainPanel.getSelectedIndex();
                getContentPane().remove(mainPanel);
                mainPanel = tabbedPanel.TabbedPaneTest((Locale) selected);
                tabbedPanel.mainPanel.setSelectedIndex(panelIndex);
                getContentPane().add(mainPanel);
                pack();
            }
        });

        getContentPane().add(comboBox, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();
    }
}
