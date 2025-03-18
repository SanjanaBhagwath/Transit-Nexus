package com.RVCE.Trial;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Recharge
{
    long id;
    long RFID_No;
    float Recharge_Amount;
    LocalDate Recharge_Date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public long getRFID_No() {
        return RFID_No;
    }

    public void setRFID_No(long RFID_No) {
        this.RFID_No = RFID_No;
    }

    public LocalDate getRecharge_Date() {
        return Recharge_Date;
    }

    public void setRecharge_Date(LocalDate rechargeDate) {
        this.Recharge_Date = rechargeDate;
    }

    public float getRecharge_Amount() {
        return Recharge_Amount;
    }

    public void setRecharge_Amount(float recharge_Amount) {
        Recharge_Amount = recharge_Amount;
    }
}
