package Level3;

import Level3.exceptions.SeatAlreadyReservedException;
import Level3.exceptions.SeatNotReservedException;

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

    public void addSeat(Seat seat) throws SeatAlreadyReservedException {
        if (searchSeat(seat.getRowNumber(), seat.getSeatNumber()) != -1) {
            throw new SeatAlreadyReservedException("Seat is already occupied.");
        }
        seats.add(seat);
    }

    public void removeSeat(int row, int seat) throws SeatNotReservedException {
        for (Seat s : seats) {
            if (s.getRowNumber() == row && s.getSeatNumber() == seat) {
                seats.remove(s);
                System.out.println("Seat reservation canceled successfully.");
                return;
            }
        }
        throw new SeatNotReservedException("This seat is not reserved.");
    }
}
