package xforce.drivenowbackend.users.application;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import xforce.drivenowbackend.users.domain.model.aggregates.User;
import xforce.drivenowbackend.users.domain.model.commands.CreateUserCommand;
import xforce.drivenowbackend.users.domain.model.commands.DeleteUserCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateUserCommand;
import xforce.drivenowbackend.users.domain.model.valueobjects.EmailAddress;
import xforce.drivenowbackend.users.domain.services.UserCommandService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        var emailAddress = new EmailAddress(command.email());
        userRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email "+ emailAddress.email() + " already exists");
        });

        var user = new User(command);
        var createdProfile = userRepository.save(user);
        return Optional.of(createdProfile);
    }

    @Override
    public Optional<User> handle(UpdateUserCommand command) {
        var userId = command.userId();
        if (!this.userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with id " + userId + " does not exist");
        }

        var userToUpdate = this.userRepository.findById(userId).get();
        userToUpdate.updateInformation(command.firstName(),command.lastName(), command.age(), command.email(), command.street(), command.number(), command.city(), command.postalCode(),command.country());

        try {
            var updatedUser = this.userRepository.save(userToUpdate);
            return Optional.of(updatedUser);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating user: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteUserCommand command) {
        var userId = command.userId();
        if (!this.userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with id " + userId + " does not exist");
        }

        try{
            this.userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting user: " + e.getMessage());
        }
    }
}
