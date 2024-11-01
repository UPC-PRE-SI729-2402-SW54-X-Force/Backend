package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.commands.CreateLicenseCommand;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateLicenseResource;

public class CreateLicenseCommandFromResourceAssembler {
    public static CreateLicenseCommand toCommandFromResource(CreateLicenseResource resource) {
        return new CreateLicenseCommand(
                resource.firstName(),
                resource.lastName(),
                resource.licenceNumber(),
                resource.licenseClass(),
                resource.licenseCategory(),
                resource.licenseUrlImage(),
                resource.expirationDate(),
                resource.issueDate()
        );
    }
}
