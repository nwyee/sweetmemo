package me.data.sweet.model.type;

import java.util.HashMap;
import java.util.Map;

public enum Duration {
    FIFTEENMIN("15 minutes", 15),
    HALFHOUR("30 minutes", 30),
    ONEHOUR("1 hour", 60),
    TWOHOUR("2 hours",120),
    ETERNITY("Eternity", 180);

    private final Integer minutes;
    private final String label;

    private static final Map<String, Duration> BY_LABEL = new HashMap<>();
    private static final Map<Integer, Duration> BY_MINUTES = new HashMap<>();

    private Duration(String label, Integer minutes) {
        this.minutes = minutes;
        this.label = label;
    }

    public static Duration valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}
