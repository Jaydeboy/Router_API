package com.router.ssa_Office.HearingOffices;


public class Hearing_Office {

    private final String hearing_Office_Name;
    private final int ho_Code;
    private final int region;
    private final double average_Processing_Time;



    public Hearing_Office(String hearing_Office_Name,  int ho_Code, int region,
                                double average_processing_time) {

        this.hearing_Office_Name = hearing_Office_Name;
        this.ho_Code = ho_Code;
        this.region = region;
        this.average_Processing_Time = average_processing_time;
    }

    public String getHearing_Office_Name() {
        return hearing_Office_Name;
    }

    public int getHo_Code() {
        return ho_Code;
    }

    public int getRegion() {
        return region;
    }

    public double getAverage_Processing_Time() {
        return average_Processing_Time;
    }



    @Override
    public String toString() {
        return "Hearing_Office{" +
                "hearing_Office_Name='" + hearing_Office_Name + '\'' +
                ", ho_Code=" + ho_Code +
                ", region=" + region +
                ", Average_Processing_Time=" + average_Processing_Time +
                '}';
    }
}
