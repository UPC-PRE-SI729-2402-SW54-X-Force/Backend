package xforce.drivenowbackend.vehicles.interfaces.rest.transform;

import xforce.drivenowbackend.vehicles.domain.model.commands.UpdateVehicleCommand;
import xforce.drivenowbackend.vehicles.interfaces.rest.resources.VehicleResource;

public class UpdateVehicleCommandFromResourceAssembler {
    public static UpdateVehicleCommand toCommandFromResource(Long vehicleId, VehicleResource resource) {
        return new UpdateVehicleCommand(vehicleId, resource.userId(), resource.model(), resource.manufacturerYear(), resource.imageUrl(), resource.description(), resource.status(), resource.insurance());

    }
}
