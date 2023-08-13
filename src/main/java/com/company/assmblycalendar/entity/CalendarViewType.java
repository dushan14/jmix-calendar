package com.company.assmblycalendar.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum CalendarViewType implements EnumClass<String> {

    MONTH("M"),
    WEEK("W"),
    DAY("D");

    private String id;

    CalendarViewType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CalendarViewType fromId(String id) {
        for (CalendarViewType at : CalendarViewType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}