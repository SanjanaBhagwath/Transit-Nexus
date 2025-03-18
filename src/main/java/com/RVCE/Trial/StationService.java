package com.RVCE.Trial;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService
{
    StationRepo repo;

    public StationRepo getRepo() {
        return repo;
    }

    public void setRepo(StationRepo repo) {
        this.repo = repo;
    }

    void addStation(Station s)
    {
        repo.save(s);
    }

    List<Station> getStation()
    {
        return repo.findAll();
    }

}
