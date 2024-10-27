package xforce.drivenowbackend.users.interfaces.rest.resources;

public record CreateDriverResource(String name, String surname,
                                   String age, String email,
                                   String address, String pfpUrl,
                                   String joined, String licenseId,
                                   String licenseNumber, String licenseClass,
                                   String expirationDate, String issueDate,
                                   String category, String urlImage) {
}
