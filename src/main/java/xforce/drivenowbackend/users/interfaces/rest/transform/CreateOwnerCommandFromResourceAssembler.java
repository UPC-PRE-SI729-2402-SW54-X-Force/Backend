package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.commands.CreateOwnerCommand;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateOwnerResource;

public class CreateOwnerCommandFromResourceAssembler {

    public static CreateOwnerCommand toCommandFromResource(CreateOwnerResource resource) {
        return new CreateOwnerCommand(
                resource.name(),
                resource.email(),
                resource.dni()
        );
    }
}
