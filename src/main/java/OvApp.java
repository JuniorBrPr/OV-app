import screens.HomeGui;

import java.awt.*;

public class OvApp
{


        public static void main(String[] args)
        {
            HomeGui g = new HomeGui();
            g.setPreferredSize(new Dimension(700, 800));
            g.pack();
            g.setVisible(true);
            g.setBackground(Color.BLACK);
           

        }
}


