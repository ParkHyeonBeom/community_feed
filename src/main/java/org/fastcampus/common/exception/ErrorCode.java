package org.fastcampus.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    InvalidInputValue(400, "Invalid Input Value"),
    NotFound(404, "Not Found"),
    InternalServerError(500, "Server Error");


    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
