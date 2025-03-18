package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    void save(Ticket t)
    {
        int ticket_no = t.Ticket_No;
        String time = t.timestamp;
        Timestamp timestamp = Timestamp.valueOf(time);
        String d = t.date;
        Date date = Date.valueOf(d);
        String startstop = t.StartStop;
        String endstop = t.EndStop;
        long rfid = t.RFID_No;
        String route_no = t.Route_No;
        float fare = t.fare;

        String query = "INSERT INTO Ticket VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        jdbc.update(query, ticket_no, timestamp, date, startstop, endstop, rfid, route_no, fare);
    }

    List<Ticket> findAll()
    {
        String query = "SELECT * FROM Ticket";


        RowMapper<Ticket> mapper = new RowMapper<Ticket>() {
            List<Ticket> list = new ArrayList<Ticket>();

            @Override
            public Ticket mapRow(ResultSet rs, int rowNum) {
                Ticket t = new Ticket(); //Returned data will be stored here;
                try {
                        t.setTicket_No(rs.getInt("Ticket_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setTimestamp(rs.getString("TimeStamp"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setDate(rs.getString("Date"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setStartStop(rs.getString("StartStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setEndStop(rs.getString("EndStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRoute_No(rs.getString("Route_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setFare(rs.getFloat("fare"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                return t;
            }
        };

        return jdbc.query(query, mapper);
    }

    List<Ticket> findTicket_Date(Date d)
    {
        String query = "SELECT * FROM Ticket WHERE Date = ?";


        RowMapper<Ticket> mapper = new RowMapper<Ticket>() {
            List<Ticket> list = new ArrayList<Ticket>();

            @Override
            public Ticket mapRow(ResultSet rs, int rowNum) {
                Ticket t = new Ticket(); //Returned data will be stored here;
                try {
                    t.setTicket_No(rs.getInt("Ticket_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setTimestamp(rs.getString("TimeStamp"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setDate(rs.getString("Date"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setStartStop(rs.getString("StartStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setEndStop(rs.getString("EndStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRoute_No(rs.getString("Route_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setFare(rs.getFloat("fare"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                return t;
            }
        };

        return jdbc.query(query, new Object[]{d}, mapper);
    }

    List<Ticket> findTicket_RouteNo(String Route_No)
    {
        String query = "SELECT * FROM Ticket WHERE Route_No = ?";


        RowMapper<Ticket> mapper = new RowMapper<Ticket>() {
            List<Ticket> list = new ArrayList<Ticket>();

            @Override
            public Ticket mapRow(ResultSet rs, int rowNum) {
                Ticket t = new Ticket(); //Returned data will be stored here;
                try {
                    t.setTicket_No(rs.getInt("Ticket_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setTimestamp(rs.getString("TimeStamp"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setDate(rs.getString("Date"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setStartStop(rs.getString("StartStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setEndStop(rs.getString("EndStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRoute_No(rs.getString("Route_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setFare(rs.getFloat("fare"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                return t;
            }
        };

        return jdbc.query(query, new Object[]{Route_No}, mapper);
    }


    public List<Ticket> findTicket_RFIDNo(long RFID_No)
    {
        String query = "SELECT * FROM Ticket WHERE RFID_No = ?";


        RowMapper<Ticket> mapper = new RowMapper<Ticket>() {
            List<Ticket> list = new ArrayList<Ticket>();

            @Override
            public Ticket mapRow(ResultSet rs, int rowNum) {
                Ticket t = new Ticket(); //Returned data will be stored here;
                try {
                    t.setTicket_No(rs.getInt("Ticket_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setTimestamp(rs.getString("TimeStamp"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setDate(rs.getString("Date"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setStartStop(rs.getString("StartStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setEndStop(rs.getString("EndStop"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRFID_No(rs.getLong("RFID_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setRoute_No(rs.getString("Route_No"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    t.setFare(rs.getFloat("fare"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                return t;
            }
        };

        return jdbc.query(query, new Object[]{RFID_No}, mapper);
    }
}
