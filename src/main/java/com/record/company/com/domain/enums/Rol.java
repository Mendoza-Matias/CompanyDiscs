package com.record.company.com.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Rol {
    ADMIN,
    USER;

    private String rol;
}
