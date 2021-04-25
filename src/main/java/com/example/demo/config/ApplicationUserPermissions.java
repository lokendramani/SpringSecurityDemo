package com.example.demo.config;

public enum ApplicationUserPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    public String getPermission() {
        return permission;
    }

    private final String permission;

    ApplicationUserPermissions(String permission) {
        this.permission = permission;
    }
}
