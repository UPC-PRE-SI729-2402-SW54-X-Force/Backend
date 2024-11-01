package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.commands.CreateUserCommand;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.firstName(),
                resource.lastName(),
                resource.age(),
                resource.email(),
                resource.street(),
                resource.number(),
                resource.city(),
                resource.postalCode(),
                resource.country()
        );
    }
}
