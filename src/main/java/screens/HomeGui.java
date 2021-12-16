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
    ImageIcon[] images;
    String[] imageStrings = {"translate", "dutch", "english"};

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
        mainPanel = tabbedPanel.TabbedPane(baseLocale, 0);


        //
        images = new ImageIcon[imageStrings.length];
        Integer[] intArray = new Integer[imageStrings.length];
        for (int i = 0; i < imageStrings.length; i++) {
            intArray[i] = i;
            images[i] = new ImageIcon("src/main/resources/images/" + imageStrings[i] + ".png");
            if (images[i] != null) {
                images[i].setDescription(imageStrings[i]);
            }
        }

        JComboBox imgList = new JComboBox(intArray);
        ComboBoxRenderer renderer = new ComboBoxRenderer();

        renderer.setPreferredSize(new Dimension(32, 32));
        imgList.setRenderer(renderer);
        imgList.setMaximumRowCount(3);
        add(imgList, BorderLayout.NORTH);

        imgList.addActionListener(event -> {
            JComboBox comboBox1 = (JComboBox) event.getSource();
            Object selected = comboBox1.getSelectedItem();
            if (selected.equals(2)) {
                int panelIndex = mainPanel.getSelectedIndex();
                int userId = tabbedPanel.loginInstance.getUserId();
                getContentPane().remove(mainPanel);
                mainPanel = tabbedPanel.TabbedPane(usLocale, userId);
                tabbedPanel.mainPanel.setSelectedIndex(panelIndex);
                getContentPane().add(mainPanel);
                pack();
                System.out.println(userId);
            } else {
                int panelIndex = mainPanel.getSelectedIndex();
                int userId = tabbedPanel.loginInstance.getUserId();
                getContentPane().remove(mainPanel);
                mainPanel = tabbedPanel.TabbedPane(baseLocale, userId);
                tabbedPanel.mainPanel.setSelectedIndex(panelIndex);
                getContentPane().add(mainPanel);
                pack();
                System.out.println(userId);
            }
        });

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();
    }

    class ComboBoxRenderer extends JLabel
            implements ListCellRenderer {
        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            int selectedIndex = ((Integer) value).intValue();
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon. If icon was null, say so.
            ImageIcon icon = images[selectedIndex];
            setIcon(icon);
            if (icon == null) {
                System.out.println("No image available");
            }
            return this;
        }
    }
}