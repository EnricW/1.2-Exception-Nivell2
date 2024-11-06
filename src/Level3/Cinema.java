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
    }

    public void start() {
        Cinema cinema = new Cinema();
        //cinema.menu();
    }


    public void requestSeats() {

        System.out.print("Enter the number of rows: ");
        this.rows = scanner.nextInt();
        System.out.print("Enter the number of seats per row: ");
        this.seatsPerRow = scanner.nextInt();
    }
}
