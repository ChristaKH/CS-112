import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

public class ComicDisplay extends JFrame
{
   public static final int WIDTH = 600;
   public static final int HEIGHT = 450;
   public static final int MENU_BUTTON_WIDTH = 125;
   public static final int MENU_BUTTON_HEIGHT = 65;
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
      
      //Adding background
      JLayeredPane layers = new JLayeredPane();
      layers.setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
      JPanel background = new JPanel();
      background.setSize( WIDTH, HEIGHT );
      JLabel back = new JLabel( new ImageIcon( "Gamora.jpg"));
      background.add( back );
      layers.add( background, JLayeredPane.DEFAULT_LAYER);
      
      
      //main menu buttons            
      main = new JPanel();
      main.setSize( WIDTH , HEIGHT );
      main.setOpaque( false );
      main.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 30 ) );

      //Main Page Label
      JLabel header = new JLabel( "Comic Menu" );
      header.setHorizontalAlignment( JLabel.CENTER );
      header.setForeground( Color.WHITE );
      header.setFont(new Font("Serif", Font.BOLD, 30));
      header.setPreferredSize( new Dimension( WIDTH, 50 ) );
      main.add( header );
      
      //Button #1: View Comics
      JButton viewComics = new JButton( "View Comics" );
      viewComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      viewComics.addActionListener( new MainListener() );
      main.add( viewComics );
      
      //Button #2: View Want List
      JButton  wantList = new JButton( "Want List" );
      wantList.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      wantList.addActionListener( new MainListener() );
      main.add( wantList );
      
      //Button #3: Add Comics
      JButton addComics = new JButton( "Add Comics" );
      addComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      addComics.addActionListener( new MainListener() );
      main.add( addComics );
      
      //Button #4: View Total Comics
      JButton  viewComicTotal = new JButton( "View Total Comics" );
      viewComicTotal.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      viewComicTotal.addActionListener( new MainListener() );
      main.add( viewComicTotal );
      
      //Button #5: Remove Comics
      JButton removeComics = new JButton( "Remove Comics" );
      removeComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      removeComics.addActionListener( new MainListener() );
      main.add( removeComics );
      
      //Button #6: View Missing Comics
      JButton  missingComics = new JButton( "Missing Comics" );
      missingComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      missingComics.addActionListener( new MainListener() );
      main.add( missingComics );
      layers.add( main, JLayeredPane.POPUP_LAYER );
      this.add( layers );
   }
}
