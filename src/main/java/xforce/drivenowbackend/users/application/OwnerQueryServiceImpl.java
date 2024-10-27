package xforce.drivenowbackend.users.application;

import org.springframework.stereotype.Service;
import xforce.drivenowbackend.users.domain.model.aggregates.Owner;
import xforce.drivenowbackend.users.domain.model.queries.GetAllOwnersQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetOwnerByIdQuery;
import xforce.drivenowbackend.users.domain.services.OwnerQueryService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.OwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerQueryServiceImpl implements OwnerQueryService {

    private final OwnerRepository ownerRepository;

    public OwnerQueryServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> handle(GetAllOwnersQuery query) {
        return  this.ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> handle(GetOwnerByIdQuery query) {
        return this.ownerRepository.findById(query.id());
    }
}
