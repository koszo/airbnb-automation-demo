package com.airbnb.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Facilities {

    @Getter
    @AllArgsConstructor
    public enum FacilityType {
        GUESTS_NUMBER(0),
        BEDROOMS_NUMBER(1);
        int value;
    }
}
