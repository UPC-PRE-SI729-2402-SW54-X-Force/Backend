package xforce.drivenowbackend.users.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record License(String id, String surname,
                      String name, String licenseNumber,
                      String licenseClass, String expirationDate,
                      String issueDate, String category,
                      String urlImage) {
    public License() {
        this("","", "", "", "", "", "", "", "");
    }
    public License {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("License id is required");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("License surname is required");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("License name is required");
        }
        if (licenseNumber == null || licenseNumber.isBlank()) {
            throw new IllegalArgumentException("License number is required");
        }
        if (licenseClass == null || licenseClass.isBlank()) {
            throw new IllegalArgumentException("License class is required");
        }
        if (expirationDate == null || expirationDate.isBlank()) {
            throw new IllegalArgumentException("License expiration date is required");
        }
        if (issueDate == null || issueDate.isBlank()) {
            throw new IllegalArgumentException("License issue date is required");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("License category is required");
        }
        if (urlImage == null || urlImage.isBlank()) {
            throw new IllegalArgumentException("License url image is required");
        }
    }
}
