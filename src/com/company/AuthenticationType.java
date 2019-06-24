package com.company;

public enum AuthenticationType {
    TYPE_ONE(1L),
    TYPE_TWO(2L),
    TYPE_THREE(3L),
    TYPE_FOUR(4L),
    TYPE_FIVE(6789L),
    TYPE_SIX(-89875L);

    private final Long value;

    AuthenticationType(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}