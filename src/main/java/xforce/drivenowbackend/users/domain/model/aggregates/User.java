package xforce.drivenowbackend.users.domain.model.aggregates;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.users.domain.model.valueobjects.EmailAddress;
import xforce.drivenowbackend.users.domain.model.valueobjects.FullName;
import xforce.drivenowbackend.users.domain.model.valueobjects.StreetAddress;

public class User extends AuditableAbstractAggregateRoot<User> {
    private FullName name;
    @Getter
    @Min(0)
    @Max(100)
    @Column(name = "age", columnDefinition = "smallint", nullable = false)
    private int age;
    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "email_address"))
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postalCode")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country")),
    })
    private StreetAddress address;

    public User(){}

    public User(String firstName, String lastName,int age, String email, String street, String number, String city, String postalCode, String country) {
        this.name = new FullName(firstName, lastName);
        this.age = age;
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(street, number, city, postalCode, country);
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }

    public String getEmailAddress() {
        return email.email();
    }
}
