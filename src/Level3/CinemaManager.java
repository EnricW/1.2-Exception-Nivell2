package Level3;

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
        cinema.getSeatManager().getSeats().removeIf(seat -> seat.getReservedBy().equals(name));
        System.out.println("All reservations by " + name + " have been canceled.");
    }

    private String inputPersonName() throws Exception {
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        if (name.matches(".*\\d.*")) {
            throw new Exception("The name cannot contain numbers.");
        }
        return name;
    }

    private int inputRow() throws Exception {
        System.out.print("Enter the row number: ");
        int row = scanner.nextInt();
        if (row < 1 || row > cinema.getRows()) {
            throw new Exception("Row number is incorrect.");
        }
        return row;
    }

    private int inputSeat() throws Exception {
        System.out.print("Enter the seat number: ");
        int seat = scanner.nextInt();
        if (seat < 1 || seat > cinema.getSeatsPerRow()) {
            throw new Exception("Seat number is incorrect.");
        }
        return seat;
    }
}