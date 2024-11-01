package xforce.drivenowbackend.users.interfaces.rest.transform;

import xforce.drivenowbackend.users.domain.model.aggregates.User;
import xforce.drivenowbackend.users.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        return new UserResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge(),
                entity.getEmailAddress(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getCity(),
                entity.getPostalCode(),
                entity.getCountry()
        );
    }
}
