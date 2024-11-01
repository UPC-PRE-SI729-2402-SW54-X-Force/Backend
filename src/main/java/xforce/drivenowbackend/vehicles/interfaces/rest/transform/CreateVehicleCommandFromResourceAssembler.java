package xforce.drivenowbackend.vehicles.interfaces.rest.transform;

import xforce.drivenowbackend.vehicles.domain.model.commands.CreateVehicleCommand;
import xforce.drivenowbackend.vehicles.interfaces.rest.resources.CreateVehicleResource;

public class CreateVehicleCommandFromResourceAssembler {
    public static CreateVehicleCommand toCommandFromResource(CreateVehicleResource resource) {
        return new CreateVehicleCommand(
                resource.userId(),
                resource.model(),
                resource.manufacturerYear(),
                resource.imageUrl(),
                resource.description(),
                resource.status(),
                resource.insurance()
        );
    }
}
