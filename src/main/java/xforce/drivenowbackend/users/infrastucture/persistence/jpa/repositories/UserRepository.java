package xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xforce.drivenowbackend.users.domain.model.aggregates.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
