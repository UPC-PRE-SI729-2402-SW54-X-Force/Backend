package xforce.drivenowbackend.users.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xforce.drivenowbackend.users.domain.model.queries.GetDriverByIdQuery;
import xforce.drivenowbackend.users.domain.services.DriverCommandService;
import xforce.drivenowbackend.users.domain.services.DriverQueryService;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateDriverResource;
import xforce.drivenowbackend.users.interfaces.rest.resources.DriverResource;
import xforce.drivenowbackend.users.interfaces.rest.transform.CreateDriverCommandFromResourceAssembler;
import xforce.drivenowbackend.users.interfaces.rest.transform.DriverResourceFromEntityAssembler;

import java.awt.*;

@RestController
@RequestMapping(value = "/api/v1/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "drivers", description = "Driver Management Endpoints")
public class DriverController {
    private final DriverQueryService driverQueryService;
    private final DriverCommandService driverCommandService;

    public DriverController(DriverQueryService driverQueryService, DriverCommandService driverCommandService) {
        this.driverQueryService = driverQueryService;
        this.driverCommandService = driverCommandService;
    }

    @PostMapping
    public ResponseEntity<DriverResource> createDriver(@RequestBody CreateDriverResource resource) {
        var createDriverCommand = CreateDriverCommandFromResourceAssembler.toCommandFromResource(resource);
        var driver = driverCommandService.handle(createDriverCommand);
        if(driver.isEmpty()) return ResponseEntity.badRequest().build();
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return new ResponseEntity<>(driverResource, HttpStatus.CREATED);
    }
    @GetMapping("/{driverId}")
    public ResponseEntity<DriverResource> getDriverById(@PathVariable String driverId) {
        var getProfileByIdQuery = new GetDriverByIdQuery(driverId);
        var driver = driverQueryService.handle(getProfileByIdQuery);
        if(driver.isEmpty()) return ResponseEntity.badRequest().build();
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return ResponseEntity.ok(driverResource);
    }
}
