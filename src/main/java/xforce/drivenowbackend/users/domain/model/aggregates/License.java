package xforce.drivenowbackend.users.domain.model.aggregates;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.users.domain.model.valueobjects.FullName;

import java.util.Date;

@Entity
@Table(name = "licenses")
public class License extends AuditableAbstractAggregateRoot<License> {
    @Getter
    private FullName name;
    @Getter
    private int licenceNumber;
    @Getter
    private String licenseClass;
    @Getter
    private String licenseCategory;
    @Getter
    private String licenseUrlImage;
    @Getter
    private Date expirationDate;
    @Getter
    private Date issueDate;

    public License(){}

    public License(String firstName, String lastName, int licenceNumber, String licenseClass, String licenseCategory, String licenseUrlImage, Date expirationDate, Date issueDate) {
        this.name = new FullName(firstName, lastName);
        this.licenceNumber = licenceNumber;
        this.licenseClass = licenseClass;
        this.licenseCategory = licenseCategory;
        this.licenseUrlImage = licenseUrlImage;
        this.expirationDate = expirationDate;
        this.issueDate = issueDate;
    }

}
