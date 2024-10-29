package xforce.drivenowbackend.users.domain.model.commands;

public record CreateOwnerCommand( String name, String email, String dni) {
}
