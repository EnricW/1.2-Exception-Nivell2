package Level3;

import Level3.exceptions.InvalidNameException;
import Level3.exceptions.InvalidRowException;
import Level3.exceptions.InvalidSeatException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CinemaManager {
    private Cinema cinema;
    private final Scanner scanner;

    public CinemaManager(Cinema cinema) {
        this.cinema = cinema;
        this.scanner = new Scanner(System.in);
    }

    public int menu() {
        int option = -1;
        boolean validOption = false;

        do {
            try {
                System.out.println("\n1.- Show all reserved seats");
                System.out.println("2.- Show seats reserved by a person");
                System.out.println("3.- Reserve a seat");
                System.out.println("4.- Cancel a seat reservation");
                System.out.println("5.- Cancel all reservations by a person");
                System.out.println("0.- Exit");

                String input = scanner.nextLine();

                if (!input.matches("\\d+")) {
                    throw new InputMismatchException("You must enter a number");
                }

                option = Integer.parseInt(input);

                if (option < 0 || option > 5) {
                    throw new IllegalArgumentException("Invalid option. It must be between 0 and 5");
                }

                validOption = true;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error. Please try again.");
            }
        } while (!validOption);

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

    private String inputPersonName() throws InvalidNameException {
        boolean validName = false;
        String name = "";

        do {
            try {
                System.out.print("Enter the name of the person: ");
                name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    throw new InvalidNameException("The name cannot be empty.");
                }

                if (name.matches(".*\\d+.*")) {
                    throw new InvalidNameException("The name cannot contain numbers.");
                }

                validName = true;
            } catch (InvalidNameException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!validName);

        return name;
    }

    private int inputRow() throws InvalidRowException {
        boolean validRow = false;
        int row = 0;

        do {
            try {
                System.out.println("Enter the row number:");
                String input = scanner.nextLine();

                if (!input.matches("\\d+")) {
                    throw new InputMismatchException("You must enter a number");
                }

                row = Integer.parseInt(input);

                if (row < 1 || row > cinema.getRows()) {
                    throw new InvalidRowException("Row number must be between 1 and " + cinema.getRows());
                }

                validRow = true;
            } catch (InputMismatchException | InvalidRowException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error. Please try again.");
            }
        } while (!validRow);

        return row;
    }

    private int inputSeat() throws InvalidSeatException {
        boolean validSeat = false;
        int seat = 0;

        do {
            try {
                System.out.println("Enter the seat number:");
                String input = scanner.nextLine();

                if (!input.matches("\\d+")) {
                    throw new InputMismatchException("You must enter a number");
                }

                seat = Integer.parseInt(input);

                if (seat < 1 || seat > cinema.getSeatsPerRow()) {
                    throw new InvalidSeatException("Seat number must be between 1 and " + cinema.getSeatsPerRow());
                }

                validSeat = true;
            } catch (InputMismatchException | InvalidSeatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error. Please try again.");
            }
        } while (!validSeat);

        return seat;
    }
}