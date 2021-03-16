package com.company.OOP.example8;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScreenerData {
 private boolean visitingCampus;
 private double tempF;
 private boolean hasSymptoms;

    public ScreenerData(boolean visitingCampus, double tempF, boolean hasSymptoms) {
        this.visitingCampus = visitingCampus;
        this.tempF = tempF;
        this.hasSymptoms = hasSymptoms;
    }

    public boolean isVisitingCampus() {
        return visitingCampus;
    }

    public void setVisitingCampus(boolean visitingCampus) {
        this.visitingCampus = visitingCampus;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public boolean isHasSymptoms() {
        return hasSymptoms;
    }

    public void setHasSymptoms(boolean hasSymptoms) {
        this.hasSymptoms = hasSymptoms;
    }

    @Override
    public String toString() {
        return "ScreenerData{" +
                "visitingCampus=" + visitingCampus +
                ", tempF=" + tempF +
                ", hasSymptoms=" + hasSymptoms +
                '}';
    }

    public static void main(String[] args) {
        ScreenerData data = new ScreenerData(true,80.0,false);
        ScreenerData data2 = new ScreenerData(false,105,false);
        ScreenerData data3 = new ScreenerData(true,80.0,true);
        List<ScreenerData> dataVariables = Arrays.asList(data,data2,data3);
        dataVariables.stream()
                .filter((condition) -> (condition.visitingCampus && condition.tempF > 100.4) || !condition.hasSymptoms)
                .collect(Collectors.toList())
                .forEach(a -> System.out.println(a.getTempF() + " "+ a.hasSymptoms+ " " + a.visitingCampus + " is valid."));
    }
}
