package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RechargeService
{
    RechargeRepo repo;

    public RechargeRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(RechargeRepo repo) {
        this.repo = repo;
    }

    boolean addRecharge(Recharge r)
    {
        try {
            repo.save(r); // Save the recharge record
            return true; // Return true if save is successful
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception (consider using a logger)
            return false; // Return false if any exception occurs
        }
    }

    List<Recharge> getRecharge()
    {
        return repo.findAll();
    }

    List<Recharge> getRecharge_RFIDNo(long RFID_No)
    {
        return repo.findRecharge_RFIDNo(RFID_No);
    }

    List<Recharge> getRecharge_Date(Date d)
    {
        return repo.findRecharge_Date(d);
    }



}
