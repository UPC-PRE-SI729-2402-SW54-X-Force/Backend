package xforce.drivenowbackend.vehicles.interfaces.rest.transform;

import xforce.drivenowbackend.vehicles.domain.model.aggregates.Vehicle;
import xforce.drivenowbackend.vehicles.interfaces.rest.resources.VehicleResource;

public class VehicleResourceFromEntityAssembler {
    public static VehicleResource toResourceFromEntity(Vehicle entity) {
        return new VehicleResource(
                entity.getId(),
                entity.getUserId(),
                entity.getModel(),
                entity.getManufacturerYear(),
                entity.getImageUrl(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getInsurance()
        );
    }
}
