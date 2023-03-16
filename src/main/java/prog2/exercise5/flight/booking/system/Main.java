package prog2.exercise5.flight.booking.system;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        FlightBooking fly1 = new FlightBooking(3);
        System.out.println(fly1);
       fly1.reserveTickets();

    }
}
