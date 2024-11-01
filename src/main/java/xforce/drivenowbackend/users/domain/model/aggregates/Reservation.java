package xforce.drivenowbackend.users.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.users.domain.model.commands.CreateReservationCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateReservationCommand;
import xforce.drivenowbackend.users.domain.model.valueobjects.ReservationDate;
import xforce.drivenowbackend.users.domain.model.valueobjects.ReservationPeriod;

import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Getter
    @Column(name = "offer_id", nullable = false)
    private Long offerId;

    @Embedded
    @AttributeOverride(name = "reservationDate", column = @Column(name = "reservation_date", nullable = false))
    private ReservationDate reservationDate;

    @Embedded
    private ReservationPeriod reservationPeriod;

    @Getter
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Getter
    @Column(name = "cost", nullable = false)
    private Double cost;

    protected Reservation() {}

    public Reservation(Long userId, Long offerId, ReservationPeriod reservationPeriod, Double cost) {
        this.userId = userId;
        this.offerId = offerId;
        this.reservationDate = new ReservationDate(new Date());
        this.reservationPeriod = reservationPeriod;
        this.status = "Pending";
        this.cost = cost;
    }

    public Reservation(CreateReservationCommand command) {
        this.userId = command.getUserId();
        this.offerId = command.getOfferId();
        this.reservationDate = new ReservationDate(new Date());
        this.reservationPeriod = new ReservationPeriod(command.getStartDate(), command.getEndDate());
        this.status = "Pending";
        this.cost = command.getCost();
    }

    public void update(UpdateReservationCommand command) {
        this.reservationPeriod = new ReservationPeriod(command.getStartDate(), command.getEndDate());
        this.cost = command.getCost();
    }


    public void cancel() {
        this.status = "Cancelled";
    }

    public void completeReservation() {
        this.status = "Completed";
    }

    public Date getStartDate() {
        return reservationPeriod.getStartDate();
    }

    public Date getEndDate() {
        return reservationPeriod.getEndDate();
    }

    public Date getReservationDate() {
        return reservationDate.getReservationDate();
    }

    public Long getId() {
        return id;
    }
}
