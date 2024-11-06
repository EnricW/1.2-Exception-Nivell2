package Level3;

import java.util.ArrayList;

public class SeatManager {
    private ArrayList<Seat> seats;

    public SeatManager() {
        this.seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public int searchSeat(int row, int seat) {
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getRowNumber() == row && seats.get(i).getSeatNumber() == seat) {
                return i;
            }
        }
        return -1;
    }

    public void addSeat(Seat seat) throws Exception {
        if (searchSeat(seat.getRowNumber(), seat.getSeatNumber()) != -1) {
            throw new Exception("Seat is already occupied.");
        }
        seats.add(seat);
    }

    public void removeSeat(int row, int seat) throws Exception {
        int index = searchSeat(row, seat);
        if (index == -1) {
            throw new Exception("Seat is not reserved.");
        }
        seats.remove(index);
    }
}
