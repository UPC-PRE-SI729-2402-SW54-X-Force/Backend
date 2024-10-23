package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.Driver;
import xforce.drivenowbackend.users.domain.model.commands.CreateDriverCommand;

import java.util.Optional;

public interface DriverCommandService {
    Optional<Driver> handle (CreateDriverCommand command);
}
