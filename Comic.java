/* The Comic class describes a single comic */
import java.text.NumberFormat;
import java.text.DecimalFormat;

import java.io.Serializable;

public class Comic implements Serializable
{
   private String comicName;
   private int issueNumber;
   private String publisher;
   private boolean variant;
   private double coverPrice;
   private double paidPrice;
   private double resalePrice;
   private double gradedResalePrice;
   private int year;
   private double grade;
   
   public static final DecimalFormat GRADE = new DecimalFormat( "0.0" );
   
   public Comic()
   {
      comicName = "";
      issueNumber = 0;
      variant = false;
      coverPrice = 0.0;
      paidPrice = 0.0;
      resalePrice = 0.0;
      gradedResalePrice = 0.0;
      year = 0;
      grade = 0.0;
   }
   
   public Comic( String initialComicName, int initialIssueNumber )
   {
      this.setComicName( initialComicName );
      this.setIssueNumber( initialIssueNumber );
      publisher = "";
      variant = false;
      coverPrice = 0.0;
      paidPrice = 0.0;
      resalePrice = 0.0;
      grade = 0.0;
      gradedResalePrice = 0.0;
      year = 0;
   }
   
   public Comic( String initialComicName, int initialIssueNumber, String 
      initialPublisher, boolean initialVariant, double initialCoverPrice, double initialPaidPrice, double initialResalePrice, 
      double initialGrade, double initialGradedResalePrice, int initialYear )
   {
      this.setComicName( initialComicName );
      this.setIssueNumber( initialIssueNumber );
      this.setPublisher( initialPublisher );
      this.setVariant( initialVariant );
      this.setCoverPrice( initialCoverPrice );
      this.setPaidPrice( initialPaidPrice );
      this.setResalePrice( initialResalePrice );
      this.setGrade( initialGrade );
      this.setGradedResalePrice( initialGradedResalePrice );
      this.setYear( initialYear );
   }
   public Comic( Comic otherComic )
   {
      this.setComicName( otherComic.getComicName() );
      this.setIssueNumber( otherComic.getIssueNumber() );
      this.setPublisher( otherComic.getPublisher() );
      this.setVariant( otherComic.getVariant() );
      this.setCoverPrice( otherComic.getCoverPrice() );
      this.setPaidPrice( otherComic.getPaidPrice() );
      this.setResalePrice( otherComic.getResalePrice() );
      this.setGrade( otherComic.getGrade() );
      this.setGradedResalePrice( otherComic.getGradedResalePrice() );
      this.setYear( otherComic.getYear() );
   }
   
   public void setComicName( String newComicName )
   {
      comicName = newComicName.toUpperCase();
   }
   
   public void setIssueNumber( int newIssueNumber )
   {
      if( newIssueNumber < 0 )
      {
         newIssueNumber *= -1;
      }
      
      issueNumber = newIssueNumber;
   }
   
   public void setPublisher( String newPublisher )
   {
      publisher = newPublisher.toUpperCase();
   }
   
   public void setVariant( boolean newVariant )
   {
   		variant = newVariant;
   }
   
   public void setCoverPrice( double newCoverPrice )
   {
      if( newCoverPrice < 0 )
      {
         newCoverPrice *= -1;
      }
      
      coverPrice = newCoverPrice;
   }
   
   public void setPaidPrice( double newPaidPrice )
   {
      if( newPaidPrice < 0 )
      {
         newPaidPrice *= -1;
      }
      
      paidPrice = newPaidPrice;
   }
   
   public void setResalePrice( double newResalePrice )
   {
      if( newResalePrice < 0 )
      {
         newResalePrice *= -1;
      }
      
      resalePrice = newResalePrice;
   }
   
   public void setGrade( double newGrade )
   {
      if( newGrade >= -10.0 && newGrade <= 10.0 )
      {
         if( newGrade < 0 )
         {
            newGrade *= -1;
         }
      }
      else
      {
         newGrade = 0;
      }
      grade = newGrade;
   }
   
   public void setGradedResalePrice( double newGradedResalePrice )
   {
      if( newGradedResalePrice < 0 )
      {
         newGradedResalePrice *= -1;
      }
      gradedResalePrice = newGradedResalePrice;
   }
   
   public void setYear( int newYear )
   {
      if( newYear == 0 || ( newYear >= 1900 && newYear <= 2100 ) )
      {
         year = newYear;
      }
      else
      {
         year = 0;
      }
   }
   
   public String getComicName()
   {
      return comicName;
   }
   
   public int getIssueNumber()
   {
      return issueNumber;
   }
   
   public String getPublisher()
   {
      return publisher;
   }
   
   public boolean getVariant()
   {
   		return variant;
   }
   
   public double getCoverPrice()
   {
      return coverPrice;
   }
   
   public double getPaidPrice()
   {
      return paidPrice;
   }
   
   public double getResalePrice()
   {
      return resalePrice;
   }
   
   public double getGrade()
   {
      return grade;
   }
   
   public double getGradedResalePrice()
   {
      return gradedResalePrice;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public boolean equals( Comic otherComic )
   {
      if( this.compareByTitle( otherComic ) == 0 )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public String toString()
   {
      NumberFormat price = NumberFormat.getCurrencyInstance();
      String temp = "";
      temp += "\n\nComic Name: " + comicName;
      temp += "\nIssue Number: #" + issueNumber;
      temp += "\nPublisher: " + publisher;
      temp += "\nYear: " + year;
      temp += "\nVariant: " + variant;
      temp += "\nCoverPrice: " + price.format( coverPrice );
      temp += "\nPaid Price: " + price.format( paidPrice );
      temp += "\nResale Price: " + price.format( resalePrice );
      temp += "\nGrade: " + GRADE.format( grade );
      temp += "\nGraded Price: " + price.format( gradedResalePrice );
      return temp;
   }
   
   //Comparison methods
   
   // Publisher >> Title >> Issue Number
   public int compareByPublisher( Comic otherComic )
   {
      if( this.getPublisher().equalsIgnoreCase( otherComic.getPublisher() ) )
      {      
         if( this.getComicName().equalsIgnoreCase( otherComic.getComicName() ) )
         {
            if( this.getIssueNumber() == otherComic.getIssueNumber() )
            {
               return 0;
            }
            else
            {
               if( this.getIssueNumber() < otherComic.getIssueNumber() )
               {
                  return 1;
               }
               else
               {
                  return -1;
               }
            }
         }
         else
         {
            String temp1 = this.getComicName().toUpperCase();
            String temp2 = otherComic.getComicName().toUpperCase();
            
            if( temp1.compareTo( temp2 ) < 0 )
            {
               return 1;
            }
            else
            {
               return -1;
            }
         }
      }
      else
      {
         String temp1 = this.getPublisher().toUpperCase();
         String temp2 = otherComic.getPublisher().toUpperCase();
            
         if( temp1.compareTo( temp2 ) < 0 )
         {
            return 1;
         }
         else
         {
            return -1;
         }
      }
   }
   
   // Year >> Title >> Issue Number
   public int compareByYear( Comic otherComic )
   {
      if( this.getYear() == otherComic.getYear() )
      {
         if( this.getComicName().equalsIgnoreCase( otherComic.getComicName() ) )
         {
            if( this.getIssueNumber() == otherComic.getIssueNumber() )
            {
               return 0;
            }
            else
            {
               if( this.getIssueNumber() < otherComic.getIssueNumber() )
               {
                  return 1;
               }
               else
               {
                  return -1;
               }
            }
         }
         else
         {
            String temp1 = this.getComicName().toUpperCase();
            String temp2 = otherComic.getComicName().toUpperCase();
            
            if( temp1.compareTo( temp2 ) < 0 )
            {
               return 1;
            }
            else
            {
               return -1;
            }
         }
      }
      else
      {
         if( this.getYear() < otherComic.getYear() )
         {
            return 1;
         }
         else
         {
            return -1;
         }
      }
   }
   
   // Title >> year >> issue number
   public int compareByTitle( Comic otherComic )
   {
      if( this.getComicName().equalsIgnoreCase( otherComic.getComicName() ) )
      {
         if( this.getYear() == otherComic.getYear() )
         {
            if( this.getIssueNumber() == otherComic.getIssueNumber() )
            {
               return 0;
            }
            else
            {
               if( this.getIssueNumber() < otherComic.getIssueNumber() )
               {
                  return 1;
               }
               else
               {
                  return -1;
               }
            }
         }
         else
         {
            if( this.getYear() < otherComic.getYear() )
            {
               return 1;
            }
            else
            {
               return -1;
            }
         }
      }
      else
      {
         String temp1 = this.getComicName().toUpperCase();
         String temp2 = otherComic.getComicName().toUpperCase();
         
         if( temp1.compareTo( temp2 ) < 0 )
         {
            return 1;
         }
         else
         {
            return -1;
         }
      }
   }
 }
