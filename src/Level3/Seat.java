package Level3;

public class Seat {
    private int rowNumber;
    private int seatNumber;
    private String reservedBy;

    public Seat(int rowNumber, int seatNumber, String reservedBy) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.reservedBy = reservedBy;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public boolean equals(Seat seat) {
        return this.rowNumber == seat.getRowNumber() && this.seatNumber == seat.getSeatNumber();
    }

    public String toString() {
        return "Row: " + rowNumber + ", Seat: " + seatNumber + ", Name: " + reservedBy;
    }

}
