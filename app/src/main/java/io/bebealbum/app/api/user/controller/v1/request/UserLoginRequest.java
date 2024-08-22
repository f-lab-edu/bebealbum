package io.bebealbum.app.api.user.controller.v1.request;

public record UserLoginRequest(
        String loginId
        , String password
) {
}
