package com.RVCE.Trial;

public class Ticket
{
    int Ticket_No;
    String timestamp;
    String date;
    String StartStop;
    String EndStop;
    long RFID_No;
    String Route_No;
    float fare;

    public int getTicket_No() {
        return Ticket_No;
    }

    public void setTicket_No(int ticket_No) {
        Ticket_No = ticket_No;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartStop() {
        return StartStop;
    }

    public void setStartStop(String startStop) {
        StartStop = startStop;
    }

    public String getEndStop() {
        return EndStop;
    }

    public void setEndStop(String endStop) {
        EndStop = endStop;
    }

    public long getRFID_No() {
        return RFID_No;
    }

    public void setRFID_No(long RFID_No) {
        this.RFID_No = RFID_No;
    }

    public String getRoute_No() {
        return Route_No;
    }

    public void setRoute_No(String route_No) {
        Route_No = route_No;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

}
