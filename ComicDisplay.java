import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class ComicDisplay extends JFrame
{
   public static final int WIDTH = 300;
   public static final int HEIGHT = 200;
   private JPanel main;
   
   //ActionListener for the main page/panel
   private class MainListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         
      }
   }
   
   //main method to activate the GUI
   public static void main( String [] args )
   {
      ComicDisplay display = new ComicDisplay();
      display.setVisible( true );  
   }
   
   public ComicDisplay()
   {
      //JFrame setup
      super( "Comic Log" );
      setSize( WIDTH, HEIGHT );
      setLayout( new FlowLayout() );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      //main menu buttons
      main = new JPanel();
      main.setLayout( new GridLayout( 2, 2 ) );
      
      //Button #1: View Comics
      JButton viewComics = new JButton( "View Comics" );
      viewComics.addActionListener( new MainListener() );
      main.add( viewComics );
      
      this.add( main );
   }
}