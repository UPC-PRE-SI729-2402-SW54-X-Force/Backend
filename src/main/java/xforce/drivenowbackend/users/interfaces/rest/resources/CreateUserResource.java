package xforce.drivenowbackend.users.interfaces.rest.resources;

public record CreateUserResource(String firstName, String lastName,
                                 int age, String email,
                                 String street, String number,
                                 String city, String postalCode,
                                 String country) {
}
