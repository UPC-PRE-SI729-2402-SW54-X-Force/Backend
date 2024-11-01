package xforce.drivenowbackend.vehicles.interfaces.rest.resources;

import xforce.drivenowbackend.vehicles.domain.model.valueobjects.VehicleStatus;

import java.util.Date;

public record VehicleResource(Long id,Long userId, String model, Date manufacturerYear, String imageUrl, String description, VehicleStatus status, String insurance) {

}
