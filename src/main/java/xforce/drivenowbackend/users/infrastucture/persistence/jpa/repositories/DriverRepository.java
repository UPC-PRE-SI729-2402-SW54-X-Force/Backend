package xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xforce.drivenowbackend.users.domain.model.aggregates.Driver;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, String> {

}
