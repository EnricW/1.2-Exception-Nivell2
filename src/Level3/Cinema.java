package Level3;

import java.util.InputMismatchException;
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

    private void requestSeats() {
        boolean validData = false;

        do {
            try {
                System.out.println("Enter the number of rows:");
                String inputRows = scanner.nextLine();
                if (!inputRows.matches("\\d+")) {
                    throw new InputMismatchException("You must enter a number");
                }
                rows = Integer.parseInt(inputRows);
                if (rows <= 0) {
                    throw new IllegalArgumentException("The number of rows must be greater than 0");
                }

                System.out.println("Enter the number of seats per row:");
                String inputSeats = scanner.nextLine();
                if (!inputSeats.matches("\\d+")) {
                    throw new InputMismatchException("You must enter a number");
                }
                seatsPerRow = Integer.parseInt(inputSeats);
                if (seatsPerRow <= 0) {
                    throw new IllegalArgumentException("The number of seats must be greater than 0");
                }

                validData = true;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error. Please try again.");
            }
        } while (!validData);
    }
}
