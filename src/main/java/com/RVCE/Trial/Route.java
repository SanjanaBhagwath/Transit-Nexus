package com.RVCE.Trial;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Route
{
    String Route_no;
    String Source;
    String Destination;

    public String getRoute_no() {
        return Route_no;
    }

    public void setRoute_no(String route_no) {
        Route_no = route_no;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }
}
