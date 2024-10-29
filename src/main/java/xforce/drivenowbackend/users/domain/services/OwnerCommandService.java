package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.Owner;
import xforce.drivenowbackend.users.domain.model.commands.CreateOwnerCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateOwnerCommand;

import java.util.Optional;

public interface OwnerCommandService {

    Optional<Owner> handle(CreateOwnerCommand command);
    Optional<Owner> handle(UpdateOwnerCommand command);
}
