package xforce.drivenowbackend.vehicles.application;


import org.springframework.stereotype.Service;
import xforce.drivenowbackend.vehicles.domain.model.aggregates.Vehicle;
import xforce.drivenowbackend.vehicles.domain.model.queries.GetAllVehiclesQuery;
import xforce.drivenowbackend.vehicles.domain.model.queries.GetVehicleByIdQuery;
import xforce.drivenowbackend.vehicles.domain.services.VehicleQueryService;
import xforce.drivenowbackend.vehicles.infrastructure.persistence.jpa.repositories.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleQueryServiceImpl implements VehicleQueryService {

    private final VehicleRepository vehicleRepository;

    public VehicleQueryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> handle(GetAllVehiclesQuery query) {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> handle(GetVehicleByIdQuery query) {
        return this.vehicleRepository.findById(query.vehicleId());
    }
}
