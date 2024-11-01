package xforce.drivenowbackend.users.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xforce.drivenowbackend.users.domain.model.queries.GetLicenseByIdQuery;
import xforce.drivenowbackend.users.domain.services.LicenseCommandService;
import xforce.drivenowbackend.users.domain.services.LicenseQueryService;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateLicenseResource;
import xforce.drivenowbackend.users.interfaces.rest.resources.LicenseResource;
import xforce.drivenowbackend.users.interfaces.rest.transform.CreateLicenseCommandFromResourceAssembler;
import xforce.drivenowbackend.users.interfaces.rest.transform.LicenseResourceFromEntityAssembler;
import xforce.drivenowbackend.users.interfaces.rest.transform.UpdateLicenseCommandFromResourceAssembler;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/licenses", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Licenses", description = "License Management Endpoints")
public class LicenseController {

    private final LicenseQueryService licenseQueryService;
    private final LicenseCommandService licenseCommandService;

    public LicenseController(LicenseQueryService licenseQueryService, LicenseCommandService licenseCommandService) {
        this.licenseQueryService = licenseQueryService;
        this.licenseCommandService = licenseCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new license", description = "Create a new license for a user with the given data.")
    public ResponseEntity<LicenseResource> createLicense(@RequestBody CreateLicenseResource resource){
        var createLicenseCommand = CreateLicenseCommandFromResourceAssembler.toCommandFromResource(resource);
        var license = this.licenseCommandService.handle(createLicenseCommand);

        if(license.isEmpty()) return ResponseEntity.badRequest().build();

        var licenseResource = LicenseResourceFromEntityAssembler.toResourceFromEntity(license.get());

        return new ResponseEntity<>(licenseResource, HttpStatus.CREATED);
    }

    @GetMapping("/{licenseId}")
    @Operation(summary = "Get a license by ID", description = "Returns the license with the provided id.")
    public ResponseEntity<LicenseResource> getLicenseById(@PathVariable Long licenseId){
        var getLicenseByIdQuery = new GetLicenseByIdQuery(licenseId);
        var license = this.licenseQueryService.handle(getLicenseByIdQuery);
        if(license.isEmpty()) return ResponseEntity.badRequest().build();
        var licenseResource = LicenseResourceFromEntityAssembler.toResourceFromEntity(license.get());
        return ResponseEntity.ok(licenseResource);
    }

    @PutMapping("/{licenseId}")
    @Operation(summary = "Update a license", description = "Update the license with the provided id.")
    public ResponseEntity<LicenseResource> updateLicense(@PathVariable Long licenseId, @RequestBody LicenseResource resource){
        var updateLicenseCommand = UpdateLicenseCommandFromResourceAssembler.toCommandFromResource(licenseId, resource);
        var license = this.licenseCommandService.handle(updateLicenseCommand);
        if(license.isEmpty()) return ResponseEntity.badRequest().build();
        var licenseResource = LicenseResourceFromEntityAssembler.toResourceFromEntity(license.get());
        return ResponseEntity.ok(licenseResource);
    }
}
