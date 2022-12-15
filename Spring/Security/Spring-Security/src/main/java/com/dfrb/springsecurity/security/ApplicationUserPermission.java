package com.dfrb.springsecurity.security;

public enum ApplicationUserPermission {
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
