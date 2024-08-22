package io.bebealbum.app.api.user.controller.v1.request;

public record UserRegistrationRequest(
        String userName
        , String loginId
        , String password
) {
}
