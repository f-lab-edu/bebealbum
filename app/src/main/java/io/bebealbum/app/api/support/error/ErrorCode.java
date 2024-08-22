package io.bebealbum.app.api.support.error;

public enum ErrorCode {
    USER_DUPLICATION_ERROR(422, "이미 존재하는 아이디입니다.")
    , REQUEST_ERROR(900, "잘못된 요청입니다. 요청 값을 확인해주세요.")
    , UNKNOWN_ERROR(555, "알 수 없는 에러입니다.");
    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
