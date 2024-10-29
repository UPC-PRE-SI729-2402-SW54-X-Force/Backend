package xforce.drivenowbackend.users.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xforce.drivenowbackend.users.domain.model.queries.GetOwnerByIdQuery;
import xforce.drivenowbackend.users.domain.services.OwnerCommandService;
import xforce.drivenowbackend.users.domain.services.OwnerQueryService;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateOwnerResource;
import xforce.drivenowbackend.users.interfaces.rest.resources.OwnerResource;
import xforce.drivenowbackend.users.interfaces.rest.transform.CreateOwnerCommandFromResourceAssembler;
import xforce.drivenowbackend.users.interfaces.rest.transform.OwnerResourceFromEntityAssembler;

@RestController
@RequestMapping(value="/api/v1/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Owner", description = "Owner Management Endpoints")
public class OwnerController {

    private final OwnerQueryService ownerQueryService;
    private final OwnerCommandService ownerCommandService;

    public OwnerController(OwnerQueryService ownerQueryService, OwnerCommandService ownerCommandService) {
        this.ownerQueryService = ownerQueryService;
        this.ownerCommandService = ownerCommandService;
    }

    @PostMapping
    public ResponseEntity<OwnerResource> createOwner(@RequestBody CreateOwnerResource resource) {
        var createOwnerCommand = CreateOwnerCommandFromResourceAssembler.toCommandFromResource(resource);
        var owner = ownerCommandService.handle(createOwnerCommand);
        if(owner.isEmpty()) return ResponseEntity.badRequest().build();
        var ownerResource = OwnerResourceFromEntityAssembler.toResourceFromEntity(owner.get());
        return new ResponseEntity<>(ownerResource, HttpStatus.CREATED);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerResource> getOwnerById(@PathVariable String ownerId) {
        var getProfileByIdQuery = new GetOwnerByIdQuery(ownerId);
        var owner = ownerQueryService.handle(getProfileByIdQuery);
        if(owner.isEmpty()) return ResponseEntity.badRequest().build();
        var ownerResource = OwnerResourceFromEntityAssembler.toResourceFromEntity(owner.get());
        return ResponseEntity.ok(ownerResource);
    }

}
