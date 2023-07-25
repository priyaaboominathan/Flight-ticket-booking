import java.util.ArrayList;
import java.util.Scanner;
class Flight {
    int available_seats;
    int curr_price;
    int number;
}
public class Booking {
    String Passenger_name;
    int no_of_seats;
    int payment;
    int number;
    int Passenger_Id;
    static int id = 1;

    Booking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the flight number: ");
        number = scanner.nextInt();
        System.out.println("Enter your name: ");
        Passenger_name = scanner.next();
        System.out.println("Enter the number of seats: ");
        no_of_seats = scanner.nextInt();

    }
    public boolean isAvailable(Flight flight){
        if(flight.available_seats>=no_of_seats){
            Passenger_Id = id++;
            payment = flight.curr_price*no_of_seats;
            flight.available_seats -= no_of_seats;
            flight.curr_price += (no_of_seats*200);
            return true;
        }
        else  return false;
    }
    public static void cancel_ticket(ArrayList<Booking> bookings,ArrayList<Flight> flights){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter passenger ID: ");
        int cancel_ID = scanner.nextInt();
        Booking booking_cancel = null;
        for (Booking booking:bookings){
            if(cancel_ID==booking.Passenger_Id) {
                booking_cancel = booking;
            }
        }
        if(booking_cancel!=null){
            Flight flight_cancel = null;
            for(Flight flight:flights){
                if(booking_cancel.number==flight.number)flight_cancel = flight;
            }
            flight_cancel.available_seats+=booking_cancel.no_of_seats;
            flight_cancel.curr_price-= (booking_cancel.no_of_seats*200);
            System.out.println("Booking cancelled successfully. "+booking_cancel.payment+" will be refunded shortly.");
            bookings.remove(booking_cancel);
        }
        else {
            System.out.println("Please enter valid passenger ID. For Eg.1,2,...");
            return;
        }
    }
   public  void displayTicket(){
       System.out.println("-------------------------------------------------------------");
       System.out.println("Passenger ID: "+Passenger_Id+"\nPassenger name: "+Passenger_name+ " \nNo.Of.Seats booked: "+no_of_seats+
               "\nFlight number: " + number+ "\nAmount to be paid: "+payment);
       System.out.println("-------------------------------------------------------------");
   }
    public static void display_availability(ArrayList<Flight>flights) {
        for (Flight flight : flights) {
            System.out.println("Flight number: " + flight.number + " \nAvailable seats: " + flight.available_seats);
            if (flight.available_seats > 0) {
                System.out.println("Current price: " + flight.curr_price);
                System.out.println("-------------------------------------------------------------");
            } else {
                System.out.println("Flight is full");
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

            public static void display_full_List(ArrayList<Flight>flights,ArrayList<Booking> bookings) {
        display_availability(flights);
        for (Flight flight : flights) {
             System.out.println("Booking details: ");
            for (Booking booking : bookings) {
                if (booking.number == flight.number) {
                    System.out.println("Passenger ID: " + booking.Passenger_Id + "\nPassenger name: "
                            + booking.Passenger_name + " \nNo.Of.Seats booked: " + booking.no_of_seats +
                            "\nAmount paid: " + booking.payment);
                }
                System.out.println("-------------------------------------------------------------");

            }

        }
    }

}
