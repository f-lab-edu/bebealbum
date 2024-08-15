package io.bebealbum.app.api.v1.request;

public record UserRegistrationRequest(
        String userName
        , String loginId
        , String password
) {
}
