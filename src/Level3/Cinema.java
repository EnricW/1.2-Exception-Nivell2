package Level3;

public class Cinema {
    private final int rows;
    private final int seatsPerRow;

    public Cinema(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }
}
