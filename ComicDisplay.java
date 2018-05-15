import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.text.DecimalFormat;

public class ComicDisplay extends JFrame implements ActionListener
{
   public static final int WIDTH = 550;
   public static final int HEIGHT = 450;
   public static final int MENU_BUTTON_WIDTH = 200;
   public static final int MENU_BUTTON_HEIGHT = 65;
   public static final Border BORDER = BorderFactory.createBevelBorder( BevelBorder.RAISED );
   public static final Font TITLE_FONT = new Font("Arial Black", Font.BOLD, 30);
   public static final Font BUTTON_FONT = new Font("Arial Black", Font.BOLD, 15);
   public static final DecimalFormat GRADE = new DecimalFormat( "0.0" );
   private int count = 0;
   private JPanel main;
   private JPanel viewComicListPanel;
   private JPanel wantListMainPanel;
   private JPanel addComicMainPanel;
   private JPanel viewComicTotalMainPanel;
   private JLayeredPane layers;
   private JPanel viewByYear;
   private JScrollPane yearScroll;
   
   //For the add comics panel
   private JComboBox publisher;
   private JTextField comicTitle;
   private JTextField issueNumber;
   private JComboBox variant;
   private JTextField coverPrice;
   private JTextField paidPrice;
   private JTextField resalePrice;
   private JTextField grade;
   private JTextField gradedPrice;
   private JComboBox years;
   private JButton viewYearBack;
   
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
      layers = new JLayeredPane();
      layers.setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
      JPanel background = new JPanel();
      background.setSize( WIDTH, HEIGHT );
      JLabel back = new JLabel( new ImageIcon( "CaptainAmerica.jpg"));
      background.add( back );
      layers.add( background, JLayeredPane.DEFAULT_LAYER);
      
      
      //main menu buttons            
      main = new JPanel();
      main.setSize( WIDTH , HEIGHT );
      main.setOpaque( false );
      main.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 30 ) );

      //Main Page Label
      JLabel header = new JLabel( "Comic Menu" );
      header.setBorder( BORDER );
      header.setHorizontalAlignment( JLabel.CENTER );
      header.setForeground( Color.WHITE );
      header.setFont(TITLE_FONT);
      header.setPreferredSize( new Dimension( 300, 50 ) );
      main.add( header );
      
      //Button #1: View Comics
      JButton viewComics = new JButton( "View Comics" );
      viewComics.setOpaque(false);
      viewComics.setContentAreaFilled(false);
      viewComics.setBorder( BORDER );
      viewComics.setForeground( Color.WHITE );
      viewComics.setFont(BUTTON_FONT);
      viewComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      viewComics.addActionListener( this );
      main.add( viewComics );
      
      //Button #2: View Want List
      JButton  wantList = new JButton( "Want List" );
      wantList.setOpaque(false);
      wantList.setContentAreaFilled(false);
      wantList.setBorder( BORDER );
      wantList.setForeground( Color.WHITE );
      wantList.setFont(BUTTON_FONT);
      wantList.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      wantList.addActionListener( this );
      main.add( wantList );
      
      //Button #3: Add Comics
      JButton addComics = new JButton( "Add Comics" );
      addComics.setOpaque(false);
      addComics.setContentAreaFilled(false);
      addComics.setBorder( BORDER );
      addComics.setForeground( Color.WHITE );
      addComics.setFont(BUTTON_FONT);
      addComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      addComics.addActionListener( this );
      main.add( addComics );
      
      //Button #4: View Comic Total
      JButton  viewComicTotal = new JButton( "View Comic Total" );
      viewComicTotal.setOpaque(false);
      viewComicTotal.setContentAreaFilled(false);
      viewComicTotal.setBorder( BORDER );
      viewComicTotal.setForeground( Color.WHITE );
      viewComicTotal.setFont(BUTTON_FONT);
      viewComicTotal.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      viewComicTotal.addActionListener( this );
      main.add( viewComicTotal );
      
      //Button #5: Remove Comics
      JButton removeComics = new JButton( "Remove Comics" );
      removeComics.setOpaque(false);
      removeComics.setContentAreaFilled(false);
      removeComics.setBorder( BORDER );
      removeComics.setForeground( Color.WHITE );
      removeComics.setFont(BUTTON_FONT);
      removeComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      removeComics.addActionListener( this );
      main.add( removeComics );
      
      //Button #6: View Missing Comics
      JButton  missingComics = new JButton( "Missing Comics" );
      missingComics.setOpaque(false);
      missingComics.setContentAreaFilled(false);
      missingComics.setBorder( BORDER );
      missingComics.setForeground( Color.WHITE );
      missingComics.setFont(BUTTON_FONT);
      missingComics.setPreferredSize( new Dimension( MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT ));
      missingComics.addActionListener( this );
      main.add( missingComics );
      layers.add( main, JLayeredPane.POPUP_LAYER );
      this.add( layers );
      
      /* This is rhe panel for the viewing comics
       */
      //View Comics Main Page
      viewComicListPanel = new JPanel();
      viewComicListPanel.setSize( WIDTH , HEIGHT );
      viewComicListPanel.setOpaque( false );
      viewComicListPanel.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 45 ) );
      
      //Page title
      JLabel title = new JLabel( "View Comics" );
      title.setPreferredSize( new Dimension( 350, 50 ) );
      title.setHorizontalAlignment( JLabel.CENTER );
      title.setBorder( BORDER );
      title.setForeground( Color.WHITE );
      title.setFont(TITLE_FONT);
      viewComicListPanel.add( title );
      
      //View list by year
      JButton yearView = new JButton( "Year" );
      yearView.setOpaque(false);
      yearView.setContentAreaFilled(false);
      yearView.setBorder( BORDER );
      yearView.setForeground( Color.WHITE );
      yearView.setFont(BUTTON_FONT);
      yearView.setPreferredSize( new Dimension( 125, MENU_BUTTON_HEIGHT ));
      yearView.addActionListener( this );
      viewComicListPanel.add( yearView );
      
      viewByYear = new JPanel();
      viewByYear.setSize( WIDTH, HEIGHT );
      viewByYear.setOpaque( false );
      viewByYear.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 45 ) );
      
      JLabel viewByYearTitle = new JLabel( "View By Year" );
      viewByYearTitle.setPreferredSize( new Dimension( 350, 50 ) );
      viewByYearTitle.setHorizontalAlignment( JLabel.CENTER );
      viewByYearTitle.setBorder( BORDER );
      viewByYearTitle.setForeground( Color.WHITE );
      viewByYearTitle.setFont( TITLE_FONT );
      viewByYear.add( viewByYearTitle );
      
      viewYearBack = new JButton( "Back" );
      viewYearBack.setActionCommand( "ViewYearBack" );
      viewYearBack.setOpaque(false);
      viewYearBack.setContentAreaFilled(false);
      viewYearBack.setBorder( BORDER );
      viewYearBack.setForeground( Color.WHITE );
      viewYearBack.setFont(BUTTON_FONT);
      viewYearBack.setPreferredSize( new Dimension( 75, MENU_BUTTON_HEIGHT/2 ));
      viewYearBack.addActionListener( this );
      viewByYear.add( viewYearBack );
 
      //Name Based List Button
      JButton titleView = new JButton( "Title" );
      titleView.setOpaque(false);
      titleView.setContentAreaFilled(false);
      titleView.setBorder( BORDER );
      titleView.setForeground( Color.WHITE );
      titleView.setFont(BUTTON_FONT);
      titleView.setPreferredSize( new Dimension( 125, MENU_BUTTON_HEIGHT ));
      titleView.addActionListener( this );
      viewComicListPanel.add( titleView );
         
      //Publisher Based List Button
      JButton publisherView = new JButton( "Publisher" );
      publisherView.setOpaque(false);
      publisherView.setContentAreaFilled(false);
      publisherView.setBorder( BORDER );
      publisherView.setForeground( Color.WHITE );
      publisherView.setFont(BUTTON_FONT);
      publisherView.setPreferredSize( new Dimension( 125, MENU_BUTTON_HEIGHT ));
      publisherView.addActionListener( this );
      viewComicListPanel.add( publisherView ); 
         
      //Back Button
      JButton backButton1 = new JButton( "Back" );
      backButton1.setActionCommand( "ViewComicListPanelBack" );
      backButton1.setOpaque(false);
      backButton1.setContentAreaFilled(false);
      backButton1.setBorder( BORDER );
      backButton1.setForeground( Color.WHITE );
      backButton1.setFont(BUTTON_FONT);
      backButton1.setPreferredSize( new Dimension( 75, MENU_BUTTON_HEIGHT/2 ));
      backButton1.addActionListener( this );
      viewComicListPanel.add( backButton1 );
      
      /* Want List Main Page
       * Has 1 title and 3 buttons:
       * Add to Want List
       * Remove from Want List
       * View Want List
       */
      wantListMainPanel = new JPanel();
      wantListMainPanel.setSize( WIDTH , HEIGHT );
      wantListMainPanel.setOpaque( false );
      wantListMainPanel.setLayout( new FlowLayout( FlowLayout.CENTER, 30, 30 ) );

      //Main Page Label
      JLabel wantListTitle = new JLabel( "Want List" );
      wantListTitle.setBorder( BORDER );
      wantListTitle.setHorizontalAlignment( JLabel.CENTER );
      wantListTitle.setForeground( Color.WHITE );
      wantListTitle.setFont(TITLE_FONT);
      wantListTitle.setPreferredSize( new Dimension( 300, 50 ) );
      wantListMainPanel.add( wantListTitle );
      
      //Add to want list
      JButton addWantList = new JButton( "Add to List" );
      addWantList.setOpaque(false);
      addWantList.setContentAreaFilled(false);
      addWantList.setBorder( BORDER );
      addWantList.setForeground( Color.WHITE );
      addWantList.setFont(BUTTON_FONT);
      addWantList.setPreferredSize( new Dimension( 200, MENU_BUTTON_HEIGHT ));
      addWantList.addActionListener( this );
      wantListMainPanel.add( addWantList );
      
      //Remove from want list
      JButton removeWantList = new JButton( "Remove from List" );
      removeWantList.setOpaque(false);
      removeWantList.setContentAreaFilled(false);
      removeWantList.setBorder( BORDER );
      removeWantList.setForeground( Color.WHITE );
      removeWantList.setFont(BUTTON_FONT);
      removeWantList.setPreferredSize( new Dimension( 200, MENU_BUTTON_HEIGHT ));
      removeWantList.addActionListener( this );
      wantListMainPanel.add( removeWantList );
      
      //View want list
      JButton viewWantList = new JButton( "View List" );
      viewWantList.setOpaque(false);
      viewWantList.setContentAreaFilled(false);
      viewWantList.setBorder( BORDER );
      viewWantList.setForeground( Color.WHITE );
      viewWantList.setFont(BUTTON_FONT);
      viewWantList.setPreferredSize( new Dimension( 200, MENU_BUTTON_HEIGHT ));
      viewWantList.addActionListener( this );
      wantListMainPanel.add( viewWantList );
      
      //Bumber
      JLabel wantListBumper = new JLabel( "" );
      wantListBumper.setHorizontalAlignment( JLabel.CENTER );
      wantListBumper.setPreferredSize( new Dimension( 450, 15 ) );
      wantListMainPanel.add( wantListBumper );
      
      
      //Back button that leads to the main page
      JButton backButton2 = new JButton( "Back" );
      backButton2.setActionCommand( "WantListPanelBack" );
      backButton2.setOpaque(false);
      backButton2.setContentAreaFilled(false);
      backButton2.setBorder( BORDER );
      backButton2.setForeground( Color.WHITE );
      backButton2.setFont(BUTTON_FONT);
      backButton2.setPreferredSize( new Dimension( 75, MENU_BUTTON_HEIGHT/2 ));
      backButton2.addActionListener( this );
      wantListMainPanel.add( backButton2 );
      
      /* Add Comics Main Page
       * Parts of a comic entry:
       * Publisher
       * Title
       * Issue Number 
       * Variant
       * Cover Price
       * Paid Price
       * Resale Price
       * Grade
       * Graded Rsale Price
       * Year
       * Submit 
       */
      addComicMainPanel = new JPanel();
      addComicMainPanel.setSize( WIDTH , HEIGHT );
      addComicMainPanel.setOpaque( false );
      addComicMainPanel.setLayout( new FlowLayout( FlowLayout.CENTER, 30, 30 ) );
      
      JLabel addComicMainTitle = new JLabel( "Add Comic" );
      addComicMainTitle.setBorder( BORDER );
      addComicMainTitle.setHorizontalAlignment( JLabel.CENTER );
      addComicMainTitle.setForeground( Color.WHITE );
      addComicMainTitle.setFont(TITLE_FONT);
      addComicMainTitle.setPreferredSize( new Dimension( 300, 40 ) );
      addComicMainPanel.add( addComicMainTitle );
      
      //Bumber
      JLabel addComicBumper = new JLabel( "" );
      addComicBumper.setHorizontalAlignment( JLabel.CENTER );
      addComicBumper.setPreferredSize( new Dimension( 450, 1 ) );
      addComicMainPanel.add( addComicBumper );
      
      //Publisher Combo Box
      String [] publisherNames = { "MARVEL", "DC", "IMAGE", "VALIANT", "OTHER" };
      publisher = new JComboBox( publisherNames );
      publisher.setEditable( false );
      
      JLabel publisherLabel = new JLabel( "Publisher:" );
      publisherLabel.setHorizontalAlignment( JLabel.CENTER );
      publisherLabel.setForeground( Color.WHITE );
      publisherLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      publisherLabel.setPreferredSize( new Dimension( 70, 25 ) );
      addComicMainPanel.add( publisherLabel );
      addComicMainPanel.add( publisher );
      
      //Title TextField
      JLabel comicTitleLabel = new JLabel( "Title:" );
      comicTitleLabel.setHorizontalAlignment( JLabel.CENTER );
      comicTitleLabel.setForeground( Color.WHITE );
      comicTitleLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      comicTitleLabel.setPreferredSize( new Dimension( 35, 25 ) );
      addComicMainPanel.add( comicTitleLabel );
      
      comicTitle = new JTextField( 15 );
      addComicMainPanel.add( comicTitle );
      
      //Issue Number TextField
      JLabel issueNumberLabel = new JLabel( "Issue Nbr:" );
      issueNumberLabel.setHorizontalAlignment( JLabel.CENTER );
      issueNumberLabel.setForeground( Color.WHITE );
      issueNumberLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      issueNumberLabel.setPreferredSize( new Dimension( 70, 25 ) );
      addComicMainPanel.add( issueNumberLabel );
      
      issueNumber = new JTextField( 3 );
      addComicMainPanel.add( issueNumber );
      
      //Variant Combo Box
      JLabel variantLabel = new JLabel( "Variant:" );
      variantLabel.setHorizontalAlignment( JLabel.CENTER );
      variantLabel.setForeground( Color.WHITE );
      variantLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      variantLabel.setPreferredSize( new Dimension( 50, 25 ) );
      addComicMainPanel.add( variantLabel );
      
      String [] variantChoices = { "Yes", "No" };
      variant = new JComboBox( variantChoices );
      variant.setEditable( false );
      addComicMainPanel.add( variant );
      
      //Cover Price TextField
      JLabel coverPriceLabel = new JLabel( "Cover Price:" );
      coverPriceLabel.setHorizontalAlignment( JLabel.CENTER );
      coverPriceLabel.setForeground( Color.WHITE );
      coverPriceLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      coverPriceLabel.setPreferredSize( new Dimension( 90, 25 ) );
      addComicMainPanel.add( coverPriceLabel);
      
      coverPrice = new JTextField( "0.00", 4 );
      addComicMainPanel.add( coverPrice );
      
      //Paid Price TextField
      JLabel paidPriceLabel = new JLabel( "Paid Price:" );
      paidPriceLabel.setHorizontalAlignment( JLabel.CENTER );
      paidPriceLabel.setForeground( Color.WHITE );
      paidPriceLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      paidPriceLabel.setPreferredSize( new Dimension( 90, 25 ) );
      addComicMainPanel.add( paidPriceLabel);
      
      paidPrice = new JTextField( "0.00", 4 );
      addComicMainPanel.add( paidPrice );
      
      //Bumper
      JLabel bumper4 = new JLabel( "" );
      bumper4.setPreferredSize( new Dimension( 25, 25 ) );
      addComicMainPanel.add( bumper4 );
      
      //Resale Price TextField
      JLabel resalePriceLabel = new JLabel( "Resale Price:" );
      resalePriceLabel.setHorizontalAlignment( JLabel.CENTER );
      resalePriceLabel.setForeground( Color.WHITE );
      resalePriceLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      resalePriceLabel.setPreferredSize( new Dimension( 90, 25 ) );
      addComicMainPanel.add( resalePriceLabel);
      
      resalePrice = new JTextField( "0.00", 4 );
      addComicMainPanel.add( resalePrice );
      
      //Graded Price TextField
      JLabel gradedPriceLabel = new JLabel( "Graded Price:" );
      gradedPriceLabel.setHorizontalAlignment( JLabel.CENTER );
      gradedPriceLabel.setForeground( Color.WHITE );
      gradedPriceLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      gradedPriceLabel.setPreferredSize( new Dimension( 90, 25 ) );
      addComicMainPanel.add( gradedPriceLabel);
      
      gradedPrice = new JTextField( "0.00", 4 );
      addComicMainPanel.add( gradedPrice );  
      
      //Grade TextField
      JLabel gradeLabel = new JLabel( "Graded:" );
      gradeLabel.setHorizontalAlignment( JLabel.CENTER );
      gradeLabel.setForeground( Color.WHITE );
      gradeLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      gradeLabel.setPreferredSize( new Dimension( 55, 25 ) );
      addComicMainPanel.add( gradeLabel );
      
      grade = new JTextField( "0.0", 3 );
      addComicMainPanel.add( grade ); 
      
      //Year Combo Box
      JLabel yearLabel = new JLabel( "Year:" );
      yearLabel.setHorizontalAlignment( JLabel.CENTER );
      yearLabel.setForeground( Color.WHITE );
      yearLabel.setFont( new Font( "Ariel Black", Font.PLAIN, 15 ));
      yearLabel.setPreferredSize( new Dimension( 50, 25 ) );
      addComicMainPanel.add( yearLabel );
      
      String [] yearChoices = new String [ 100 ];
      for( int i = 0; i < 100; i++ )
      {
         int num = 1950;
         yearChoices[ i ] = "" + (num + i);
      }
      
      years = new JComboBox( yearChoices );
      years.setEditable( false );
      addComicMainPanel.add( years );
      
      //Submit button that submits the new comic
      JButton submit = new JButton( "Submit" );
      submit.setOpaque(false);
      submit.setContentAreaFilled(false);
      submit.setBorder( BORDER );
      submit.setForeground( Color.WHITE );
      submit.setFont(BUTTON_FONT);
      submit.setPreferredSize( new Dimension( 75, MENU_BUTTON_HEIGHT/2 ));
      submit.addActionListener( this );
      addComicMainPanel.add( submit );
      
      //Back button that leads to the main page
      JButton backButton3 = new JButton( "Back" );
      backButton3.setActionCommand( "AddComicPanelBack" );
      backButton3.setOpaque(false);
      backButton3.setContentAreaFilled(false);
      backButton3.setBorder( BORDER );
      backButton3.setForeground( Color.WHITE );
      backButton3.setFont(BUTTON_FONT);
      backButton3.setPreferredSize( new Dimension( 75, MENU_BUTTON_HEIGHT/2 ));
      backButton3.addActionListener( this );
      addComicMainPanel.add( backButton3 );
      
      /* View Comic Total Main Page
       * Includes:
       * Number of total comics
       * Number of comics by publisher
       */
      viewComicTotalMainPanel = new JPanel();
      viewComicTotalMainPanel.setSize( WIDTH , HEIGHT );
      viewComicTotalMainPanel.setOpaque( false );
      viewComicTotalMainPanel.setLayout( new FlowLayout( FlowLayout.CENTER, 30, 30 ) );
      
      //Back button that leads to the main page
      JButton backButton4 = new JButton( "Back" );
      backButton4.setActionCommand( "ViewComicTotalBack" );
      backButton4.setOpaque(false);
      backButton4.setContentAreaFilled(false);
      backButton4.setBorder( BORDER );
      backButton4.setForeground( Color.WHITE );
      backButton4.setFont(BUTTON_FONT);
      backButton4.setPreferredSize( new Dimension( 75, MENU_BUTTON_HEIGHT/2 ));
      backButton4.addActionListener( this );
      viewComicTotalMainPanel.add( backButton4 );
   }
   
   //ActionListener for the main page/panel
   public void actionPerformed( ActionEvent e )
   {
      if( e.getActionCommand().equalsIgnoreCase( "View Comics" ) )
      {
          layers.remove( main );
          layers.revalidate();
          layers.repaint();
          layers.add( viewComicListPanel, JLayeredPane.POPUP_LAYER );
      }
      else if( e.getActionCommand().equalsIgnoreCase( "Want List" ) )
      {
          layers.remove( main );
          layers.revalidate();
          layers.repaint();
          layers.add( wantListMainPanel, JLayeredPane.POPUP_LAYER );
      }
      else if( e.getActionCommand().equalsIgnoreCase( "Add Comics" ))
      {
      	  layers.remove( main );
          layers.revalidate();
          layers.repaint();
          layers.add( addComicMainPanel, JLayeredPane.POPUP_LAYER );
      
      }
      else if( e.getActionCommand().equalsIgnoreCase( "Remove Comics" ) )
      {
         
      }
      else if( e.getActionCommand().equalsIgnoreCase( "View Comic Total" ) )
      {
          layers.remove( main );
          layers.revalidate();
          layers.repaint();
          layers.add( viewComicTotalMainPanel, JLayeredPane.POPUP_LAYER );
      }
      else if( e.getActionCommand().equalsIgnoreCase( "ViewComicListPanelBack" ) )
      {
          layers.remove( viewComicListPanel );
          layers.revalidate();
          layers.repaint();
          layers.add( main, JLayeredPane.POPUP_LAYER );
      }
      else if( e.getActionCommand().equalsIgnoreCase( "WantListPanelBack" ) )
      {
          layers.remove( wantListMainPanel );
          layers.revalidate();
          layers.repaint();
          layers.add( main, JLayeredPane.POPUP_LAYER );
      }
      else if( e.getActionCommand().equalsIgnoreCase( "AddComicPanelBack" ) )
      {
          layers.remove( addComicMainPanel );
          layers.revalidate();
          layers.repaint();
          layers.add( main, JLayeredPane.POPUP_LAYER );
      }   
      else if( e.getActionCommand().equalsIgnoreCase( "ViewComicTotalBack" ) )
      {
          layers.remove( viewComicTotalMainPanel );
          layers.revalidate();
          layers.repaint();
          layers.add( main, JLayeredPane.POPUP_LAYER );
      }
      else if( e.getActionCommand().equalsIgnoreCase( "Year" ) )
      {
         viewByYear.remove( viewYearBack );
         String [] columnByYear = { "Year", "Title", "Issue Number", "Variant", "Publisher" };
         Object [][] yearList =  new Object [ new ComicList().size() ][ 6 ];
         ComicList list = new ComicList();
         list.sortByYear();
         for( int i = 0; i < list.size(); i++ )
         {
            Comic temp = new Comic( list.get( i ) );
            yearList[ i ][ 0 ] = temp.getYear();  
            yearList[ i ][ 1 ] = temp.getComicName();
            yearList[ i ][ 2 ] = temp.getIssueNumber();
            yearList[ i ][ 3 ] = temp.getVariant();
            yearList[ i ][ 4 ] = temp.getPublisher();
         }
   
         JTable yearTable = new JTable( yearList, columnByYear );

         yearTable.setGridColor( Color.BLUE );
         yearTable.setShowVerticalLines( false );
         yearScroll = new JScrollPane( yearTable );
         yearScroll.setPreferredSize( new Dimension( 400, 150 ) );
         viewByYear.add( yearScroll );
         viewByYear.add( viewYearBack );
         
         layers.remove( viewComicListPanel );
         layers.revalidate();
         layers.repaint();
         layers.add( viewByYear, JLayeredPane.POPUP_LAYER );
      }
      else if( e.getActionCommand().equalsIgnoreCase( "ViewYearBack" ) )
      {
         viewByYear.remove( yearScroll );
         layers.remove( viewByYear );
         layers.revalidate();
         layers.repaint();
         layers.add( viewComicListPanel, JLayeredPane.POPUP_LAYER );
      }
      else if(e.getActionCommand().equalsIgnoreCase( "Submit" ) )
      {
         ComicList list = new ComicList();
         String inputPublisher = (String)publisher.getSelectedItem();
         String inputComicTitle = comicTitle.getText();
         int inputIssueNbr = 0;
         boolean inputVariant;
         double inputCoverPrice = 0;
         double inputPaidPrice = 0.0;
         double inputResalePrice = 0.0;
         double inputGrade = 0;
         double inputGradedPrice = 0;
         String inputTempYears = (String)years.getSelectedItem();
         int inputYears = Integer.parseInt( inputTempYears );
         
         try
         {
            inputIssueNbr = Integer.parseInt( issueNumber.getText() );
         }
         catch( NumberFormatException f )
         {  //Do nothing
         }
         
         if( ((String)variant.getSelectedItem()).equalsIgnoreCase( "Yes" ) )
         {
            inputVariant = true;
         }
         else
         {
            inputVariant = false;
         }
         
         try
         {
            inputCoverPrice = Double.parseDouble( coverPrice.getText() );
         }
         catch( NumberFormatException f )
         {  //Do nothing
         }
         
         try
         {
            inputPaidPrice = Double.parseDouble( paidPrice.getText() );
         }
         catch( NumberFormatException f )
         {  //Do nothing
         }
         
         try
         {
            inputResalePrice = Double.parseDouble( resalePrice.getText() );
         }
         catch( NumberFormatException f )
         {  //Do nothing
         }
         
         try
         {
            inputGrade = Double.parseDouble( grade.getText() );
         }
         catch( NumberFormatException f )
         {  //Do nothing
         }
         
         try
         {
            inputGradedPrice = Double.parseDouble( gradedPrice.getText() );
         }
         catch( NumberFormatException f )
         {  //Do nothing
         }
         
         Comic newComic = new Comic( inputComicTitle, inputIssueNbr, inputPublisher, inputVariant,
          inputCoverPrice, inputPaidPrice, inputResalePrice, inputGrade, inputGradedPrice, inputYears );
         
         list.addSorted( newComic );
         list.update();
         System.out.println( "Comic was added!" );
      }
   }
}
