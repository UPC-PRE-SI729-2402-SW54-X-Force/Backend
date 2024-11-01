package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.License;
import xforce.drivenowbackend.users.domain.model.commands.CreateLicenseCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateLicenseCommand;

import java.util.Optional;

public interface LicenseCommandService {
    Optional<License> handle(CreateLicenseCommand command);
    Optional<License> handle(UpdateLicenseCommand command);
}
