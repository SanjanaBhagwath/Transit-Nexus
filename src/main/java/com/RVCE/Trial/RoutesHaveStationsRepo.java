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
public class RoutesHaveStationsRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    void save(RoutesHaveStations ob)
    {
        String r = ob.route_no;
        String s = ob.station_name;
        int o = ob.station_order;

        String query = "INSERT INTO RoutesHaveStations VALUES(?, ?, ?)";

        jdbc.update(query, r, s, o);
    }

    List<RoutesHaveStations> findAll()
    {
        String query = "SELECT * FROM RoutesHaveStations";


        RowMapper<RoutesHaveStations> mapper = new RowMapper<RoutesHaveStations>() {
            List<RoutesHaveStations> list = new ArrayList<RoutesHaveStations>();

            @Override
            public RoutesHaveStations mapRow(ResultSet rs, int rowNum) {
                RoutesHaveStations r = new RoutesHaveStations(); //Returned data will be stored here;
                try {
                    r.setRoute_no(rs.getString("Route_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setStation_name(rs.getString("Station_Name"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setStation_order(rs.getInt("Station_Order"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                return r;
            }
        };

        return jdbc.query(query, mapper);
    }

}
