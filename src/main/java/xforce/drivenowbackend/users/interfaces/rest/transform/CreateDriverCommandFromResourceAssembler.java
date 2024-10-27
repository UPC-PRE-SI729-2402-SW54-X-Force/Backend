package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.commands.CreateDriverCommand;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateDriverResource;

public class CreateDriverCommandFromResourceAssembler {
    public static CreateDriverCommand toCommandFromResource(CreateDriverResource resource){
        return new CreateDriverCommand(
                resource.name(),
                resource.surname(),
                resource.age(),
                resource.email(),
                resource.address(),
                resource.pfpUrl(),
                resource.joined(),
                resource.licenseId(),
                resource.licenseNumber(),
                resource.licenseClass(),
                resource.expirationDate(),
                resource.issueDate(),
                resource.category(),
                resource.urlImage()
        );
    }
}
