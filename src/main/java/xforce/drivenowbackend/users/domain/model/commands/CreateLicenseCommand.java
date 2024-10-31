package xforce.drivenowbackend.users.domain.model.commands;

import java.util.Date;

public record CreateLicenseCommand(String firstName, String lastName, int licenceNumber, String licenseClass, String licenseCategory, String licenseUrlImage, Date expirationDate, Date issueDate) {
}
