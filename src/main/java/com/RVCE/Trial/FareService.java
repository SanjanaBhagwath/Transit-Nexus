package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FareService
{
    FareRepo repo;

    public FareRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(FareRepo repo) {
        this.repo = repo;
    }

    void addFare(Fare f)
    {
        repo.save(f);
    }

    List<Fare> getFare()
    {
        return repo.findAll();
    }
}
