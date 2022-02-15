package com.airbnb.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DateFormatSymbols;



public class DateSelector {

    /**
     * This methods transforms the month number into short month string (eg. 03 to Mar)
     *
     * @param month eg. 03 to Mar
     * @return string
     */
    public static String getMonth(int month) {
        return new DateFormatSymbols().getShortMonths()[month - 1];
    }

    public static String getDatePlusDays(int offset) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now().plusDays(offset);
        return today.format(FORMATTER);
    }

}
