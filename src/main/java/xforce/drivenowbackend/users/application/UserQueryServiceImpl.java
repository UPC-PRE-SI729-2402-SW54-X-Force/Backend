package xforce.drivenowbackend.users.application;

import org.springframework.stereotype.Service;
import xforce.drivenowbackend.users.domain.model.aggregates.User;
import xforce.drivenowbackend.users.domain.model.queries.GetAllUsersQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetUserByEmailQuery;
import xforce.drivenowbackend.users.domain.model.queries.GetUserByIdQuery;
import xforce.drivenowbackend.users.domain.services.UserQueryService;
import xforce.drivenowbackend.users.infrastucture.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return this.userRepository.findById(query.userId());
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return this.userRepository.findByEmail(query.emailAddress());
    }
}
