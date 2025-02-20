package com.example.RealEstateAgency.Enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin_delete"),
    SUPER_ADMIN_READ("super_admin:read"),
    SUPER_ADMIN_CREATE("super_admin:create"),
    SUPER_ADMIN_UPDATE("super_admin:update"),
    SUPER_ADMIN_DELETE("super_admin_delete");

    @Getter
    private final String permission;
}
