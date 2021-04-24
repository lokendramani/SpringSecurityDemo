package com.example.demo.config;

public enum ApplicationUserPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:read"),
    COURSE_READ("student:read"),
    COURSE_WRITE("student:read");

    public String getPermission() {
        return permission;
    }

    private final String permission;

    ApplicationUserPermissions(String permission) {
        this.permission = permission;
    }
}
