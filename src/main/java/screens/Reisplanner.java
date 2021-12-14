package screens;

import objects.Data;
import objects.Location;
import objects.Trip;
import objects.Trips;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    public  String      arrivalSearch;
    public  String      departureSearch;
    public  String departureTimeSearch;
    public  Object      chosenTime;
    private JLabel      reisAdvies = new JLabel();
    public  LocalTime   stringToLocalTime;
    public  JSpinner    timeSpinner;
    private Data data = new Data();
    private JPanel tripsPanel;
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

            Date date = new Date();
            SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);

            timeSpinner = new javax.swing.JSpinner(sm);
            timeSpinner.setBounds(500, 500, 100, 25);
            JSpinner.DateEditor de = new JSpinner.DateEditor(timeSpinner, "HH:mm");
            timeSpinner.setEditor(de);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //TODO Waar is deze voor?
            add(comboBoxPanel);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Zet het keuze menu van de vertreklocaties

            HashMap<String, Location> locations = data.getLocationMap();
            System.out.println(locations);
            Set<String> keySet = locations.keySet();
            ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
            
//            String[] startLocations
//            for (Object l : locations.values()) {
//                Location location = (Location) l;
//                System.out.println(location.getName());
//            }
            vertrekBox = new JComboBox(listOfKeys.toArray());
//            vertrekBox = new JComboBox(new Object[]{bundle.getString("vertrekLocatie"), "Amsterdam", "Rotterdam", "Utrecht", "Den haag", "Amersfoort", "Schiphol airport"});
            aankomstBox = new JComboBox(listOfKeys.toArray());

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // maakt het panel aan
            panel = new JPanel();
            tripsPanel = new JPanel();
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
            add(timeSpinner);
            add(vertrekBox);
            add(aankomstBox);
            add(zoeken);
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

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
                departureTimeSearch = sdf.format(timeSpinner.getValue());
                LocalTime localTimeD = LocalTime.parse(departureTimeSearch);

                Trips trips = data.getTrips(departureSearch, arrivalSearch, localTimeD);
                ArrayList<Trip> tripArrayList = trips.getTrips();

//                reisAdvies.setText(bundle.getString("wiltReizenNaar")+ " " + arrivalSearch + " " + bundle.getString("vanuit") + " " + departureSearch + " " + bundle.getString("rondTijd") + " " + departureTimeSearch);

                remove(tripsPanel);
                tripsPanel = new JPanel();
                tripsPanel.setLayout(new GridLayout(0,1));

                for (Trip t :tripArrayList){
                    JLabel tripLabel = new JLabel();
                    tripLabel.setText(t.getRoute().getEndPoint()+" "+t.getDeparture()+"");
                    tripsPanel.add(tripLabel);
                }

                add(tripsPanel);

//                add(reisAdvies);
                repaint();
                revalidate();
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

}