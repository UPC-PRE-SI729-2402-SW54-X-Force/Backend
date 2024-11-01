package xforce.drivenowbackend.vehicles.application;

import org.springframework.stereotype.Service;
import xforce.drivenowbackend.vehicles.domain.model.commands.CreateVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.model.commands.DeleteVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.model.commands.UpdateVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.services.VehicleCommandService;
import xforce.drivenowbackend.vehicles.infrastructure.persistence.jpa.repositories.VehicleRepository;
import xforce.drivenowbackend.vehicles.domain.model.aggregates.Vehicle;

import java.util.Optional;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {

    private final VehicleRepository vehicleRepository;

    public VehicleCommandServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> handle(CreateVehicleCommand command) {

        vehicleRepository.findById(command.userId()).ifPresent(vehicle -> {
            throw new IllegalArgumentException("Vehicle with ID " + command.userId() + " already exists");
        });

        var vehicle = new Vehicle(command);

        var createdVehicle = vehicleRepository.save(vehicle);
        return Optional.of((Vehicle) createdVehicle);
    }

    @Override
    public void handle(DeleteVehicleCommand command) {
        var vehicleId = command.vehicleId();
        if (!this.vehicleRepository.existsById(vehicleId)) {
            throw new IllegalArgumentException("Vehicle with id " + vehicleId + " does not exist");
        }

        try {
            this.vehicleRepository.deleteById(vehicleId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting vehicle: " + e.getMessage());
        }
    }

    @Override
    public Optional<Vehicle> handle(UpdateVehicleCommand command) {
        var vehicleId = command.userId();

        if (!this.vehicleRepository.existsById(vehicleId)) {
            throw new IllegalArgumentException("Vehicle with id " + vehicleId + " does not exist");
        }

        var vehicleToUpdate = this.vehicleRepository.findById(vehicleId).get();
        vehicleToUpdate.updateInformation(command.model(), command.manufacturerYear(), command.imageUrl(), command.description(), command.status(), command.insurance());

        try {
            var updatedVehicle = this.vehicleRepository.save(vehicleToUpdate);
            return Optional.of(updatedVehicle);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating vehicle: " + e.getMessage());
        }
    }


}
