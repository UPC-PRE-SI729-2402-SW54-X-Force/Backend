package xforce.drivenowbackend.users.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record FullName(String firstName, String lastName) {
    public FullName() { this(null, null); }

    public FullName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
    }

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }
}
