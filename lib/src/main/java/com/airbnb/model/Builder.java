package com.airbnb.model;

import static com.airbnb.model.Constants.EXACT_LOCATION;
import static com.airbnb.model.Constants.LOCATION;
import static com.airbnb.utils.DateSelector.getDatePlusDays;


public class Builder {

    public static SearchData buildSearchData() {
        return SearchData.builder()
                .location(LOCATION)
                .exactLocation(EXACT_LOCATION)
                .startDate(getDatePlusDays(7))
                .endDate(getDatePlusDays(14))
                .numberOfAdults(2)
                .numberOfChildren(1)
                .build();
    }
}
