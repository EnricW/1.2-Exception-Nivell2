package Level3;

import java.util.Scanner;

public class Cinema {
    private int rows;
    private int seatsPerRow;
    private SeatManager seatManager;
    private CinemaManager cinemaManager;
    private final Scanner scanner;

    public Cinema() {
        this.seatManager = new SeatManager();
        this.cinemaManager = new CinemaManager(this);
        this.scanner = new Scanner(System.in);
        requestSeats();
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public SeatManager getSeatManager() {
        return seatManager;
    }

    public void start() {
        int option;
        do {
            option = cinemaManager.menu();
            switch (option) {
                case 1 -> cinemaManager.showReservedSeats();
                case 2 -> cinemaManager.showReservedSeatsByPerson();
                case 3 -> cinemaManager.reserveSeat();
                case 4 -> cinemaManager.cancelSeatReservation();
                case 5 -> cinemaManager.cancelAllReservationsByPerson();
            }
        } while (option != 0);
        System.out.println("Exiting application.");
    }

    public void requestSeats() {
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the number of rows: ");
            try {
                rows = Integer.parseInt(scanner.nextLine());
                if (rows <= 0) {
                    System.out.println("Number of rows must be greater than 0. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer for the number of rows.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.print("Enter the number of seats per row: ");
            try {
                seatsPerRow = Integer.parseInt(scanner.nextLine());
                if (seatsPerRow <= 0) {
                    System.out.println("Number of seats per row must be greater than 0. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer for the number of seats per row.");
            }
        }
    }
}
