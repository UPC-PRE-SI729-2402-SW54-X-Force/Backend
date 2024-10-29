package xforce.drivenowbackend.users.domain.model.aggregates;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import xforce.drivenowbackend.users.domain.model.commands.CreateDriverCommand;
import xforce.drivenowbackend.users.domain.model.commands.CreateOwnerCommand;

@Entity
@Getter
@Setter
public class Owner extends AuditableAbstractAggregateRoot<Owner> {

    String name;
    String email;
    String dni;

    public Owner(){
    }

    public Owner(String name, String email, String dni) {
        this.name = name;
        this.email = email;
        this.dni = dni;
    }

    public Owner(CreateOwnerCommand command) {
        this.name = command.name();
        this.email = command.email();
        this.dni = command.dni();
    }
}
