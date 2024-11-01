package xforce.drivenowbackend.vehicles.domain.services;

import xforce.drivenowbackend.vehicles.domain.model.aggregates.Vehicle;
import xforce.drivenowbackend.vehicles.domain.model.queries.GetAllVehiclesQuery;
import xforce.drivenowbackend.vehicles.domain.model.queries.GetVehicleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface VehicleQueryService {
    List<Vehicle> handle(GetAllVehiclesQuery query);
    Optional<Vehicle> handle(GetVehicleByIdQuery query);
}
