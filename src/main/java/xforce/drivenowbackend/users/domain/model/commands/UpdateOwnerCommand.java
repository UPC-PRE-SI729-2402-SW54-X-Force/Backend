package xforce.drivenowbackend.users.domain.model.commands;

public record UpdateOwnerCommand(String id, String name, String email, String dni) {
}
