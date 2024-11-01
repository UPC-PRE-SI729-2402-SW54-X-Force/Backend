package xforce.drivenowbackend.users.application;

import xforce.drivenowbackend.users.domain.model.commands.CreateReservationCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateReservationCommand;
import xforce.drivenowbackend.users.domain.model.aggregates.Reservation;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationCommandServiceImpl {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(CreateReservationCommand command) {
        Reservation reservation = new Reservation(command);
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(UpdateReservationCommand command) {
        Reservation reservation = reservationRepository.findById(command.getReservationId())
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
        reservation.update(command);
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
        reservation.cancel();
        reservationRepository.save(reservation);
    }
}
