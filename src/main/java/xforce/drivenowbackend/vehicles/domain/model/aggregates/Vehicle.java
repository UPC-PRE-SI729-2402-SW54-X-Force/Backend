package xforce.drivenowbackend.vehicles.domain.model.entities;

import jakarta.persistence.*;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.vehicles.domain.model.valueobjects.VehicleStatus;

import java.util.Date;

@Entity
@Table(name = "vehicles")
public class Vehicle extends AuditableAbstractAggregateRoot<Vehicle> {

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "manufacturer_year")
    private Date manufacturerYear;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VehicleStatus status;

    @Column(name = "insurance")
    private String insurance;

    // Constructor vacío para JPA
    public Vehicle() {}

    // Constructor completo
    public Vehicle(String userId, String model, Date manufacturerYear, String imageUrl, String description, VehicleStatus status, String insurance) {
        this.userId = userId;
        this.model = model;
        this.manufacturerYear = manufacturerYear;
        this.imageUrl = imageUrl;
        this.description = description;
        this.status = status;
        this.insurance = insurance;
    }

    // Getters y Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufacturerYear() {
        return manufacturerYear;
    }

    public void setManufacturerYear(Date manufacturerYear) {
        this.manufacturerYear = manufacturerYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
