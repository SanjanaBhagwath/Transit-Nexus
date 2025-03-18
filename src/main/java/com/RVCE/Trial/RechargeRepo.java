package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RechargeRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    boolean save(Recharge r)
    {
        long rfid = r.RFID_No;
        LocalDate d = r.Recharge_Date;
        Date date = Date.valueOf(d);
        float a = r.Recharge_Amount;


        String query1 = "INSERT INTO Recharge (RFID_No, Recharge_Date, Recharge_Amount) VALUES (?, ?, ?)";
        String query2 = "UPDATE Passenger SET Balance = Balance + ? WHERE RFID_No = ?";

        int rowsUpdated = jdbc.update(query1, rfid, date, a);
        int rowsInserted = jdbc.update(query2, a, rfid);
        return rowsUpdated>0 && rowsInserted>0;
    }

    List<Recharge> findAll()
    {
        String query = "SELECT * FROM Recharge";


        RowMapper<Recharge> mapper = new RowMapper<Recharge>() {
            List<Recharge> list = new ArrayList<Recharge>();

            @Override
            public Recharge mapRow(ResultSet rs, int rowNum) {
                Recharge r = new Recharge(); //Returned data will be stored here;
                try {
                    r.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRecharge_Date(rs.getDate("Recharge_Date").toLocalDate());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRecharge_Amount(rs.getFloat("Recharge_Amount"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                return r;
            }
        };

        return jdbc.query(query, mapper);
    }

    public List<Recharge> findRecharge_RFIDNo(long RFID_No)
    {
        String query = "SELECT * FROM Recharge WHERE RFID_No = ?";


        RowMapper<Recharge> mapper = new RowMapper<Recharge>() {
            List<Recharge> list = new ArrayList<Recharge>();

            @Override
            public Recharge mapRow(ResultSet rs, int rowNum) {
                Recharge r = new Recharge(); //Returned data will be stored here;
                try {
                    r.setId(rs.getInt("id"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRecharge_Date(rs.getDate("Recharge_Date").toLocalDate());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRecharge_Amount(rs.getFloat("Recharge_Amount"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                return r;
            }
        };

        return jdbc.query(query, new Object[]{RFID_No}, mapper);
    }

    public List<Recharge> findRecharge_Date(Date d)
    {
        String query = "SELECT * FROM Recharge WHERE recharge_date = ?";


        RowMapper<Recharge> mapper = new RowMapper<Recharge>() {
            List<Recharge> list = new ArrayList<Recharge>();

            @Override
            public Recharge mapRow(ResultSet rs, int rowNum) {
                Recharge r = new Recharge(); //Returned data will be stored here;
                try {
                    r.setId(rs.getInt("id"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRecharge_Date(rs.getDate("Recharge_Date").toLocalDate());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setRecharge_Amount(rs.getFloat("Recharge_Amount"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                return r;
            }
        };

        return jdbc.query(query, new Object[]{d}, mapper);
    }
}
