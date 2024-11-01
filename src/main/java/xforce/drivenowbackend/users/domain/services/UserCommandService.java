package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.User;
import xforce.drivenowbackend.users.domain.model.commands.CreateUserCommand;
import xforce.drivenowbackend.users.domain.model.commands.DeleteUserCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateUserCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
    Optional<User> handle(UpdateUserCommand command);
    void handle(DeleteUserCommand command);
}
