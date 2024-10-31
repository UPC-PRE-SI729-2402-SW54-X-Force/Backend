package xforce.drivenowbackend.users.application;

import xforce.drivenowbackend.users.domain.model.aggregates.License;
import xforce.drivenowbackend.users.domain.model.commands.CreateLicenseCommand;
import xforce.drivenowbackend.users.domain.model.commands.UpdateLicenseCommand;
import xforce.drivenowbackend.users.domain.services.LicenseCommandService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.LicenseRepository;

import java.util.Optional;

public class LicenseCommandServiceImpl implements LicenseCommandService {

    private final LicenseRepository licenseRepository;

    public LicenseCommandServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public Optional<License> handle(CreateLicenseCommand command) {
        var license = new License(command);
        var createdLicense = licenseRepository.save(license);
        return Optional.of(createdLicense);
    }

    @Override
    public Optional<License> handle(UpdateLicenseCommand command) {
        var licenseId = command.licenseId();
        if (!licenseRepository.existsById(licenseId)) {
            throw new IllegalArgumentException("License with id " + licenseId + " does not exist");
        }

        var licenseToUpdate = this.licenseRepository.findById(licenseId).get();
        licenseToUpdate.updateInformation(command.firstName(), command.lastName(), command.licenceNumber(), command.licenseClass(),command.licenseCategory(),command.licenseUrlImage(), command.expirationDate(), command.issueDate());
        try{
            var updatedLicense = this.licenseRepository.save(licenseToUpdate);
            return Optional.of(updatedLicense);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating license with id " + licenseId);
        }
    }
}
