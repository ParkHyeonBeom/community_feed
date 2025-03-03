package org.fastcampus.common.ui;

import org.fastcampus.common.exception.ErrorCode;

public record Response<T>(Integer code, String message, T value) {
    public static <T> Response<T> ok(T value) {
        return new Response<>(200, "OK", value);
    }

    public static <T> Response<T> error(ErrorCode error) {
        return new Response<>(error.getCode(), error.getMessage(), null);
    }
}
