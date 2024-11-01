package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.commands.UpdateLicenseCommand;
import xforce.drivenowbackend.users.interfaces.rest.resources.LicenseResource;

public class UpdateLicenseCommandFromResourceAssembler {
    public static UpdateLicenseCommand toCommandFromResource(Long licenseId, LicenseResource resource) {
        return new UpdateLicenseCommand(
                licenseId,
                resource.firstName(),
                resource.lastName(),
                resource.licenceNumber(),
                resource.licenseClass(),
                resource.licenseCategory(),
                resource.licenseUrlImage(),
                resource.expirationDate(),
                resource.issueDate());
    }
}
