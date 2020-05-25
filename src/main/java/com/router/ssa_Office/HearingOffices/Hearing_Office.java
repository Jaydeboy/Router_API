package com.router.ssa_Office.HearingOffices;

import java.util.ArrayList;
import java.util.List;


public class Hearing_Office {

    private final int ho_Code;
    private final String hearingOfficeName;
    private final int region;
    private List<AverageProcessingTime> processingTime =  new ArrayList<>();


    public Hearing_Office(String hearing_Office_Name,  int ho_Code, int region) {

        this.hearingOfficeName = hearing_Office_Name;
        this.ho_Code = ho_Code;
        this.region = region;


    }
    public String getHearingOfficeName() {
        return hearingOfficeName;
    }

    public int getHo_Code() {
        return ho_Code;
    }
    public int getRegion() {
        return region;
    }
    public void addProcessingTime(AverageProcessingTime  processingTime){
        this.processingTime.add(processingTime);
    }
    public ArrayList getProcessingTimeList(){
        return new ArrayList<>(processingTime);
    }
    private class AverageProcessingTime{

        private final double average_Processing_Time;

        public AverageProcessingTime(double Processing_Time){

            average_Processing_Time = Processing_Time;
        }

    }

}
