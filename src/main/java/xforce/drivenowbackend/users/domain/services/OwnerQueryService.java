package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.Owner;
import xforce.drivenowbackend.users.domain.model.queries.GetAllOwnersQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetOwnerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface OwnerQueryService {
    List<Owner> handle(GetAllOwnersQuery query);
    Optional<Owner> handle(GetOwnerByIdQuery query);
}
