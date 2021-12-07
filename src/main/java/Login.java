import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;


// makes the class for SignUp
class SignUp extends JFrame{
    JTextField t1, t2;
    JButton b1;
    JLabel l3;
    SignUp(){
        setLayout(null);


        //makes the textfield and button of the registration panel: Niels van Gortel
        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("bevestig");

        t1.setBounds(100,50,80,30);
        t2.setBounds(100,80,80,30);
        b1.setBounds(100,110,120,30);

        l3 = new JLabel("Registratie");
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l3.setForeground(Color.BLUE);
        l3.setBounds(100,10,300,30);


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileWriter fw = new FileWriter("Login.txt", true);
                    fw.write(t1.getText()+"\t"+t2.getText()+"\n");
                    fw.close();
                    Frame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"account aangemaakt");
                    dispose();
                } catch (Exception e){}
            }

        });



        add(t1);
        add(t2);
        add(b1);
        add(l3);

    }
}

public class Login extends JFrame
{
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2;

    Login(){

        //set the layout and close: Niels van Gortel
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set the label Login with a font and a color: Niels van Gortel
        l1 = new JLabel("Login");
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(120,10,300,30);




        // makes the textfield and buttons
        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("Inloggen");
        b2 = new JButton("Registreren");
        b3 = new JButton("Home");

        // set the size of the button and the textfield
        t1.setBounds(100,60,120,20);
        t2.setBounds(100,90,120,20);
        b1.setBounds(100,120,120,30);
        b2.setBounds(100,150,120,30);
        b3.setBounds(100,180,120,30);
        l2 = new JLabel("");
        l2.setBounds(250,80,300,30);


        // add the textfield to the frame
        add(t1);
        add(t2);
        // add the button to the frame
        add(b1);
        add(b2);
        add(b3);
        // add the label to the frame
        add(l1);
        add(l2);



        //Makes sure that the button login will make a action
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean matched = false;
                String username = t1.getText().toString();
                String password = t2.getText().toString();

                try {
                    FileReader fr = new FileReader("login.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.equals(username + "\t" + password)) {
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                }catch (Exception e){}

                if(matched){
                    //opens a new window
                    dispose();
                    Login g = new Login();
                    g.setBounds(400,200,600,300);
                    g.setVisible(true);
                }else{
                    l2.setText("Verkeerde gebruikersnaam of wachtwoord");
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
                SignUp s = new SignUp();
                s.setVisible(true);
                s.setBounds(400, 200, 600, 300);
            }
        });

        this.b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeGui GUI = new HomeGui();
                GUI.setBounds(200,400,600,300);
                GUI.setVisible(true);
                dispose();
            }
        });
    }
}





// sets the class and the size of the application



