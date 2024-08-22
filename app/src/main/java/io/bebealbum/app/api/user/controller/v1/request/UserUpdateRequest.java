package io.bebealbum.app.api.user.controller.v1.request;

public record UserUpdateRequest(
        long userId
        , String userName
        , String password
) {
}
