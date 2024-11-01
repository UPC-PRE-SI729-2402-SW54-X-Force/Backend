package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.License;
import xforce.drivenowbackend.users.domain.model.queries.GetLicenseByIdQuery;

import java.util.Optional;

public interface LicenseQueryService {
    Optional<License> handle(GetLicenseByIdQuery query);
}
