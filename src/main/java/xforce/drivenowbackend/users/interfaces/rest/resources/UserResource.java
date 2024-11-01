package xforce.drivenowbackend.users.interfaces.rest.resources;

public record UserResource(Long id, String firstName,
                           String lastName,int age,
                           String email, String street,
                           String number, String city,
                           String postalCode, String country){
}
