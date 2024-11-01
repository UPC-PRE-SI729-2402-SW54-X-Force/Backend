package xforce.drivenowbackend.users.interfaces.rest;

import xforce.drivenowbackend.users.application.ReservationCommandServiceImpl;
import xforce.drivenowbackend.users.application.ReservationQueryServiceImpl;
import xforce.drivenowbackend.users.domain.model.aggregates.Reservation;
import xforce.drivenowbackend.users.domain.model.commands.CreateReservationCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateReservationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationCommandServiceImpl reservationCommandService;
    private final ReservationQueryServiceImpl reservationQueryService;

    @Autowired
    public ReservationController(ReservationCommandServiceImpl reservationCommandService,
                                 ReservationQueryServiceImpl reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody CreateReservationCommand command) {
        Reservation reservation = reservationCommandService.createReservation(command);
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody UpdateReservationCommand command) {
        command.setReservationId(id);
        Reservation updatedReservation = reservationCommandService.updateReservation(command);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationCommandService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationQueryService.getReservationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable Long userId) {
        List<Reservation> reservations = reservationQueryService.getReservationsByUserId(userId);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationQueryService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
}
