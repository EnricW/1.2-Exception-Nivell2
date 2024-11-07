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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Seat)) return false;
        Seat seat = (Seat) obj;
        return rowNumber == seat.rowNumber && seatNumber == seat.seatNumber;
    }

    @Override
    public String toString() {
        return "Row: " + rowNumber + ", Seat: " + seatNumber + ", Reserved by: " + reservedBy;
    }
}
