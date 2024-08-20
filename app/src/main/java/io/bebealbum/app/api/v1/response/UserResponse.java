package io.bebealbum.app.api.v1.response;

public record UserResponse(
        long id
        , String userName
        , String loginId) {
}
