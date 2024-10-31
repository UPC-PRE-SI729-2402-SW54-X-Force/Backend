package xforce.drivenowbackend.users.application;

import org.springframework.stereotype.Service;
import xforce.drivenowbackend.users.domain.model.aggregates.Driver;
import xforce.drivenowbackend.users.domain.model.commands.CreateDriverCommand;
import xforce.drivenowbackend.users.domain.services.DriverCommandService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.DriverRepository;

import java.util.Optional;

@Service
public class DriverCommandServiceImpl implements DriverCommandService {
    private final DriverRepository driverRepository;

    public DriverCommandServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    @Override
    public Optional<Driver> handle(CreateDriverCommand command) {
        var driver = new Driver(command);
        var createdDriver = driverRepository.save(driver);
        return Optional.of(createdDriver);
    }
}
