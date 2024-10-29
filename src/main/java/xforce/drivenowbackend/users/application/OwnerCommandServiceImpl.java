package xforce.drivenowbackend.users.application;

import org.springframework.stereotype.Service;
import xforce.drivenowbackend.users.domain.model.aggregates.Owner;
import xforce.drivenowbackend.users.domain.model.commands.CreateOwnerCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateOwnerCommand;
import xforce.drivenowbackend.users.domain.services.OwnerCommandService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.OwnerRepository;

import java.util.Optional;

@Service
public class OwnerCommandServiceImpl implements OwnerCommandService {
    private final OwnerRepository ownerRepository;

    public OwnerCommandServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Optional<Owner> handle(CreateOwnerCommand command) {
        var owner = new Owner(command);
        var createdOwner = ownerRepository.save(owner);
        return Optional.of(createdOwner);
    }

    @Override
    public Optional<Owner> handle(UpdateOwnerCommand command) {
        return Optional.empty();
    }
}
