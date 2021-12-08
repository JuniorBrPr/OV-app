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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // De data die nodig is om een GUI te maken
    private JLabel      label;
    private JPanel      panel;
    private JButton     zoeken;
    private JComboBox   aankomstBox;
    private JComboBox   vertrekBox;
    private JTextField  text;
    private JLabel      routegevonden;
    private JLabel      vertrekLocatie;
    private JLabel      aankomstLocatie;
    private JButton     Home;
    public  String      arrivalSearch;
    public  String      departureSearch;
    private JComboBox   hourBox;
    private JComboBox   minuteBox;
    public  String      departureTimeSearch;
    private JLabel      reisAdvies = new JLabel();
    public  LocalTime   stringToLocalTime;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //TODO is dit nog nodig?
    @Override
    public void actionPerformed(ActionEvent e) {
        zoeken.setText("test");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Constructor
    Reisplanner(Locale locale) {

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Declarations
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

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //tijd dropdown         TODO zorgen dat er een default is van huidige tijd
            hourBox = new JComboBox(new Object[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23});
            hourBox.setBounds(100, 200, 100, 25);

            minuteBox = new JComboBox(new Object[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59});
            minuteBox.setBounds(200, 200, 100, 25);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //TODO Waar is deze voor?
            add(comboBoxPanel);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Zet het keuze menu van de vertreklocaties
            vertrekBox = new JComboBox(new Object[]{bundle.getString("vertrekLocatie"), "Amsterdam", "Rotterdam", "Utrecht", "Den haag", "Amersfoort", "Schiphol airport"});
            aankomstBox = new JComboBox(new Object[]{bundle.getString("aankomstLocatie"), "Amsterdam", "Rotterdam", "Utrecht", "Den haag", "Amersfoort", "Schiphol airport"});

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // maakt het panel aan
            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 30));
            panel.setLayout(new GridLayout(6, 0));
            setSize(400, 400);
            setLayout(new FlowLayout());

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //sets the choice menu of the transportation
            JRadioButton train = new JRadioButton(bundle.getString("trein"));
            JRadioButton Tram = new JRadioButton(bundle.getString("tram"));
            JRadioButton Bus = new JRadioButton(bundle.getString("bus"));

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // makes sure that one of the buttons can be selected
            ButtonGroup group = new ButtonGroup();
            group.add(train);
            group.add(Bus);
            group.add(Tram);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Voegt attributen toe aan het panel.
            Transport.add(train);
            Transport.add(Tram);
            Transport.add(Bus);
            add(Transport);
            add(hourBox);
            add(minuteBox);
            add(aankomstBox);
            add(vertrekBox);
            add(zoeken);
            //add(Home);
            add(label);
            add(panel, BorderLayout.CENTER);

            setVisible(false);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Zorgt ervoor dat er een response komt als de zoek button ingedrukt wordt.
        zoeken.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent search) {
                String arrivalSearch = (String)aankomstBox.getSelectedItem();
                String departureSearch = (String)vertrekBox.getSelectedItem();
                int hourSearch = (int)hourBox.getSelectedItem();
                int minuteSearch = (int)minuteBox.getSelectedItem();
                LocalTime departureTimeSearch = LocalTime.of(hourSearch,minuteSearch);


                reisAdvies.setText(bundle.getString("wiltReizenNaar")+ " " + arrivalSearch + " " + bundle.getString("vanuit") + " " + departureSearch + " " + bundle.getString("rondTijd") + " " + departureTimeSearch);
                add(reisAdvies);
                reisAdvies.setBounds(50, 150, 300, 50);



            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

}
