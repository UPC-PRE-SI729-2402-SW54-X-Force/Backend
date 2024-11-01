package xforce.drivenowbackend.users.domain.model.commands;

import java.util.Date;

public class UpdateReservationCommand {
    private Long reservationId;
    private Date startDate;
    private Date endDate;
    private Double cost;

    public UpdateReservationCommand(Long reservationId, Date startDate, Date endDate, Double cost) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }


    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getCost() {
        return cost;
    }
}
