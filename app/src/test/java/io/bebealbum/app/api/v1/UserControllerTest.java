package io.bebealbum.app.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bebealbum.app.api.support.error.ErrorType;
import io.bebealbum.app.api.support.response.ApiResponse;
import io.bebealbum.app.api.v1.request.UserRegistrationRequest;
import io.bebealbum.app.api.v1.response.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Nested
    @DisplayName("회원 추가")
    class UserRegistrationTest {
        @Nested
        @DisplayName("성공")
        class Success {
            @Test
            @DisplayName("회원 생성 요청은 생성된 회원을 반환한다.")
            public void createUser_ShouldReturnCreatedUser() throws Exception {
                // given
                UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("testUser", "testLoginId", "password");
                var userResponse = new UserResponse(1L, userRegistrationRequest.userName(), userRegistrationRequest.loginId());
                var expectedResponse = ApiResponse.success(userResponse);

                // when & then
                mockMvc.perform(post("/api/users")
                                .content(objectMapper.writeValueAsString(userRegistrationRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)))
                        .andDo(print());
            }
        }

        @Nested
        @DisplayName("실패")
        class Failure {
            @Test
            @DisplayName("중복된 회원 생성 요청은 실패한 응답을 반환한다.")
            public void createUser_DuplicateUser_ShouldReturnErrorResponse() throws Exception {
                // given
                UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("duplicateUser", "duplicateLoginId", "password");
                var expectedResponse = ApiResponse.error(ErrorType.USER_DUPLICATION_ERROR);

                // when & then
                mockMvc.perform(post("/api/users")
                                .content(objectMapper.writeValueAsString(userRegistrationRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)))
                        .andDo(print());
            }
        }


    }
}
