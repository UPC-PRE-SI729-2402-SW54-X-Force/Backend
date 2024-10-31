package xforce.drivenowbackend.users.interfaces.rest;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xforce.drivenowbackend.users.domain.model.commands.DeleteUserCommand;
import xforce.drivenowbackend.users.domain.model.queries.GetAllUsersQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetUserByIdQuery;
import xforce.drivenowbackend.users.domain.services.UserCommandService;
import xforce.drivenowbackend.users.domain.services.UserQueryService;
import xforce.drivenowbackend.users.interfaces.rest.resources.CreateUserResource;
import xforce.drivenowbackend.users.interfaces.rest.resources.UserResource;
import xforce.drivenowbackend.users.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import xforce.drivenowbackend.users.interfaces.rest.transform.UpdateUserCommandFromResourceAssembler;
import xforce.drivenowbackend.users.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "User Management Endpoints")
public class UserController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Creates a new user with the provided details.")
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource){
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var user = this.userCommandService.handle(createUserCommand);

        if(user.isEmpty()) return ResponseEntity.badRequest().build();

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());

        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all users", description = "Returns a list of all users.")
    public ResponseEntity<List<UserResource>> getAllUsers(){
        var getAllusersQuery = new GetAllUsersQuery();
        var users = this.userQueryService.handle(getAllusersQuery);
        var userResources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResources);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get user by id", description = "Returns the user with the provided id.")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long userId){
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = this.userQueryService.handle(getUserByIdQuery);
        if(user.isEmpty()) return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Update user", description = "Updates the user with the provided id.")
    public ResponseEntity<UserResource> updateUser(@PathVariable Long userId, @RequestBody UserResource resource){
        var updateUserCommand = UpdateUserCommandFromResourceAssembler.toCommandFromResource(userId, resource);
        var user = this.userCommandService.handle(updateUserCommand);
        if(user.isEmpty()) return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete user", description = "Deletes a user with the provided id.")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        var deleteUserCommand = new DeleteUserCommand(userId);
        this.userCommandService.handle(deleteUserCommand);
        return ResponseEntity.noContent().build();
    }
}
