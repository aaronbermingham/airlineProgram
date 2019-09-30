
/**
 * Aaron Bermingham
 * C17738539
 * Semester 2 Assignment 1
 */

import java.util.Scanner;
import java.text.DecimalFormat; // Used to format change variable to two decimal places
import java.util.Random; //import random Java class

public class FlightDriver
{
    // flight array values, used for testing
    //Flight[] flight = new Flight[]{new Flight("EI111", "Monday", "Dublin"),new Flight("EI112", "Tuesday", "New York"),new Flight("EI113", "Wed", "Orlando"),new Flight("EI114", "Thur", "Berlin"),new Flight("EI115", "Fri", "London")};
    Flight[] flight;
    final int SIZE = 5;    
    Passenger[] passengers;
    int numPass;

    public FlightDriver()
    {
        // initialise instance variables
        System.out.println("\f");
        String line = "\t\t-------------------------";
        numPass = 0;
        flight = new Flight[SIZE];

        System.out.println("\t\tWelcome to DT354 airlines computer booking system\n\t\tPlease enter the details for five flights (flight number,day and destination)\n" + line);
        inputFlights();
        passengers = new Passenger[100];
        menu();
    }

    //3 Input & store flight details
    public void inputFlights()
    {
        Scanner scan = new Scanner(System.in);
        String fNum;
        String fDay;
        String fDest;
        Flight flight1;
        boolean duplicate = false;
        int index;

        for (index = 0; index < SIZE; index ++)
        {
            //do{
            // do while loop to make sure user inputted flight number starts with ei 
            do{
                System.out.print("\n\t\tEnter flight number in the format EI and then 3 digits: ");
                fNum = scan.nextLine();
                if(fNum.charAt(0) != 'e' && fNum.charAt(1) != 'i' && fNum.charAt(0) != 'E' && fNum.charAt(1) != 'I')
                {
                    System.out.println("\t\tError Please enter the flight number starting with EI followed by three digits");
                }

            }while(fNum.charAt(0) != 'e' && fNum.charAt(1) != 'i' && fNum.charAt(0) != 'E' && fNum.charAt(1) != 'I'); 

            //if(index > 0)
            // {
            // for (int i = 0; i < i; i ++ )
            // {
            // if(fNum.equalsIgnoreCase(flight[index].getFlight()))
            // duplicate = true;
            // }
            // if (duplicate == true)
            // {
            // System.out.println("Error please enter a flight number that is not a duplicate");
            // }
            // }

            // }while(duplicate == true); // Commented out code is an attempt to ensure user does not input the same flight number twice
            // }

            //do while loop to make sure user inputs days in the specified format
            do
            {
                System.out.print("\n\t\tEnter flight day in abreviated form e.g. mon, tues: ");
                fDay = scan.nextLine();
                if(!(fDay.equalsIgnoreCase("mon") || fDay.equalsIgnoreCase("tues") || fDay.equalsIgnoreCase("wed") || fDay.equalsIgnoreCase("thur") || fDay.equalsIgnoreCase("fri")|| fDay.equalsIgnoreCase("sat")|| fDay.equalsIgnoreCase("sun")))
                {
                    System.out.println("\t\tError Please enter the day in the specified format");
                }
            }while(!(fDay.equalsIgnoreCase("mon") || fDay.equalsIgnoreCase("tues") || fDay.equalsIgnoreCase("wed") || fDay.equalsIgnoreCase("thur") || fDay.equalsIgnoreCase("fri")|| fDay.equalsIgnoreCase("sat")|| fDay.equalsIgnoreCase("sun")));

            //do while loop to make sure user inputs destinations where the airline runs flights to 
            do{
                System.out.print("\n\t\tEnter a flight destination, DT354 Air run flights to Amsterdam, Berlin,\n\t\tDublin, London, New York, Orlando, Paris: ");
                fDest = scan.nextLine();
                if(!(fDest.equalsIgnoreCase("Amsterdam") || fDest.equalsIgnoreCase("Berlin") || fDest.equalsIgnoreCase("Dublin") || fDest.equalsIgnoreCase("London") || fDest.equalsIgnoreCase("New York") || fDest.equalsIgnoreCase("Orlando") || fDest.equalsIgnoreCase("Paris")))
                {
                    {
                        System.out.println("\t\tError Please enter a destination that DT354 air fly to\n\t\ti.e. Amsterdam, Berlin, Dublin, London, New York, Orlando, Paris");
                    }
                }
            }while(!(fDest.equalsIgnoreCase("Amsterdam") || fDest.equalsIgnoreCase("Berlin") || fDest.equalsIgnoreCase("Dublin") || fDest.equalsIgnoreCase("London") || fDest.equalsIgnoreCase("New York") || fDest.equalsIgnoreCase("Orlando") || fDest.equalsIgnoreCase("Paris")));

            flight1 = new Flight(fNum,fDay,fDest); // calling constructor from user defined class flight
            flight[index] = flight1;

        }
    }

    // 5 Menu System
    public void menu(){
        //Variables
        System.out.println("\f"); // Clears terminal screen
        String line = "\t-------------------------";
        int choice; // Variable for user inputted choice
        DecimalFormat df = new DecimalFormat("#.##"); // Formats doubles to two decimal places
        Scanner scan= new Scanner(System.in);

        do{ // Do while loop to return to the menu after a module or method is called
            System.out.print("\n\tSelect an option by typing the number option and then enter.\n\te.g. if you want to make a booking, press 1 and then enter\n");
            System.out.println(line);
            System.out.print("\n\tPress 1 to make a booking");
            System.out.print("\n\tPress 2 to cancel a booking ");
            System.out.print("\n\tPress 3 to display full flight schedule");
            System.out.print("\n\tPress 4 to display passenger bookings");
            System.out.print("\n\tPress 5 to see surge pricing");
            System.out.print("\n\tPress 6 to try and win a price discount");
            System.out.print("\n\tPress 7 to exit system");
            System.out.println("\n");
            System.out.println(line);
            System.out.print("\n");
            while (!scan.hasNextInt()) { 
                System.out.println("\t\t***Please enter a valid numerical option***");
                scan.nextLine(); 
            }

            choice = scan.nextInt(); // Variable to take in user choice for switch case

            scan.nextLine(); // Clears scanner

            switch(choice)
            {   

                case 1 : 
                System.out.println("\f");
                bookFlight(); // Calls book flight method
                break;
                case 2: 
                System.out.println("\f");
                cancelBooking(); // Calls method to cancel customer booking
                break;
                case 3: 
                // 4 Display flight details
                System.out.println("\f");
                for (int index = 0; index < SIZE; index ++)
                {

                    flight[index].display(); // Displays all flight details
                } 

                break;
                case 4:
                //8 Display passenger bookings
                System.out.println("\f");                 
                for (int index = 0; index < numPass; index ++)
                {
                    if (passengers[index] != null && passengers[index].getPssngrName() != "") // if statement to ensure arrays elements that have been deleted are not displayed
                        passengers[index].display();
                }
                break;
                case 5:
                System.out.println("\f");
                surgePriceDisplay(); // Displays any flights that have a price increase due to scarcity of seats
                break;
                case 6:
                System.out.println("\f");
                discountGame(); // Discount guessing game to win a price discount
                break;
                case 7: System.out.println("\t\tProgram will now close");
                // Exit the system
                System.exit(0);
                break;
                default: 
                System.out.println("\t\tEnter a valid option");
                break;
            }

        }while (choice != 7); // Menu loops until 7 is entered
    }

    //6 Make booking
    public void bookFlight()
    {
        Scanner scan = new Scanner(System.in);
        String flightQuery; // string to take input for flight destination to search through flight array
        String flightDay; // string to take input for flight day to search through flight array
        String discountQuery; // string to take input for price discount code to search through flight array
        int numSeats; // variable for number of seats the customer wants to book
        boolean found = false; // boolean variable for showing if the array search is successful or not

        //6.1 Book flight
        System.out.print("\t\tEnter the destination the customers wishes to fly to: ");
        flightQuery = scan.nextLine();

        System.out.print("\t\tEnter the day of the week the customers wants to fly on: ");
        flightDay = scan.nextLine();

        for (int index = 0; index < SIZE; index ++)
        {

            if(flight[index].getDest().equalsIgnoreCase(flightQuery) && flight[index].getDay().equalsIgnoreCase(flightDay))
            {
                found = true;
                System.out.print("\t\tHow many seats do they want to book: "); //**** difference from original design
                numSeats = scan.nextInt();
                scan.nextLine();
                if(flight[index].freeSeats() < numSeats || numSeats > 10) //**** difference from original design
                {
                    System.out.println("\t\tThere are not enough seats on this flight");
                }
                else{
                    inputPassenger(); // calls module to input passenger details
                    passengers[numPass].bookFlight(flight[index]);
                    surgePrice(passengers[numPass], numSeats); // calls surge price to see if flight is eligible for price increase
                    passengers[numPass].setSeats(numSeats); // not part of initial design, added so cancel booking can deincrement by the number of seats booked

                    //6.3 Ask if passenger has discount code
                    System.out.print("\t\tDo they have a discount code? Y/N ");
                    discountQuery = scan.nextLine();

                    // Asks if user has discount code and calls discountPrice so they can input it
                    if(discountQuery.equalsIgnoreCase("y"))
                    {
                        discountPrice(passengers[numPass], numSeats);
                    }
                    if(passengers[numPass].getDiscountPrice() == 0 && passengers[numPass].getIncreasePrice() == 0 )
                    {
                        passengers[numPass].normalPrice(flight[index].getPrice(), numSeats);

                    }
                    if(passengers[numPass].getFlightRef().getSeats() == 0)
                    {
                        flight[index].setSeats(numSeats);
                        passengers[numPass].setSeats(numSeats);
                        //passengers[numPass].getFlightRef().setSeats(numSeats);

                    } 
                    else if (passengers[numPass].getFlightRef().getSeats() > 0)
                    {
                        flight[index].setSeats(numSeats + flight[index].getSeats());
                        passengers[numPass].setSeats(numSeats);
                        //passengers[numPass].getFlightRef().setSeats(numSeats + passengers[numPass].getFlightRef().getSeats());

                    }

                    System.out.println("\n\t\tCustomer " + passengers[numPass].getPssngrName() + " has booked " + numSeats + " seat(s) on " + passengers[numPass].getFlightRef().getFlight() + " to " + passengers[numPass].getFlightRef().getDest());
                    System.out.println("\t\tThere are " +  passengers[numPass].getFlightRef().freeSeats() + " seats left on this flight" );

                    //add 1 to numPass here
                    numPass++;
                }}

        }

        if (found == false)
        {
            System.out.println("\t\tThere are no flights to that destination on that day");
            System.out.println("\t\tThis is the flight schedule: ");
            for (int index = 0; index < SIZE; index ++)
            {
                flight[index].display();
            } 
        }
    }

    //6.2 Input passenger details
    public void inputPassenger()
    {
        Scanner scan = new Scanner(System.in);
        String pName;
        String pAddress;
        String pEmail;
        Passenger passenger1;

        System.out.print("\t\tEnter passenger name: ");
        pName = scan.nextLine();

        System.out.print("\t\tEnter passenger address: ");
        pAddress = scan.nextLine();

        System.out.print("\t\tEnter passenger email address: ");
        pEmail = scan.nextLine();

        passenger1 = new Passenger(pName,pAddress,pEmail);

        passengers[numPass] = passenger1;

    }

    //6.4 Calculate discount price
    public void discountPrice(Passenger thePassenger, int numSeats) // not part of original design, added numSeats which is passed as a parameter to be multiplied by price
    {
        Scanner scan = new Scanner(System.in);
        String discountCode;
        double discount;
        double discountPrice = 0;

        //numSeats = seatMulitplier;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.print("\t\tEnter discount code: ");
        discountCode = scan.nextLine();
        if (discountCode.equalsIgnoreCase("5-OFF"))
        {
            discountPrice = thePassenger.discount(.05, numSeats);
            System.out.print("\t\tPrice: " + df.format(passengers[numPass].getDiscountPrice() ) );

        }
        else if (discountCode.equalsIgnoreCase("10-OFF"))
        {
            passengers[numPass].discount(.10, numSeats);

            System.out.print("\t\tPrice: " + df.format(passengers[numPass].getDiscountPrice() ) );
        }
        else if (discountCode.equalsIgnoreCase("15-OFF"))
        {
            passengers[numPass].discount(.15, numSeats);
            passengers[numPass].getFlightRef().setPrice(discountPrice);
            System.out.print("\t\tPrice: " + df.format(passengers[numPass].getDiscountPrice()) );
        }
        else
        {
            System.out.println("\t\tYou have not entered a valid discount code");
        }

    }

    //7 Cancel Booking
    public void cancelBooking()
    {
        String cancelName, cancelFlight;
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        //6.1 Enter passenger name and flight ref

        System.out.print("\t\tEnter the passengers name to cancel their booking: ");
        cancelName = scan.nextLine();
        System.out.print("\t\tEnter the flight number for the passenger: ");
        cancelFlight = scan.nextLine();
        //6.2 Check if there is a customer with that booking ref
        for (int index = 0; index < numPass; index ++) // for loop while index < value of numPass
        {
            if(passengers[index].getPssngrName().equalsIgnoreCase(cancelName) && passengers[index].getFlightRef().getFlight().equalsIgnoreCase(cancelFlight)) // passenger name equal to inputted name?
            {
                //6.3 Sub number of seats booked
                passengers[index].getFlightRef().setSeats((10 - (passengers[index].getFlightRef().freeSeats() + passengers[index].getSeats())));
                //6.4 Cancel passenger booking
                passengers[index] = new Passenger();
                System.out.println("\t\t***Booking has been cancelled***");
                found = true;
            }

        }

        if (found == false)
        {
            System.out.println("\t\t" + cancelName + " has not booked a flight.");
        }
    }

    //9 Surge pricing
    public void surgePrice(Passenger thePassenger, int numSeats)
    {
        double surgePrice;
        //9.1 Check how many seats are left and increase price accordingly
        for (int index = 0; index < flight.length; index ++)
        {
            if (flight[index].freeSeats() == 4)
            {
                surgePrice = thePassenger.increasePrice(.05, numSeats); // calls method and passes parameters to increase seat prices when seats are lower than a certain number
                System.out.println("\t\tThere are only 4 seats left for this flight, the price has increased by 5%"  );
            }
            else if (flight[index].freeSeats() == 3)
            {
                surgePrice = thePassenger.increasePrice(.05, numSeats);
                System.out.println("\t\tThere are only 3 seats left for this flight, the price has increased by 10%"  );
            }
            else if (flight[index].freeSeats() == 2)
            {
                surgePrice = thePassenger.increasePrice(.05, numSeats);
                System.out.println("\t\tThere are only 2 seats left for this flight, the price has increased by 15%"  );
            }
            else if (flight[index].freeSeats() == 1)
            {
                surgePrice = thePassenger.increasePrice(.05, numSeats);
                System.out.println("\t\tThere is only 1 seats left for this flight, the price has increased by 20%"  );
            }

        }
    }

    /* Not part of original design, module to display flights 
     * that have under a certain number of seats left and surge
     * pricing is then in effect
     */
    //**** difference from original design Display for surge price so user can see if flights are eligible for surge pricing
    public void surgePriceDisplay()
    {
        String line = "\t\t-------------------------";
        System.out.println(line);
        boolean surge = false;
        System.out.println("\t\tSurge Pricing\n\t\tWhen seats on a flight are less than a certain number, the price will increase accordingly.");
        System.out.println(line);
        for (int index = 0; index < flight.length; index ++)
        {
            if (flight[index].freeSeats() == 4)
            {
                surge = true;
                System.out.println("\t\t\nThere are only 4 seats left on the flight to " + flight[index].getFlight() + " to " + flight[index].getDest() + ", the price for any booking \n\t\twill increase by 5%"  );
            }
            if (flight[index].freeSeats() == 3)
            {
                surge = true;
                System.out.println("\t\t\nThere are only 4 seats left on the flight to " + flight[index].getFlight() + " to" + flight[index].getDest() + ", the price for any booking \n\t\twill increase by 10%"  );
            }
            if (flight[index].freeSeats() == 2)
            {
                surge = true;
                System.out.println("\t\t\nThere are only 4 seats left on the flight to " + flight[index].getFlight() + " to" + flight[index].getDest() + ", the price for any booking \n\t\twill increase by 15%"  );
            }
            if (flight[index].freeSeats() == 1)
            {
                surge = true;
                System.out.println("\t\t\nThere are only 4 seats left on the flight to " + flight[index].getFlight() + " to" + flight[index].getDest() + ", the price for any booking \n\t\twill increase by 20%"  );
            }

        }
        if (surge == false)
        {
            System.out.println("\n\t\tThere are no flights eligible for surge pricing");
        }   
    }

    //10 Discount game
    //10.1 Generate random number
    public int randomNum()
    {
        Random ranNum = new Random();
        int ranNum1 = ranNum.nextInt(20)+1;
        return ranNum1;
    }

    public void discountGame()
    {
        int num1, num2, num3, ranNum1, ranNum2, ranNum3;
        int matchCount = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("\t\t***Welcome to DT354 Air discount game***\n\t***Enter three numbers and if you get any matches, \n\t\t***you win a flight discount***");
        System.out.print("\t\tPlease enter your first number: ");
        num1 = scan.nextInt();

        // 10.2 User inputs 3 numbers
        //User input between 1 & 20 or any duplicates?
        while(num1 <1 || num1 > 20)
        {
            System.out.println("\t\tYou have entered an invalid number, please enter a number between 1 and 20 or a number that is not a duplicate");
            System.out.print("\t\tPlease enter your first number");
            num1 = scan.nextInt();
        }
        System.out.print("\t\tPlease enter your second number: ");
        num2 = scan.nextInt();
        while(num2 <1 || num2 > 20 || num2 == num1)
        {
            System.out.println("\t\tYou have entered an invalid number, please enter a number between 1 and 20 or a number that is not a duplicate");
            System.out.print("\t\tPlease enter your second number");
            num2 = scan.nextInt();
        }
        System.out.print("\t\tPlease enter your third number: ");
        num3 = scan.nextInt();
        while(num3 <1 || num3 > 20 || num3 ==num2 || num3 == num1 )
        {
            System.out.println("\t\tYou have entered an invalid number, please enter a number between 1 and 20 or a number that is not a duplicate");
            System.out.print("\t\tPlease enter your third number");
            num3 = scan.nextInt();
        }
        ranNum1 = randomNum();
        ranNum2 = randomNum();
        ranNum3 = randomNum();
        while(ranNum2 == ranNum1)
        {
            ranNum2 = randomNum();
        }

        while(ranNum3 == ranNum2 || ranNum3 == ranNum1)
        {
            ranNum3 = randomNum();
        }
        System.out.println("\n\n\t\t****The winning numbers are" + " " + ranNum1 + " " + ranNum2 + " " + ranNum3 + "****");

        //10.3 Matching numbers gives discount code for flights
        //Compare user and random numbers
        if(num1 == ranNum1 || num1 == ranNum2 || num1 == ranNum3)
        {
            matchCount ++;
        }
        if(num2 == ranNum1 || num2 == ranNum2 || num2 == ranNum3)
        {
            matchCount  ++;
        }
        if(num3 == ranNum1 || num3 == ranNum2 || num3 == ranNum3)
        {
            matchCount ++;
        }
        if(matchCount == 3)
        {
            System.out.println("\n\t\t****Congratulations! You have matched three numbers and won a 15% discount, discount code is 15-OFF !!****\n");

        }

        else if(matchCount == 2)
        {
            System.out.println("\tYou matched" + " " + matchCount + " " + "numbers, and have won a 10% discount, discount code is 10-OFF !!\n");
        }
        else if(matchCount == 1)
        {
            System.out.println("\tYou matched" + " " + matchCount + " " + "number, and won a 5% discount, discount code is 5-OFF !!\n");
        }
        else
        {
            System.out.println("\n\t Unfortunately you matched" + " " + matchCount + " " + "numbers and did not win this time\n");
        }

    }


    public static void main(String[] args )
    {
        new FlightDriver();
    }
}
