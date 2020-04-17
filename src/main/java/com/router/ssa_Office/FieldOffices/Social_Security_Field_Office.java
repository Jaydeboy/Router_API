package com.router.ssa_Office.FieldOffices;

import java.sql.Time;

public class Social_Security_Field_Office {

    private final int averge_Processing_time;
    private final String ssaOffice;
    private final int region;
    private final Time date;




    public Social_Security_Field_Office(int averge_processing_time, String ssaOffice, int region, Time date) {
        averge_Processing_time = averge_processing_time;
        this.ssaOffice = ssaOffice;
        this.region = region;
        this.date = date;
    }

    public int getAverge_Processing_time() {
        return averge_Processing_time;
    }

    public String getSsaOffice() {
        return ssaOffice;
    }

    public int getRegion() {
        return region;
    }

    public Time getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Social_Security_Field_Office{" +
                "averge_Processing_time=" + averge_Processing_time +
                ", ssaOffice='" + ssaOffice + '\'' +
                ", region=" + region +
                ", date=" + date +
                '}';
    }
}
