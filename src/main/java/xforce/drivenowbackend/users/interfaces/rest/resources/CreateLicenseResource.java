package xforce.drivenowbackend.users.interfaces.rest.resources;

import java.util.Date;

public record CreateLicenseResource(String firstName, String lastName,
                                    int licenceNumber, String licenseClass,
                                    String licenseCategory, String licenseUrlImage,
                                    Date expirationDate, Date issueDate) {
}
