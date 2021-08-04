package com.company.dbhelper;

public enum User {
    USERNAME("root"),
    PASSWORD("Zly259il1zhanna1");

    private final String value;

    User(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
