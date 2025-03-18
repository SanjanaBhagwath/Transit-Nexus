package com.RVCE.Trial;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Passenger
{
   long  RFID_No;
   float Balance;

    public long getRFID_No() {
        return RFID_No;
    }

    public void setRFID_No(long RFID_No) {
        this.RFID_No = RFID_No;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float balance) {
        Balance = balance;
    }
}
