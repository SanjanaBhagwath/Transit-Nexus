package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RouteRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    void save(Route r)
    {
        String route = r.Route_no;
        String s = r.Source;
        String d = r.Destination;

        String query = "INSERT INTO Routes VALUES(?, ?, ?)";

        jdbc.update(query, route, s, d);
    }

    public List<Route> findAll()
    {
        String query = "SELECT * FROM Routes";


        RowMapper<Route> mapper = new RowMapper<Route>()
        {
            @Override
            public Route mapRow(ResultSet rs, int rowNum) {
                Route r = new Route(); //Returned data will be stored here;
                try {
                    r.setRoute_no(rs.getString("Route_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setSource(rs.getString("Source"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    r.setDestination(rs.getString("Destination"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                return r;
            }
        };

        return jdbc.query(query, mapper);
    }

    public boolean existsByRouteNo(String routeNo) {
        String query = "SELECT COUNT(*) FROM Routes WHERE Route_No = ?";
        int count = jdbc.queryForObject(query, Integer.class, routeNo);
        return count > 0;
    }
}
