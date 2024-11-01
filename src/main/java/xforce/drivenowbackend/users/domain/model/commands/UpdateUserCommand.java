package xforce.drivenowbackend.users.domain.model.commands;

public record UpdateUserCommand(Long userId, String firstName, String lastName,int age , String email, String street, String number, String city, String postalCode, String country) {
}
