package xforce.drivenowbackend.users.domain.model.commands;

public record CreateDriverCommand(String name, String surname, String age, String email, String address, String pfpUrl, String joined, String licenseId, String licenseNumber, String licenseClass, String expirationDate, String issueDate, String category, String urlImage) {
}
