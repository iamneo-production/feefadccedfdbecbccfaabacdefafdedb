
package services;

import java.time.temporal.ChronoUnit;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

public class FareCalculator extends Booking{

    public double book(Hotel hotel)
    {
        double totalFare=0;
        Booking book=new Booking();
        if(hotel.getFromdate().isBefore(hotel.getTodate()))
        {
            if(hotel.getNoOfPersons()==1)
            {
                hotel.setOccupancy("Single Occupancy"); 
            }
            if(hotel.getNoOfPersons()==3)
            {
                hotel.setOccupancy("1 Double Occupancy and 1 Single Occupancy");
            }
            totalFare=book.booking(hotel.getNoOfPersons(), hotel.getRates());
        }
        return totalFare;
    }
    public double book(Flight flight)
    {
        double totalFare=0;
        Booking book=new Booking();

        if(flight.getTriptype().equalsIgnoreCase("One-Way"))
        {
            totalFare=book.booking(flight.getNoOfPersons(),flight.getRates());
        }
        else
        {
            if(flight.getFrom().isBefore(flight.getTo()))
            {
                totalFare=book.booking(flight.getNoOfPersons(),flight.getRates());
            }
        }
        return totalFare;
    }
    public double book(Train train)
    {
        return 0;
    }
    public double book(Bus bus)
    {
        return 0;
    }
    
//Enter code here...
}