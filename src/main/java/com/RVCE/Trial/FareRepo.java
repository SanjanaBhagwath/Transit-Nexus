package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FareRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    void save(Fare f)
    {
        String r = f.Route_No;
        String s1 = f.Station_1;
        String s2 = f.Station_2;
        float fare = f.fare;
        String query = "INSERT INTO Fares VALUES(?, ?, ?, ?)";

        jdbc.update(query, fare, s1, s2, r);
    }

    List<Fare> findAll()
    {
        String query = "SELECT * FROM Fares";


        RowMapper<Fare> mapper = new RowMapper<Fare>() {
            List<Fare> list = new ArrayList<Fare>();

            @Override
            public Fare mapRow(ResultSet rs, int rowNum) {
                Fare f = new Fare(); //Returned data will be stored here;
                try {
                    f.setRoute_No(rs.getString("Route_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    f.setStation_1(rs.getString("Station 1"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    f.setStation_2(rs.getString("Station 2"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    f.setFare(rs.getFloat("Fare"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                return f;
            }
        };

        return jdbc.query(query, mapper);
    }
}
