package Level3;

import Level3.exception.*;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaManager {
    private final Cinema cinema;
    private final SeatManager seatManager;

    public CinemaManager(Cinema cinema) {
        this.cinema = cinema;
        this.seatManager = new SeatManager();
    }

    public List<Seat> getAllReservedSeats() {
        return seatManager.getSeats();
    }

    public List<Seat> getReservedSeatsByPerson(String personName) {
        return seatManager.getSeats().stream()
                .filter(seat -> seat.getReservedBy().equals(personName))
                .collect(Collectors.toList());
    }

    public void reserveSeat(int row, int seat, String personName) throws InvalidRowException, InvalidSeatException, InvalidNameException, SeatAlreadyReservedException {
        validateRow(row);
        validateSeat(seat);
        validateName(personName);
        seatManager.addSeat(new Seat(row, seat, personName));
    }

    public void cancelReservation(int row, int seat) throws InvalidRowException, InvalidSeatException, SeatNotReservedException {
        validateRow(row);
        validateSeat(seat);
        seatManager.removeSeat(row, seat);
    }

    public boolean cancelAllReservationsByPerson(String personName) {
        return seatManager.getSeats().removeIf(seat -> seat.getReservedBy().equals(personName));
    }

    private void validateRow(int row) throws InvalidRowException {
        if (row < 1 || row > cinema.getRows()) {
            throw new InvalidRowException("Row number must be between 1 and " + cinema.getRows() + ".");
        }
    }

    private void validateSeat(int seat) throws InvalidSeatException {
        if (seat < 1 || seat > cinema.getSeatsPerRow()) {
            throw new InvalidSeatException("Seat number must be between 1 and " + cinema.getSeatsPerRow() + ".");
        }
    }

    private void validateName(String name) throws InvalidNameException {
        if (name.matches(".*\\d.*")) {
            throw new InvalidNameException("The name cannot contain numbers.");
        }
        if (name.isEmpty()) {
            throw new InvalidNameException("The name cannot be empty.");
        }
    }
}