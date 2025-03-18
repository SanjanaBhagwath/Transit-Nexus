package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutesHaveStationsService
{
    RoutesHaveStationsRepo repo;

    public RoutesHaveStationsRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(RoutesHaveStationsRepo repo) {
        this.repo = repo;
    }

    void addRouteStation(RoutesHaveStations rs)
    {
        repo.save(rs);
    }

    List<RoutesHaveStations> getRoutesStations() {
        return repo.findAll();
    }
}
