package com.sid.app.sistema_informacion_digital.Entity.Enumerable;

public enum StateGift {
    DISPONIBLE("DISPONIBLE"),

    NO_DISPONIBLE("NO DISPONIBLE");

    private String state;

    StateGift(String disponible) {
        state = disponible;
    }

    public String getState() {
        return state;
    }
}
