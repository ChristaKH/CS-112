import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PigLatin extends JFrame implements ActionListener
{
   //Main method - display the JFrame
   public static void main( String [] args )
   {
      PigLatin piggy = new PigLatin();
      piggy.setVisible( true );
   }
  
   public static final int WIDTH = 350;
   public static final int HEIGHT = 200; 
   private JTextField pigLatin;
   private JTextField english;
   
   public PigLatin()
   {
      //Set up the JFrame's basic appearance
      super( "Pig Latin Translator" );
      setSize( WIDTH, HEIGHT );
      setLayout( new FlowLayout() );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      //Create components that will take up the Frame
      english = new JTextField( 30 );
      
      pigLatin = new JTextField(30);
      pigLatin.setEditable( false );
      
      JButton translate = new JButton( "Translate" );
      translate.addActionListener( this );
      
      //Add all components
      add( english );
      add( translate );
      add( pigLatin );
   }
   
   //Create the action that will cause the entered text to be turned to pig latin
   public void actionPerformed( ActionEvent e )
   {
      Scanner keyboard = new Scanner( english.getText() ); 
      String text = "";
      String temp = "";
      char consonant = ' ';
      while( keyboard.hasNext() )
      {
         temp = keyboard.next();
         if( temp.charAt( 0 ) == 'a' ||
             temp.charAt( 0 ) == 'e' ||
             temp.charAt( 0 ) == 'i' ||
             temp.charAt( 0 ) == 'o' ||
             temp.charAt( 0 ) == 'u' ||
             temp.charAt( 0 ) == 'y' )
         {
            temp += "way";            
         }
         else if( temp.length() > 1 )
         {
            consonant = temp.charAt( 0 );
            temp = temp.substring( 1, temp.length() );
            temp += consonant;
            temp += "ay";
         }  
         text = text + temp + " ";           
     }
     pigLatin.setText( text );
   }
}
