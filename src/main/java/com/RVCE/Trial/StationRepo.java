package com.RVCE.Trial;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StationRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    void save(Station s)
    {
        int n = s.Station_No;
        String name = s.Station_Name;

        String query = "INSERT INTO Stations VALUES(?, ?)";
        jdbc.update(query, n, name);
    }

    public List<Station> findAll()
    {
        String query = "SELECT * FROM Stations";


        RowMapper<Station> mapper = new RowMapper<Station>() {
            List<Station> list = new ArrayList<Station>();

            @Override
            public Station mapRow(ResultSet rs, int rowNum) {
                Station s = new Station(); //Returned data will be stored here;
                try {
                    s.setStation_No(rs.getInt("Station_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    s.setStation_Name(rs.getString("Station_Name"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                return s;
            }
        };

        return jdbc.query(query, mapper);
    }

}
