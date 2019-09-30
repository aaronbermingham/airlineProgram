
/**
 * Aaron Bermingham
 * OOSD Assignment 3
 */
public class Flight
{
    private String flightNum;
    private String flightDay;
    private String flightDest;
    private int seatsBooked;
    private double seatPrice;
    private double increasePrice;

    public Flight()
    {
        this.flightNum = "";
        this.flightDay = "";
        this.flightDest = "";
        this.seatsBooked = 0;
        this.seatPrice = 0;
        this.increasePrice = 0;
    }

    public Flight(String fNum, String fDay, String fDest)
    {
        this.flightNum = fNum;
        this.flightDay = fDay;
        this.flightDest = fDest;
        this.seatsBooked = 0;
        this.seatPrice = 49.99;
        this.increasePrice = 0;

    }

    public void setFlight(String fNum)
    {
        this.flightNum = fNum;
    }

    public void setDay(String fDay)
    {
        this.flightDay = fDay;
    }

    public void setDest(String fDest)
    {
        this.flightDest = fDest;
    }

    public void setSeats(int sBooked)
    {
        this.seatsBooked = sBooked;
    }

    public void setPrice(double sPrice)
    {
        this.seatPrice = sPrice;
    }

    public String getFlight()
    {
        return this.flightNum;
    }

    public String getDay()
    {
        return this.flightDay;
    }

    public String getDest()
    {
        return this.flightDest;
    }

    public int getSeats()
    {
        return this.seatsBooked;
    }

    public double getPrice()
    {
        return this.seatPrice;
    }

    public void display()
    {
        String line = "\t\t-------------------------";
        System.out.println(line);
        System.out.println("\t\tFlight identifer: " + this.flightNum + "\t\t|Flight day: " + this.flightDay);
        System.out.println("\t\tFlight destination: " + this.flightDest + "\t|Number of seats booked: " + this.seatsBooked);
        System.out.println("\t\tStandard seat price: " + this.seatPrice);

    }

    public int freeSeats()
    {
        int freeSeats = 10 - getSeats();
        return freeSeats;

    }

}
