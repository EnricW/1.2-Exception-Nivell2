package Level3;

import Level3.exceptions.InvalidNameException;
import Level3.exceptions.InvalidRowException;
import Level3.exceptions.InvalidSeatException;

import java.util.Scanner;

public class CinemaManager {
    private Cinema cinema;
    private final Scanner scanner;

    public CinemaManager(Cinema cinema) {
        this.cinema = cinema;
        this.scanner = new Scanner(System.in);
    }

    public int menu(){
        int option;
        do{
            System.out.println("1 - Show all reserved seats.");
            System.out.println("2 - Show seats reserved by a person.");
            System.out.println("3 - Reserve a seat.");
            System.out.println("4 - Cancel a seat reservation.");
            System.out.println("5 - Cancel all reservations by a person.");
            System.out.println("0 - Exit.");
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option < 0 || option > 5);

        return option;
    }

    public void showReservedSeats() {
        for (Seat s : cinema.getSeatManager().getSeats()) {
            System.out.println(s);
        }
    }

    public void showReservedSeatsByPerson() {
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        for (Seat s : cinema.getSeatManager().getSeats()) {
            if (s.getReservedBy().equals(name)) {
                System.out.println(s);
            }
        }
    }

    public void reserveSeat() {
        try {
            int row = inputRow();
            int seat = inputSeat();
            scanner.nextLine();
            String name = inputPersonName();
            cinema.getSeatManager().addSeat(new Seat(row, seat, name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelSeatReservation() {
        try {
            int row = inputRow();
            int seat = inputSeat();
            cinema.getSeatManager().removeSeat(row, seat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelAllReservationsByPerson() {
    System.out.print("Enter the name of the person: ");
    String name = scanner.nextLine();
    boolean reservationFound = cinema.getSeatManager().getSeats().removeIf(seat -> seat.getReservedBy().equals(name));
    if (reservationFound) {
        System.out.println("All reservations by " + name + " have been canceled.");
    } else {
        System.out.println("Reservation not found for " + name + ".");
    }
}

    private String inputPersonName() throws InvalidNameException {
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        if (name.matches(".*\\d.*")) {
            throw new InvalidNameException("The name cannot contain numbers.");
        }
        if (name.isEmpty()) {
            throw new InvalidNameException("The name cannot be empty.");
        }

        return name;
    }

    private int inputRow() throws InvalidRowException {
        System.out.print("Enter the row number: ");
        int row = scanner.nextInt();
        if (row < 1 || row > cinema.getRows()) {
            throw new InvalidRowException("Row number must be between 1 and " + cinema.getRows() + ".");
        }

        return row;
    }

    private int inputSeat() throws InvalidSeatException {
        System.out.print("Enter the seat number: ");
        int seat = scanner.nextInt();
        if (seat < 1 || seat > cinema.getSeatsPerRow()) {
            throw new InvalidSeatException("Seat number must be between 1 and " + cinema.getSeatsPerRow() + ".");
        }

        return seat;
    }
}