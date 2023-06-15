package com.thiagoferraz.mychess.model.enums;

public enum Role {
    USER(1, "User"),
    ADMIN(2, "Admin");

    private final Integer id;
    private final String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role toEnum(Integer id) {
        for (Role role : Role.values()) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
