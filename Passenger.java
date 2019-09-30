
/**
 * Aaron Bermingham
 * C17738539
 */

import java.text.DecimalFormat;

public class Passenger
{
    private String passengerName;
    private String passengerAddress;
    private String passengerEmail;
    private Flight flightRef;
    private double discountPrice;
    private double increasePrice;
    private double normalPrice;
    private int numSeats;

    public Passenger()
    {
        this.passengerName = "";
        this.passengerAddress = "";
        this.passengerEmail = "";
        this.flightRef = null;
        this.discountPrice = 0;
        this.increasePrice = 0;
        this.normalPrice = 0;
        this.numSeats= 0;
       
    }

    public Passenger(String pName, String pAddress, String pEmail)
    {
        this.passengerName = pName;
        this.passengerAddress = pAddress;
        this.passengerEmail = pEmail;
        this.flightRef = null; // no parameter for this variable
        this.discountPrice = 0;
        this.increasePrice = 0;
        this.normalPrice = 0;
        this.numSeats= 0;
    }

    public void setPssngrName(String pName)
    {
        this.passengerName = pName;
    }

    public void setPssngrAddress(String pAddress)
    {
        this.passengerAddress = pAddress;
    }

    public void setPssngrEmail(String pEmail)
    {
        this.passengerEmail = pEmail;
    }

    public void bookFlight(Flight aFlight)
    {
        this.flightRef = aFlight;
    }
    
    public void setSeats(int nSeats)
    {
    this.numSeats = nSeats;
    }

    public String getPssngrName()
    {
        return this.passengerName;
    }

    public String getPssngrAddress()
    {
        return this.passengerAddress;
    }

    public String getPssngrEmail()
    {
        return this.passengerEmail;
    }

    public Flight getFlightRef()
    {
        return this.flightRef;
    }

     public int getSeats()
    {
    return this.numSeats;
    }
    
    public void display()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        String line = "\t\t-------------------------";
        System.out.println(line);
        System.out.println("\t\tPassenger name is " + this.passengerName);
        System.out.println("\t\tPassenger Address is " + this.passengerAddress);
        System.out.println("\t\tPassenger email is " + this.passengerEmail);
        if(flightRef != null)
        {
            System.out.println("\t\tFlight reference number is for " + this.passengerName + " is " + this.flightRef.getFlight());
        }
        if (getDiscountPrice() != 0)
        {
        System.out.println("\t\tDiscounted price is " + df.format(this.discountPrice));
        }
        else if(getIncreasePrice()!=0)
        {
        System.out.println("\t\tSurge price is " + df.format(this.increasePrice));
        }
        else if (getDiscountPrice()==0 && getIncreasePrice()==0 )
        {
        System.out.println("\t\tPrice of flight(s) is " + df.format(this.normalPrice));
        }
        else
        {
            System.out.println("\t\t" +this.passengerName + " has not booked any flight.");
        }
    }
        
     public double discount(double dAmount, int numSeats)
    {
    //double discount;
    double finalPrice, discountAmount;
    discountAmount = this.flightRef.getPrice() * dAmount;
    finalPrice = this.flightRef.getPrice() - discountAmount ;
    this.discountPrice = finalPrice * numSeats; // not part of original design, added so price is multiplied by no. of seats booked
    return finalPrice;
    }
    
    public double getDiscountPrice()
    {
    return this.discountPrice;
    }
    
    public double increasePrice(double iAmount, int numSeats)
    {
    double finalPrice, increaseAmount;
    increaseAmount = this.flightRef.getPrice() * iAmount;
    finalPrice = this.flightRef.getPrice() + increaseAmount;
    this.increasePrice = finalPrice * numSeats;
    return finalPrice;
    }
    
    public double getIncreasePrice()
    {
    return this.increasePrice;
    }
    
    public double normalPrice(double price, int numSeats)
    {
      double finalPrice;
      finalPrice = this.flightRef.getPrice() * numSeats;
      this.normalPrice = finalPrice;
      return finalPrice;
    }
    
    public double getNormalPrice()
    {
    return this.normalPrice;
    }

    
    
}
 