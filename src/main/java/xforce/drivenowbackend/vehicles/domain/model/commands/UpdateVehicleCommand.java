package xforce.drivenowbackend.vehicles.domain.model.commands;

import xforce.drivenowbackend.vehicles.domain.model.valueobjects.VehicleStatus;

import java.util.Date;

public record UpdateVehicleCommand(Long userId, String model, Date manufacturerYear, String imageUrl, String description, VehicleStatus status, String insurance) {
}