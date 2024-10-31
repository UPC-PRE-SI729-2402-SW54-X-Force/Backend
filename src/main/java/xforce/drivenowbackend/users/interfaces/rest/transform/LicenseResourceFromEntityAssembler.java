package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.aggregates.License;
import xforce.drivenowbackend.users.interfaces.rest.resources.LicenseResource;

public class LicenseResourceFromEntityAssembler {
    public static LicenseResource toResourceFromEntity(License entity){
        return new LicenseResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getLicenceNumber(),
                entity.getLicenseClass(),
                entity.getLicenseCategory(),
                entity.getLicenseUrlImage(),
                entity.getExpirationDate(),
                entity.getIssueDate()
        );
    }
}
