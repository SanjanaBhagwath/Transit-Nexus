package com.RVCE.Trial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc()
    {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Passenger p)
    {
        String query = "INSERT INTO Passenger VALUES(?, ?)";
        long rfid = p.RFID_No;
        float bal = p.Balance;
        jdbc.update(query, rfid, bal);
    }


    public List<Passenger> findAll()
    {
        String query = "SELECT * FROM Passenger";


        RowMapper<Passenger> mapper = new RowMapper<Passenger>()
        {
            @Override
            public Passenger mapRow(ResultSet rs, int rowNum) {
                Passenger p = new Passenger(); //Returned data will be stored here;
                try {
                    p.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    p.setBalance(rs.getFloat("Balance"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                return p;
            }
        };

        return jdbc.query(query, mapper);
    }

    public Float findBalance(long rfid) {
        String query = "SELECT Balance FROM Passenger WHERE RFID_No = ?";

        try {
            // Use queryForObject to retrieve the balance
            return jdbc.queryForObject(query, new Object[]{rfid}, Float.class);
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no result is found
            return null; // Return null if the RFID is not found
        }
    }

    public boolean existsRFID(long rfid) {
        String query = "SELECT COUNT(*) FROM Passenger WHERE RFID_No = ?";
        int count = jdbc.queryForObject(query, Integer.class, rfid);
        return count > 0;
    }
}
