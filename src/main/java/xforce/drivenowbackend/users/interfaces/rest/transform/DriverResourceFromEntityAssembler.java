package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.aggregates.Driver;
import xforce.drivenowbackend.users.interfaces.rest.resources.DriverResource;

public class DriverResourceFromEntityAssembler {
    public static DriverResource toResourceFromEntity(Driver entity) {
        return new DriverResource(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getPfpUrl(),
                entity.getJoined(),
                entity.getLicenseId(),
                entity.getLicenseSurname(),
                entity.getLicenseName(),
                entity.getLicenseNumber(),
                entity.getLicenseClass(),
                entity.getLicenseExpirationDate(),
                entity.getLicenseIssueDate(),
                entity.getLicenseCategory(),
                entity.getLicenseUrlImage()
        );
    }
}
