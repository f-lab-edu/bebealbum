package io.bebealbum.app.api.user.controller.v1.response;

import java.time.LocalDateTime;

public record UserResponse(
        long id
        , String userName
        , String loginId
        , LocalDateTime createdAt
        , LocalDateTime updatedAt
        ) {
}
