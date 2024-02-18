package com.record.company.com.domain.dto.exception;

import lombok.Getter;

@Getter
public class ExceptionDto extends RuntimeException {
    public ExceptionDto(String message) {
        super(message);
    }
}
