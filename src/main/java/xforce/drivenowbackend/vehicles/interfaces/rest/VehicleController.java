package xforce.drivenowbackend.vehicles.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xforce.drivenowbackend.vehicles.domain.model.commands.DeleteVehicleCommand;
import xforce.drivenowbackend.vehicles.domain.model.queries.GetAllVehiclesQuery;
import xforce.drivenowbackend.vehicles.domain.model.queries.GetVehicleByIdQuery;
import xforce.drivenowbackend.vehicles.domain.services.VehicleCommandService;
import xforce.drivenowbackend.vehicles.domain.services.VehicleQueryService;
import xforce.drivenowbackend.vehicles.interfaces.rest.resources.CreateVehicleResource;
import xforce.drivenowbackend.vehicles.interfaces.rest.resources.VehicleResource;
import xforce.drivenowbackend.vehicles.interfaces.rest.transform.CreateVehicleCommandFromResourceAssembler;
import xforce.drivenowbackend.vehicles.interfaces.rest.transform.UpdateVehicleCommandFromResourceAssembler;
import xforce.drivenowbackend.vehicles.interfaces.rest.transform.VehicleResourceFromEntityAssembler;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Vehicles", description = "Vehicle Management Endpoints")
public class VehicleController {

    private final VehicleQueryService vehicleQueryService;
    private final VehicleCommandService vehicleCommandService;

    public VehicleController(VehicleQueryService vehicleQueryService, VehicleCommandService vehicleCommandService) {
        this.vehicleQueryService = vehicleQueryService;
        this.vehicleCommandService = vehicleCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new vehicle", description = "Creates a new vehicle with the provided details.")
    public ResponseEntity<VehicleResource> createVehicle(@RequestBody CreateVehicleResource resource) {
        var createVehicleCommand = CreateVehicleCommandFromResourceAssembler.toCommandFromResource(resource);
        var vehicle = this.vehicleCommandService.handle(createVehicleCommand);

        if (vehicle.isEmpty()) return ResponseEntity.badRequest().build();

        var vehicleResource = VehicleResourceFromEntityAssembler.toResourceFromEntity(vehicle.get());
        return new ResponseEntity<>(vehicleResource, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all vehicles", description = "Returns a list of all vehicles.")
    public ResponseEntity<List<VehicleResource>> getAllVehicles() {
        var getAllVehiclesQuery = new GetAllVehiclesQuery();
        var vehicles = this.vehicleQueryService.handle(getAllVehiclesQuery);
        var vehicleResources = vehicles.stream().map(VehicleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(vehicleResources);
    }

    @GetMapping("/{vehicleId}")
    @Operation(summary = "Get vehicle by id", description = "Returns the vehicle with the provided id.")
    public ResponseEntity<VehicleResource> getVehicleById(@PathVariable Long vehicleId) {
        var getVehicleByIdQuery = new GetVehicleByIdQuery(vehicleId);
        var vehicle = this.vehicleQueryService.handle(getVehicleByIdQuery);
        if (vehicle.isEmpty()) return ResponseEntity.badRequest().build();
        var vehicleResource = VehicleResourceFromEntityAssembler.toResourceFromEntity(vehicle.get());
        return ResponseEntity.ok(vehicleResource);
    }

    @PutMapping("/{vehicleId}")
    @Operation(summary = "Update vehicle", description = "Update the vehicle with the provided id.")
    public ResponseEntity<VehicleResource> updateVehicle(@PathVariable Long vehicleId, @RequestBody VehicleResource resource) {
        var updateVehicleCommand = UpdateVehicleCommandFromResourceAssembler.toCommandFromResource(vehicleId, resource);
        var vehicle = this.vehicleCommandService.handle(updateVehicleCommand);
        if (vehicle.isEmpty()) return ResponseEntity.badRequest().build();
        var vehicleResource = VehicleResourceFromEntityAssembler.toResourceFromEntity(vehicle.get());
        return ResponseEntity.ok(vehicleResource);
    }

    @DeleteMapping("/{vehicleId}")
    @Operation(summary = "Delete vehicle", description = "Delete the vehicle with the provided id.")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long vehicleId) {
        var deleteVehicleCommand = new DeleteVehicleCommand(vehicleId);
        this.vehicleCommandService.handle(deleteVehicleCommand);
        return ResponseEntity.noContent().build();
    }

}
