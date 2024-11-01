package xforce.drivenowbackend.vehicles.domain.services;

import xforce.drivenowbackend.users.domain.model.queries.GetUserByIdQuery;
import xforce.drivenowbackend.vehicles.domain.model.entities.Vehicle;
import xforce.drivenowbackend.vehicles.domain.model.queries.GetAllVehiclesQuery;

import java.util.List;
import java.util.Optional;

public interface VehicleQueryService {
    List<Vehicle> handle(GetAllVehiclesQuery query);
    Optional<Vehicle> handle(GetUserByIdQuery query);
}
