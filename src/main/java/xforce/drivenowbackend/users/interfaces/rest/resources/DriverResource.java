package xforce.drivenowbackend.users.interfaces.rest.resources;

public record DriverResource(String id,
                             String name,
                             String age,
                             String email,
                             String address,
                             String pfpUrl,
                             String joined,
                             String licenseId,
                             String licenseSurname,
                             String licenseName,
                             String licenseNumber,
                             String licenseClass,
                             String licenseExpirationDate,
                             String licenseIssueDate,
                             String licenseCategory,
                             String licenseUrlImage) {

}
