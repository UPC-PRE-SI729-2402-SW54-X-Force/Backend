package xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories;

import xforce.drivenowbackend.users.domain.model.aggregates.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    List<Reservation> findByUserId(Long userId);
}
