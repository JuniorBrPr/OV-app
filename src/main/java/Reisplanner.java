import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class Reisplanner extends JPanel implements ActionListener
{

    // De data die nodig is om een GUI te maken
    private JLabel label;
    private JPanel panel;
    private JButton zoeken;
    private JComboBox aankomstBox;
    private JComboBox vertrekBox;
    private JTextField text;
    private JLabel routegevonden;
    private JLabel vertrekLocatie;
    private JLabel aankomstLocatie;
    private JButton Home;
    public String arrivalSearch;
    public String departureSearch;
    private JComboBox timeBox;
    public String departureTimeSearch;
    private JLabel reisAdvies = new JLabel();
    public LocalTime stringToLocalTime;


    @Override
    public void actionPerformed(ActionEvent e) {
        zoeken.setText("test");
    }

    Reisplanner(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundle" ,locale);
        zoeken = new JButton(bundle.getString("zoeken"));
        label = new JLabel();

        {
            // comboboxen DOOR: Niels van Gortel
            JPanel comboBoxPanel = new JPanel();
            comboBoxPanel.setBounds(50, 100, 394, 25);
            comboBoxPanel.setLayout(new GridLayout(0, 1, 10, 0));
            comboBoxPanel.setBackground(Color.white);

            JPanel Transport = new JPanel();
            Transport.setBounds(10, 3, 10, 25);


            timeBox = new JComboBox(new Object[]{"00:00", "08:00",  "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00"});
            timeBox.setBounds(100, 200, 100, 25);

            add(comboBoxPanel);

            // Zet het keuze menu van de vertreklocaties
            vertrekBox = new JComboBox(new Object[]{bundle.getString("vertrekLocatie"), "Amsterdam", "Rotterdam", "Utrecht", "Den haag", "Amersfoort", "Schiphol airport"});
            aankomstBox = new JComboBox(new Object[]{bundle.getString("aankomstLocatie"), "Amsterdam", "Rotterdam", "Utrecht", "Den haag", "Amersfoort", "Schiphol airport"});


            // maakt het panel aan
            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 30));
            panel.setLayout(new GridLayout(6, 0));
            setSize(400, 400);
            setLayout(new FlowLayout());

            //sets the choice menu of the transportation
            JRadioButton train = new JRadioButton(bundle.getString("trein"));
            JRadioButton Tram = new JRadioButton(bundle.getString("tram"));
            JRadioButton Bus = new JRadioButton(bundle.getString("bus"));


            // makes sure that one of the buttons can be selected
            ButtonGroup group = new ButtonGroup();
            group.add(train);
            group.add(Bus);
            group.add(Tram);

            // Voegt attributen toe aan het panel.
            Transport.add(train);
            Transport.add(Tram);
            Transport.add(Bus);
            add(Transport);
            add(timeBox);
            add(aankomstBox);
            add(vertrekBox);
            add(zoeken);
            //add(Home);
            add(label);
            add(panel, BorderLayout.CENTER);

            setVisible(false);
        }

        // Zorgt ervoor dat er een response komt als de zoek button ingedrukt wordt.

        zoeken.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent search) {
                String arrivalSearch = (String)aankomstBox.getSelectedItem();
                String departureSearch = (String)vertrekBox.getSelectedItem();
                String departureTimeSearch = (String)timeBox.getSelectedItem();
                stringToLocalTime = LocalTime.parse(departureTimeSearch);

                reisAdvies.setText(bundle.getString("wiltReizenNaar")+ " " + arrivalSearch + " " + bundle.getString("vanuit") + " " + departureSearch + " " + bundle.getString("rondTijd") + " " + stringToLocalTime);
                add(reisAdvies);
                reisAdvies.setBounds(50, 150, 300, 50);
            }
        });

    }

}
