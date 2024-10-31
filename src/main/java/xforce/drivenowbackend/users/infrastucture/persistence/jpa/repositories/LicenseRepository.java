package xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xforce.drivenowbackend.users.domain.model.aggregates.License;

public interface LicenseRepository extends JpaRepository<License, Long> {

}
