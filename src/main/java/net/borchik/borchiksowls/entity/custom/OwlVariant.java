package net.borchik.borchiksowls.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum OwlVariant {
    BROWN(1),
    SNOWY(2);


    private static final OwlVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(OwlVariant::getId)).toArray(OwlVariant[]::new);

    private final int id;

    OwlVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static OwlVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
