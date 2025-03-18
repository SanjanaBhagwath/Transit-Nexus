package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService
{
    AdminRepo repo;

    public AdminRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(AdminRepo repo) {
        this.repo = repo;
    }

    void addAdmin(Admin a)
    {
        repo.save(a);
    }

    List<Admin> getAdmin()
    {
        return repo.findAll();
    }
}
