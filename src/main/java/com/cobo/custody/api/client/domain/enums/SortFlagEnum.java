package com.cobo.custody.api.client.domain.enums;

public enum SortFlagEnum {
    DESCENDING(0, "Descending order"),
    ASCENDING(1, "Ascending order");

    private int flag;
    private String desc;

    SortFlagEnum(int flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public int getFlag() {
        return flag;
    }

    public String getDesc() {
        return desc;
    }

    public static SortFlagEnum of(int value) {

        for (SortFlagEnum flagEnum : SortFlagEnum.values()) {
            if (flagEnum.getFlag() == value) {
                return flagEnum;
            }
        }
        throw new RuntimeException("there is not this value SortFlagEnum");
    }
}
