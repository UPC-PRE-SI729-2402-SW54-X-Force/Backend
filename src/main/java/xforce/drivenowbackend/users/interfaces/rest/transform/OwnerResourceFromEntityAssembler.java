package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.aggregates.Owner;
import xforce.drivenowbackend.users.interfaces.rest.resources.OwnerResource;

public class OwnerResourceFromEntityAssembler {

    public static OwnerResource toResourceFromEntity(Owner entity) {

        return new OwnerResource(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getDni()
        );
    }
}
