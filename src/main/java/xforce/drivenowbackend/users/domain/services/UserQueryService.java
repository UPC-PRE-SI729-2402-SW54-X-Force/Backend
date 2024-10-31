package xforce.drivenowbackend.users.domain.services;

import xforce.drivenowbackend.users.domain.model.aggregates.User;
import xforce.drivenowbackend.users.domain.model.queries.GetAllUsersQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
