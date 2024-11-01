package xforce.drivenowbackend.vehicles.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.vehicles.domain.model.commands.CreateVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.model.valueobjects.VehicleStatus;

import java.util.Date;

@Getter
@Entity
@Table(name = "vehicles")
public class Vehicle extends AuditableAbstractAggregateRoot<Vehicle> {

    @Column(name = "user_id", nullable = false)
    private Long userId;

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
    public Vehicle(Long userId, String model, Date manufacturerYear, String imageUrl, String description, VehicleStatus status, String insurance) {
        this.userId = userId;
        this.model = model;
        this.manufacturerYear = manufacturerYear;
        this.imageUrl = imageUrl;
        this.description = description;
        this.status = status;
        this.insurance = insurance;
    }

    public Vehicle(CreateVehicleCommand command) {
        this.userId = command.userId();
        this.model = command.model();
        this.manufacturerYear = command.manufacturerYear();
        this.imageUrl = command.imageUrl();
        this.description = command.description();
        this.status = command.status();
        this.insurance = command.insurance();
    }

    // Getters y Setters

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturerYear(Date manufacturerYear) {
        this.manufacturerYear = manufacturerYear;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Vehicle updateInformation(String model, Date manufacturerYear, String imageUrl, String description, VehicleStatus status, String insurance) {
        this.model = model;
        this.manufacturerYear = manufacturerYear;
        this.imageUrl = imageUrl;
        this.description = description;
        this.status = status;
        this.insurance = insurance;
        return this;
    }
}
