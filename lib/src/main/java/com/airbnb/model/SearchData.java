package com.airbnb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class SearchData {
    private String location;
    private String exactLocation;
    private String startDate;
    private String endDate;
    private Integer numberOfAdults;
    private Integer numberOfChildren;
}
