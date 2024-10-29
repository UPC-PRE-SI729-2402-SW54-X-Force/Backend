package xforce.drivenowbackend.users.domain.model.aggregates;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import xforce.drivenowbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

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



}
