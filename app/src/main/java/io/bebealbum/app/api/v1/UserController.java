package io.bebealbum.app.api.v1;

import io.bebealbum.app.api.support.response.ApiResponse;
import io.bebealbum.app.api.v1.request.UserLoginRequest;
import io.bebealbum.app.api.v1.request.UserRegistrationRequest;
import io.bebealbum.app.api.v1.request.UserUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ApiResponse<HttpStatus> createUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        // 사용자 생성 로직
        return ApiResponse.success(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ApiResponse<HttpStatus> getUser(@PathVariable Long userId) {
        // 사용자 조회 로직
        return ApiResponse.success(HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ApiResponse<HttpStatus> updateUser(@PathVariable Long userId
            , @RequestBody UserUpdateRequest userUpdateRequest) {
        // 사용자 수정 로직
        return ApiResponse.success(HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<HttpStatus> deleteUser(@PathVariable Long userId) {
        // 사용자 삭제 로직
        return ApiResponse.success(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ApiResponse<HttpStatus> login(@RequestBody UserLoginRequest userLoginRequest) {
        // 로그인 로직
        return ApiResponse.success(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ApiResponse<HttpStatus> logout() {
        // 로그아웃 로직
        return ApiResponse.success(HttpStatus.OK);
    }
}
