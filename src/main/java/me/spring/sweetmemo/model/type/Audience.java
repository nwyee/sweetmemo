package me.spring.sweetmemo.model.type;

public enum Audience {

    PUBLIC("Public"),
    FIRENDS("Friends"),
    ONLYME("Only me");

    private final String label;

    Audience(String label) {
        this.label = label;
    }
}
