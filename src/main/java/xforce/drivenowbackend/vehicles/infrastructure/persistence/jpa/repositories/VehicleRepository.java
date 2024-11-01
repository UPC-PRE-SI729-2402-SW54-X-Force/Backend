package xforce.drivenowbackend.vehicles.infrastructure.persistence.jpa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xforce.drivenowbackend.vehicles.domain.model.aggregates.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
