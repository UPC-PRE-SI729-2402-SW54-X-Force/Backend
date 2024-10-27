package xforce.drivenowbackend.users.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.users.domain.model.commands.CreateDriverCommand;
import xforce.drivenowbackend.users.domain.model.valueobjects.License;

@Entity
@Getter
@Setter
public class Driver extends AuditableAbstractAggregateRoot<Driver> {

    String name;
    String age;
    String email;
    String address;
    String pfpUrl;
    String joined;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "license_idr")),
            @AttributeOverride(name = "surname", column = @Column(name = "license_surname")),
            @AttributeOverride(name = "name", column = @Column(name = "license_name")),
            @AttributeOverride(name = "licenseNumber", column = @Column(name = "license_number")),
            @AttributeOverride(name = "licenseClass", column = @Column(name = "license_class")),
            @AttributeOverride(name = "expirationDate", column = @Column(name = "license_expirationDate")),
            @AttributeOverride(name = "issueDate", column = @Column(name = "license_issueDate")),
            @AttributeOverride(name = "category", column = @Column(name = "license_category")),
            @AttributeOverride(name = "urlImage", column = @Column(name = "license_urlImage"))
    })
    License license;

    public Driver(){
    }

    public Driver(String name, String surname, String age, String email, String address, String pfpUrl, String joined, String licenseId, String licenseNumber, String licenseClass, String expirationDate, String issueDate, String category, String urlImage) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.pfpUrl = pfpUrl;
        this.joined = joined;
        this.license = new License(licenseId, surname, name, licenseNumber, licenseClass, expirationDate, issueDate, category, urlImage);
    }

    public Driver(CreateDriverCommand command){
        this.name = command.name();
        this.age = command.age();
        this.email = command.email();
        this.address = command.address();
        this.pfpUrl = command.pfpUrl();
        this.joined = command.joined();
        this.license = new License(command.licenseId(), command.surname(), command.name(), command.licenseNumber(), command.licenseClass(), command.expirationDate(), command.issueDate(), command.category(), command.urlImage());
    }

    public String getLicenseId() {
        return license.getId();
    }
    public String getLicenseSurname() {
        return license.getSurname();
    }
    public String getLicenseName() {
        return license.getName();
    }
    public String getLicenseNumber() {
        return license.getLicenseNumber();
    }
    public String getLicenseClass() {
        return license.getLicenseClass();
    }
    public String getLicenseExpirationDate() {
        return license.getExpirationDate();
    }
    public String getLicenseIssueDate() {
        return license.getIssueDate();
    }
    public String getLicenseCategory() {
        return license.getCategory();
    }
    public String getLicenseUrlImage() {
        return license.getUrlImage();
    }
}
