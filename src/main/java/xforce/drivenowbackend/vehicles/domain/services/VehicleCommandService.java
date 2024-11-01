package xforce.drivenowbackend.vehicles.domain.services;
import xforce.drivenowbackend.vehicles.domain.model.commands.CreateVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.model.commands.DeleteVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.model.commands.UpdateVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.model.entities.Vehicle;

import java.util.Optional;

public interface VehicleCommandService {
    Optional<Vehicle> handle(CreateVehicleCommand command);
    Optional<Vehicle> handle(UpdateVehicleCommand command);
    void handle(DeleteVehicleCommand command);
}
