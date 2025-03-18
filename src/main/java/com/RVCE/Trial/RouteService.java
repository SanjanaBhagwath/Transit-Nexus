package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService
{
    RouteRepo repo;

    public RouteRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(RouteRepo repo) {
        this.repo = repo;
    }

    public void addRoute(Route r)
    {
        repo.save(r);
    }

    List<Route> getRoute()
    {
        return repo.findAll();
    }

    public boolean isValidRoute(String routeNo) {
        return repo.existsByRouteNo(routeNo);
    }
}
