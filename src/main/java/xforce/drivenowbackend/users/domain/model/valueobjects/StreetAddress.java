package xforce.drivenowbackend.users.domain.model.valueobjects;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
public record StreetAddress(
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {
    public StreetAddress(){
        this("","","","","");
    }

    public StreetAddress(String street, String city, String postalCode, String country) {
        this(street, null, city, postalCode, country);
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getStreetAddress(){
        return String.format("%s %s %s %s %s", street, number, city, postalCode, country);
    }

    public StreetAddress {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street is required");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City is required");
        }

        if (postalCode == null || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code is required");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country is required");
        }
    }
}
