package xforce.drivenowbackend.users.application;

import org.springframework.stereotype.Service;
import xforce.drivenowbackend.users.domain.model.aggregates.Driver;
import xforce.drivenowbackend.users.domain.model.queries.GetAllDriversQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetDriverByIdQuery;
import xforce.drivenowbackend.users.domain.services.DriverQueryService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.DriverRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DriverQueryServiceImpl implements DriverQueryService {

    private final DriverRepository driverRepository;

    public DriverQueryServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> handle(GetAllDriversQuery query) {
        return this.driverRepository.findAll();
    }

    @Override
    public Optional<Driver> handle(GetDriverByIdQuery query) {
        return this.driverRepository.findById(query.id());
    }
}
