package xforce.drivenowbackend.users.domain.services;

public interface OwnerCommandService {

    Optional<Owner> handle(CreateDriverCommand command);
}
