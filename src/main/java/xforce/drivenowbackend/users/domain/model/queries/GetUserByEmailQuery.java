package xforce.drivenowbackend.users.domain.model.queries;

import xforce.drivenowbackend.users.domain.model.valueobjects.EmailAddress;

public record GetUserByEmailQuery(EmailAddress emailAddress) {
}
