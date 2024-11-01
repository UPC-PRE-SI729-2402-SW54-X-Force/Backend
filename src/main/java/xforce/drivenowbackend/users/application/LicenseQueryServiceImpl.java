package xforce.drivenowbackend.users.application;

import org.springframework.stereotype.Service;
import xforce.drivenowbackend.users.domain.model.aggregates.License;
import xforce.drivenowbackend.users.domain.model.queries.GetLicenseByIdQuery;
import xforce.drivenowbackend.users.domain.services.LicenseQueryService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.LicenseRepository;

import java.util.Optional;

@Service
public class LicenseQueryServiceImpl implements LicenseQueryService {

    private final LicenseRepository licenseRepository;

    public LicenseQueryServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public Optional<License> handle(GetLicenseByIdQuery query) {
        return this.licenseRepository.findById(query.licenseId());
    }
}
