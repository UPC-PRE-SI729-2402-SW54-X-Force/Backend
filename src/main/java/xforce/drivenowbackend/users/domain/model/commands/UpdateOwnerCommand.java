package xforce.drivenowbackend.users.domain.model.commands;

public record UpdateOwnerCommand(Long id, String name, String email, String dni) {

}
