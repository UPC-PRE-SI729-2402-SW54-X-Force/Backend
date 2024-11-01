package xforce.drivenowbackend.users.domain.model.commands;

import java.util.Date;

public class CreateReservationCommand {
    private Long userId;
    private Long offerId;
    private Date startDate;
    private Date endDate;
    private Double cost;


    public CreateReservationCommand(Long userId, Long offerId, Date startDate, Date endDate, Double cost) {
        this.userId = userId;
        this.offerId = offerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOfferId() {
        return offerId;
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
