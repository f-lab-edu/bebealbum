package io.bebealbum.app.api.v1.request;

public record UserLoginRequest(
        String loginId
        , String password
) {
}
