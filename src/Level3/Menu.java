package Level3;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private CinemaManager cinemaManager;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        setupCinema();
        int option;
        do {
            option = showMenu();
            handleOption(option);
        } while (option != 8);
        System.out.println("Exiting application.");
    }

    private void setupCinema() {
        int rows = requestPositiveInteger("Enter the number of rows: ");
        int seatsPerRow = requestPositiveInteger("Enter the number of seats per row: ");
        Cinema cinema = new Cinema(rows, seatsPerRow);
        this.cinemaManager = new CinemaManager(cinema);
    }

    private int showMenu() {
        System.out.println("1 - Show all reserved seats.");
        System.out.println("2 - Show seats reserved by a person.");
        System.out.println("3 - Reserve a seat.");
        System.out.println("4 - Cancel a seat reservation.");
        System.out.println("5 - Cancel all reservations by a person.");
        System.out.println("8 - Exit.");
        return requestPositiveInteger("Select an option: ");
    }

    private void handleOption(int option) {
        switch (option) {
            case 1 -> showAllReservedSeats();
            case 2 -> showReservedSeatsByPerson();
            case 3 -> reserveSeat();
            case 4 -> cancelSeatReservation();
            case 5 -> cancelAllReservationsByPerson();
        }
    }

    private void showAllReservedSeats() {
        cinemaManager.getAllReservedSeats().forEach(System.out::println);
    }

    private void showReservedSeatsByPerson() {
        String name = requestString("Enter the name of the person: ");
        cinemaManager.getReservedSeatsByPerson(name).forEach(System.out::println);
    }

    private void reserveSeat() {
        try {
            int row = requestPositiveInteger("Enter the row number: ");
            int seat = requestPositiveInteger("Enter the seat number: ");
            String name = requestString("Enter the name of the person: ");
            cinemaManager.reserveSeat(row, seat, name);
            System.out.println("Seat reserved successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelSeatReservation() {
        try {
            int row = requestPositiveInteger("Enter the row number: ");
            int seat = requestPositiveInteger("Enter the seat number: ");
            cinemaManager.cancelReservation(row, seat);
            System.out.println("Reservation canceled successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelAllReservationsByPerson() {
        String name = requestString("Enter the name of the person: ");
        boolean result = cinemaManager.cancelAllReservationsByPerson(name);
        if (result) {
            System.out.println("All reservations by " + name + " have been canceled.");
        } else {
            System.out.println("No reservations found for " + name + ".");
        }
    }

    private int requestPositiveInteger(String prompt) {
        int value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
        return value;
    }

    private String requestString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}

