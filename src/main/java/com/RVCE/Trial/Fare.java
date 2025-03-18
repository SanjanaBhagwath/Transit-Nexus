package com.RVCE.Trial;

import org.springframework.stereotype.Component;

@Component
public class Fare
{
    String Route_No;
    String Station_1;
    String Station_2;
    float fare;

    public String getRoute_No() {
        return Route_No;
    }

    public void setRoute_No(String Route_no) {
        Route_No = Route_no;
    }

    public String getStation_1() {
        return Station_1;
    }

    public void setStation_1(String station_1) {
        Station_1 = station_1;
    }

    public String getStation_2() {
        return Station_2;
    }

    public void setStation_2(String station_2) {
        Station_2 = station_2;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
}
