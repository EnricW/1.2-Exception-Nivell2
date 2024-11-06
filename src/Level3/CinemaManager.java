package Level3;

import java.util.Scanner;

public class CinemaManager {
    private Cinema cinema;
    private final Scanner scanner;

    public CinemaManager(Cinema cinema) {
        this.cinema = cinema;
        this.scanner = new Scanner(System.in);
    }

    private int menu(){
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
        } while (option != 0);

        return option;
    }

    public void showReservedSeats() {
        for (Seat s : cinema.SeatManager().getSeats()) {
            System.out.println(s);
        }
    }

    public void showReservedSeatsByPerson() {
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        for (Seat s : cinema.SeatManager().getSeats()) {
            if (s.getReservedBy().equals(name)) {
                System.out.println(s);
            }
        }
    }

    public void reserveSeat() {
        System.out.print("Enter the row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter the seat number: ");
        int seat = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        try {
            cinema.SeatManager().addSeat(new Seat(row, seat, name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelSeatReservation() {
        System.out.print("Enter the row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter the seat number: ");
        int seat = scanner.nextInt();
        try {
            cinema.SeatManager().removeSeat(row, seat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelAllReservationsByPerson() {
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        for (Seat s : cinema.SeatManager().getSeats()) {
            if (s.getReservedBy().equals(name)) {
                try {
                    cinema.SeatManager().removeSeat(s.getRowNumber(), s.getSeatNumber());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public String addPerson() throws Exception {
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        if (name.matches(".*\\d.*")) {
            throw new Exception("The name cannot contain numbers.");
        }
        return name;
    }

    public int addRow(int rows) throws Exception {
        System.out.print("Enter the row number: ");
        int row = scanner.nextInt();
        if (row < 1 || row > rows) {
            throw new Exception("The row number is incorrect.");
        }
        return row;
    }

    public int addSeat(int seats) throws Exception {
        System.out.print("Enter the seat number: ");
        int seat = scanner.nextInt();
        if (seat < 1 || seat > seats) {
            throw new Exception("The seat number is incorrect.");
        }
        return seat;
    }

}
