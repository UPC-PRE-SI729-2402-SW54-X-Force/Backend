package xforce.drivenowbackend.users.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class ReservationDate {
    private Date reservationDate;

    protected ReservationDate() {

    }

    public ReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }
}
