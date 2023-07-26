package com.ecommercewebsite.handler;

import lombok.Getter;

@Getter
public enum ErrorCode {
    RESOURCE_NOT_FOUND(1000),
    RESOURCE_NOT_VALID(1001),
    INVALID_REQUEST(1002),
    SERVER_ERROR(1003);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

}
