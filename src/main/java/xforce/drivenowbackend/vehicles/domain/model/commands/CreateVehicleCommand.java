package xforce.drivenowbackend.vehicles.domain.model.commands;

import xforce.drivenowbackend.vehicles.domain.model.valueobjects.VehicleStatus;

import java.util.Date;

public record CreateVehicleCommand(Long userID, String model, Date manufacturer_year, String image_url, String description, VehicleStatus status, String insurance) {
}
