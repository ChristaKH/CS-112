import java.util.ArrayList;
import java.io.Serializable; 
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class ComicList implements Serializable
{
	private ArrayList <Comic> comicList;
	private int total;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public ComicList()
	{
		comicList = new ArrayList<Comic>();
		total = 0;
		try
		{
			input = new ObjectInputStream( new FileInputStream( "Comics.dat" ) );
			try
			{
			
				while( true )
				{
					Comic newComic = new Comic( (Comic) input.readObject());
					this.addSorted( newComic );
					total++;
				}
			}
			catch( EOFException e )
			{
				input.close();
			}	
		}
		catch( ClassNotFoundException e )
		{
			
		}
		catch( IOException e )
		{
			System.out.println( "Empty file so far" );
		}
	}
	
	public ComicList( Comic initialComic )
	{
		comicList = new ArrayList<Comic>();
		total = 0;
		try
		{
			input = new ObjectInputStream( new FileInputStream( "Comics.dat" ) );
			try
			{
			
				while( true )
				{
					Comic newComic = new Comic( (Comic) input.readObject());
					this.addSorted( newComic );
					total++;
				}
			}
			catch( EOFException e )
			{
				input.close();
			}	
		}
		catch( ClassNotFoundException e )
		{
			
		}
		catch( IOException e )
		{
			System.out.println( "Empty file so far" );
		}
		this.addSorted( initialComic );
		total++;
	}
	
	public ComicList( ComicList otherList )
	{
		comicList = new ArrayList<Comic>();
		total = 0;
		try
		{
			input = new ObjectInputStream( new FileInputStream( "Comics.dat" ) );
			try
			{
			
				while( true )
				{
					Comic newComic = new Comic( (Comic) input.readObject());
					this.addSorted( newComic );
					total++;
				}
			}
			catch( EOFException e )
			{
				input.close();
			}	
		}
		catch( ClassNotFoundException e )
		{
			
		}
		catch( IOException e )
		{
			System.out.println( "Error when reading in file" );
		}
		
		for( int i = 0; i < otherList.size(); i++ )
		{
			this.addSorted( otherList.get( i ) );
			total++;
		}	
	}
	
	public int size()
	{
		return comicList.size();
	}
	
	public Comic get( int i )
	{
		return new Comic( comicList.get( i ) );
	}
	
	public boolean addSorted( Comic newComic )
	{
		if( comicList.size() == 0 )
		{
			comicList.add( newComic );
			return true;
		}
		else if( comicList.size() == 1 )
		{
			Comic comic1 = new Comic( comicList.get(0 ) );
			if( comic1.compareByTitle( newComic ) > 0 )
			{
				comicList.add( newComic );
			}
			else
			{
				comicList.add( 0, newComic );
			}
			return true;
		}
		else
		{
			for( int i = 0; i < comicList.size(); i++ )
			{
				Comic tempComic = new Comic( comicList.get( i ) );
				if( tempComic.compareByTitle( newComic ) <= 0 )
				{
					comicList.add( i, newComic );
					return true;
				}
			}
			comicList.add( newComic );
			return true;
		}
	}
	
	public int getTotal()
	{
		return total;
	}
   
   public void sortByTitle()
   {
      boolean loop;
      do
      { 
         loop = false;
         Comic temp1 = new Comic();
         Comic temp2 = new Comic();
         for( int i = 0; i < (comicList.size() - 1); i++ )
         {
            temp1 = new Comic( comicList.get( i ) );
            temp2 = new Comic( comicList.get( i+1 ) );
            if( temp1.compareByTitle( temp2 ) < 0 )
            {
               loop = true;
               comicList.set( i, temp2 );
               comicList.set( i+1, temp1 );
            }
         }
      
      }while( loop == true );
      
      this.update();
   }
   
   public void sortByYear()
   {
      boolean loop;
      do
      { 
         loop = false;
         Comic temp1 = new Comic();
         Comic temp2 = new Comic();
         for( int i = 0; i < (comicList.size() - 1); i++ )
         {
            temp1 = new Comic( comicList.get( i ) );
            temp2 = new Comic( comicList.get( i+1 ) );
            if( temp1.compareByYear( temp2 ) < 0 )
            {
               loop = true;
               comicList.set( i, temp2 );
               comicList.set( i+1, temp1 );
            }
         }
      
      }while( loop == true );
      
      this.update();
   }
   
   public void sortByPublisher()
   {
      boolean loop;
      do
      { 
         loop = false;
         Comic temp1 = new Comic();
         Comic temp2 = new Comic();
         for( int i = 0; i < (comicList.size() - 1); i++ )
         {
            temp1 = new Comic( comicList.get( i ) );
            temp2 = new Comic( comicList.get( i+1 ) );
            if( temp1.compareByPublisher( temp2 ) < 0 )
            {
               loop = true;
               comicList.set( i, temp2 );
               comicList.set( i+1, temp1 );
            }
         }
      
      }while( loop == true );
      
      this.update();
   }
   
   public String printByTitle()
   {
      this.sortByTitle();
      String temp = "";
      for( int i = 0; i < comicList.size(); i++ )
      {
         temp += comicList.get( i ).toString();
      }
      
      return temp;
   }
   
   public String printByYear()
   {
      this.sortByYear();
      String temp = "";
      for( int i = 0; i < comicList.size(); i++ )
      {
         temp += comicList.get( i ).toString();
      }
      
      return temp;
   }
   
   public String printByPublisher()
   {
      this.sortByPublisher();
      String temp = "";
      for( int i = 0; i < comicList.size(); i++ )
      {
         temp += comicList.get( i ).toString();
      }
      
      return temp;
   }
  
   //make a method that will update the binary file
	public void update()
	{
		try
		{
			output = new ObjectOutputStream( new FileOutputStream( "Comics.dat" ) );
			for( int i = 0; i < comicList.size(); i++ )
			{
				output.writeObject( comicList.get( i ) );
			}
			output.close();
		}
		catch( IOException e )
		{
			System.out.println( "Error: couldn't load/make file" );	
		}
	}
}
