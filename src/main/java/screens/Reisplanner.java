package screens;

import objects.*;

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
    public  String      departureTimeSearch;
    public  Object      chosenTime;
    private JLabel      reisAdvies = new JLabel();
    public  LocalTime   stringToLocalTime;
    public  JSpinner    timeSpinner;
    private Data        data = new Data();
    private TrainData   trainData= new TrainData();
//    private BusData     busData = new BusData();
//    private TramData    tramData = new TramData();
    private JPanel      tripsPanel;
            JScrollPane scrollPane;
    private ButtonGroup group = new ButtonGroup();


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //TODO is dit nog nodig?
    @Override
    public void actionPerformed(ActionEvent e) {
        zoeken.setText("test");
    }

    private String getSelectedButton() {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
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
            scrollPane = new JScrollPane();
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

//        private void printTrips(){
////
////            String arrivalSearch = (String)aankomstBox.getSelectedItem();
////            String departureSearch = (String)vertrekBox.getSelectedItem();
////
////            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
////            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
////            departureTimeSearch = sdf.format(timeSpinner.getValue());
////            LocalTime localTimeD = LocalTime.parse(departureTimeSearch);
////
////            if(getSelectedButton().equals(bundle.getString("trein"))){
////                Trips trips = trainData.getTrips(departureSearch, arrivalSearch, localTimeD);
////                ArrayList<Trip> tripArrayList = trips.getTrips();
////
////                for (Trip t :tripArrayList){
////                    var tripButton = new JButton();
////                    tripButton.setText(t.getRoute().getEndPoint()+" "+t.getDeparture()+"");
////                    tripButton.setPreferredSize(new Dimension(235,20));
////                    tripsPanel.add(tripButton);
////                    tripsPanel.setBackground(Color.GREEN);
////                    tripsPanel.setVisible(true);
////                }
////
////                if (tripArrayList.size()==0){
////                    var tripButton = new JButton();
////                    tripButton.setText("Geen reis mogelijk");
////                    tripButton.setPreferredSize(new Dimension(235,20));
////                    tripsPanel.add(tripButton);
////                }
////
////            }
////
////            if(getSelectedButton().equals(bundle.getString("bus"))){
////                Trips trips = busData.getTrips(departureSearch, arrivalSearch, localTimeD);
////                ArrayList<Trip> tripArrayList = trips.getTrips();
////
////                for (Trip t :tripArrayList){
////                    var tripButton = new JButton();
////                    tripButton.setText(t.getRoute().getEndPoint()+" "+t.getDeparture()+"");
////                    tripButton.setPreferredSize(new Dimension(235,20));
////                    tripsPanel.add(tripButton);
////                    tripsPanel.setBackground(Color.GREEN);
////                    tripsPanel.setVisible(true);
////                }
////
////                if (tripArrayList.size()==0){
////                    var tripButton = new JButton();
////                    tripButton.setText("Geen reis mogelijk");
////                    tripButton.setPreferredSize(new Dimension(235,20));
////                    tripsPanel.add(tripButton);
////                }
////
////            }
////
//////                if(getSelectedButton().equals(bundle.getString("tram"))){
//////                    Trips trips = tramData.getTrips(departureSearch, arrivalSearch, localTimeD);
//////                    ArrayList<Trip> tripArrayList = trips.getTrips();
//////
//////                    for (Trip t :tripArrayList){
//////                        var tripButton = new JButton();
//////                        tripButton.setText(t.getRoute().getEndPoint()+" "+t.getDeparture()+"");
//////                        tripButton.setPreferredSize(new Dimension(235,20));
//////                        tripsPanel.add(tripButton);
//////                        tripsPanel.setBackground(Color.GREEN);
//////                        tripsPanel.setVisible(true);
//////                    }
//////
//////                    if (tripArrayList.size()==0){
//////                        var tripButton = new JButton();
//////                        tripButton.setText("Geen reis mogelijk");
//////                        tripButton.setPreferredSize(new Dimension(235,20));
//////                        tripsPanel.add(tripButton);
//////                    }
//////
//////                }
////
////            else(){
////                JLabel selectTransport = new JLabel();
////                selectTransport.setText(bundle.getString("Selecteer een vervoersmiddel"));
////            }
//        }


        // Zorgt ervoor dat er een response komt als de zoek button ingedrukt wordt.
        zoeken.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent search) {

                remove(scrollPane);
                remove(tripsPanel);
                tripsPanel = new JPanel();
                tripsPanel.setLayout(new GridLayout(0,1));

                String arrivalSearch = (String)aankomstBox.getSelectedItem();
                String departureSearch = (String)vertrekBox.getSelectedItem();

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
                departureTimeSearch = sdf.format(timeSpinner.getValue());
                LocalTime localTimeD = LocalTime.parse(departureTimeSearch);


                if(getSelectedButton()!=null&&getSelectedButton().equals(bundle.getString("trein"))){
                    Trips trips = trainData.getTrips(departureSearch, arrivalSearch, localTimeD);
                    ArrayList<Trip> tripArrayList = trips.getTrips();

                    for (Trip t :tripArrayList){
                        var tripButton = new JButton();
                        tripButton.setText(t.getRoute().getEndPoint()+" "+t.getDeparture()+"");
                        tripButton.setPreferredSize(new Dimension(235,20));
                        tripsPanel.add(tripButton);
                        tripsPanel.setBackground(Color.GREEN);
                        tripsPanel.setVisible(true);
                    }

                    if (tripArrayList.size()==0){
                        var tripButton = new JButton();
                        tripButton.setText("Geen reis mogelijk");
                        tripButton.setPreferredSize(new Dimension(235,20));
                        tripsPanel.add(tripButton);
                    }

                }

//                if(getSelectedButton().equals(bundle.getString("bus"))){
//                    Trips trips = busData.getTrips(departureSearch, arrivalSearch, localTimeD);
//                    ArrayList<Trip> tripArrayList = trips.getTrips();
//
//                    for (Trip t :tripArrayList){
//                        var tripButton = new JButton();
//                        tripButton.setText(t.getRoute().getEndPoint()+" "+t.getDeparture()+"");
//                        tripButton.setPreferredSize(new Dimension(235,20));
//                        tripsPanel.add(tripButton);
//                        tripsPanel.setBackground(Color.GREEN);
//                        tripsPanel.setVisible(true);
//                    }
//
//                    if (tripArrayList.size()==0){
//                        var tripButton = new JButton();
//                        tripButton.setText("Geen reis mogelijk");
//                        tripButton.setPreferredSize(new Dimension(235,20));
//                        tripsPanel.add(tripButton);
//                    }
//
//                }

//                if(getSelectedButton().equals(bundle.getString("tram"))){
//                    Trips trips = tramData.getTrips(departureSearch, arrivalSearch, localTimeD);
//                    ArrayList<Trip> tripArrayList = trips.getTrips();
//
//                    for (Trip t :tripArrayList){
//                        var tripButton = new JButton();
//                        tripButton.setText(t.getRoute().getEndPoint()+" "+t.getDeparture()+"");
//                        tripButton.setPreferredSize(new Dimension(235,20));
//                        tripsPanel.add(tripButton);
//                        tripsPanel.setBackground(Color.GREEN);
//                        tripsPanel.setVisible(true);
//                    }
//
//                    if (tripArrayList.size()==0){
//                        var tripButton = new JButton();
//                        tripButton.setText("Geen reis mogelijk");
//                        tripButton.setPreferredSize(new Dimension(235,20));
//                        tripsPanel.add(tripButton);
//                    }
//
//                }

                else{
                    JLabel selectTransport = new JLabel();
                    selectTransport.setText(bundle.getString("selectVervoer"));
                    selectTransport.setBounds(300, 300, 100, 50);
                    add(selectTransport);
                }

                JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
                container.add(tripsPanel);
                scrollPane = new JScrollPane(container);
                scrollPane.setPreferredSize(new Dimension(270, 400));
                add(scrollPane);
                repaint();
                revalidate();
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

}