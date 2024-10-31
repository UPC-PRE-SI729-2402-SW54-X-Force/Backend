package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.commands.UpdateUserCommand;
import xforce.drivenowbackend.users.interfaces.rest.resources.UserResource;

public class UpdateUserCommandFromResourceAssembler {
    public static UpdateUserCommand toCommandFromResource(Long userId, UserResource resource){
        return new UpdateUserCommand(userId, resource.firstName(), resource.lastName(), resource.age(), resource.email(), resource.street(), resource.number(), resource.city(), resource.postalCode(), resource.country());
    }
}
