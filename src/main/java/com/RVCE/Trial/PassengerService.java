package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService
{
    PassengerRepo repo;

    public PassengerRepo getRepo()
    {
        return repo;
    }

    @Autowired
    public void setRepo(PassengerRepo repo)
    {
        this.repo = repo;
    }

    public void addPassenger(Passenger p)
    {
        repo.save(p);
    }

    Float getBalance(long rfid)
    {
        return repo.findBalance(rfid);
    }

    List<Passenger> getPassenger()
    {
        return repo.findAll();
    }

    public boolean isValidRFID(long rfid)
    {
        return repo.existsRFID(rfid);
    }
}
