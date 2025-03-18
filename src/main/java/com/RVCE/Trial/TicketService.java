package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TicketService
{
    TicketRepo repo;

    public TicketRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(TicketRepo repo) {
        this.repo = repo;
    }

    void addTicket(Ticket t)
    {
        repo.save(t);
    }

    List<Ticket> getTicket()
    {
        return repo.findAll();
    }

    List<Ticket> getTicket_Date(Date d)
    {
        return repo.findTicket_Date(d);
    }

    List<Ticket> getTicket_RouteNo(String Route_No)
    {
        return repo.findTicket_RouteNo(Route_No);
    }

    List<Ticket> getTicket_RFIDNo(long RFID_No)
    {
        return repo.findTicket_RFIDNo(RFID_No);
    }

}
