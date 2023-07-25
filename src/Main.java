import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<>();
        for(int i=1; i<=2; i++){
            Flight flight = new Flight();
            flight.curr_price = 5000;
            flight.available_seats = 50;
            flight.number = i;
            flights.add(flight);
        }
        ArrayList<Booking> bookings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to flight ticket booking");
        while (true) {
            System.out.println("Enter 1 for displaying flight availability \nEnter 2 for booking tickets \nEnter 3 for ticket cancellation " +
                    "\nEnter 4 for display all bookings");
            int n = scanner.nextInt();
            if(n==1){
                Booking.display_availability(flights);
            }
            else if (n == 2) {
                Booking booking = new Booking();
                Flight book=null;
                for (Flight flight: flights) {
                    if(flight.number==booking.number) book=flight;
                }
                if (book==null) {
                    System.out.println("Enter valid flight number");
                    return;
                }
                if(booking.isAvailable(book)){
                    bookings.add(booking);
                    booking.displayTicket();
                }
                else System.out.println("Sorry all seats are full");

            } else if (n == 3) {
               Booking.cancel_ticket(bookings,flights);

            } else if (n == 4) {
                Booking.display_full_List(flights,bookings);
            } else {
                System.out.println("Thank you! visit us again");
                break;
            }
        }
    }
}