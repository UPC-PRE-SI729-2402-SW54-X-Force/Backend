package xforce.drivenowbackend.users.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.users.domain.model.commands.CreateUserCommand;
import xforce.drivenowbackend.users.domain.model.valueobjects.EmailAddress;
import xforce.drivenowbackend.users.domain.model.valueobjects.FullName;
import xforce.drivenowbackend.users.domain.model.valueobjects.StreetAddress;

@Entity
@Table(name = "users")
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

    public User (CreateUserCommand command)
    {
        this.name = new FullName(command.firstName(), command.lastName());
        this.age = command.age();
        this.email = new EmailAddress(command.email());
        this.address = new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getLastName() {
        return name.getLastName();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }

    public String getStreet(){
        return address.getStreet();
    }

    public String getNumber(){
        return address.getNumber();
    }

    public String getCity(){
        return address.getCity();
    }

    public String getPostalCode(){
        return address.getPostalCode();
    }

    public String getCountry(){
        return address.getCountry();
    }

    public String getEmailAddress() {
        return email.email();
    }

    public User updateInformation(String firstName, String lastName,int age, String email, String street, String number, String city, String postalCode, String country) {
        this.name = new FullName(firstName, lastName);
        this.age = age;
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(street, number, city, postalCode, country);
        return this;
    }
}
