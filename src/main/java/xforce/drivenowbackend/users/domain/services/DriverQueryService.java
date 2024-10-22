package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.Driver;
import xforce.drivenowbackend.users.domain.model.queries.GetAllDriversQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetDriverByIdQuery;

import java.util.Optional;

public interface DriverQueryService {
    Optional<Driver> handle(GetAllDriversQuery query);
    Optional<Driver> handle(GetDriverByIdQuery query);
}
