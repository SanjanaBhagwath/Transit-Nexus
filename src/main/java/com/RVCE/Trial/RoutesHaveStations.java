package com.RVCE.Trial;

import org.springframework.stereotype.Component;

@Component
public class RoutesHaveStations
{
    String route_no;
    String station_name;
    int station_order;

    public String getRoute_no() {
        return route_no;
    }

    public void setRoute_no(String route_no) {
        this.route_no = route_no;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public int getStation_order() {
        return station_order;
    }

    public void setStation_order(int station_order) {
        this.station_order = station_order;
    }
}
