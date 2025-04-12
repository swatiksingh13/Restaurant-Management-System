package in.coding;

import java.sql.Timestamp;

public class Reservation {
    private final int id;
    private final String customerName;
    private final String contactNumber;
    private final int partySize;
    private final Timestamp reservationTime;

    public Reservation(int id, String customerName, String contactNumber, int partySize, Timestamp reservationTime) {
        this.id = id;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.partySize = partySize;
        this.reservationTime = reservationTime;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public int getPartySize() {
        return partySize;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }
}
