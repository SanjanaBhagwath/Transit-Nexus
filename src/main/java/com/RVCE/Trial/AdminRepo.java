package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminRepo
{
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    void save(Admin a)
    {
        int id = a.getAdmin_ID();
        String user = a.getUsername();
        String pass = a.getPassword();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(pass);

        String query = "INSERT INTO Admin VALUES(?, ?, ?)";

        jdbc.update(query, id, user, hashedPassword);
    }

    List<Admin> findAll()
    {
        String query = "SELECT * FROM Admin";


        RowMapper<Admin> mapper = new RowMapper<Admin>() {
            List<Admin> list = new ArrayList<Admin>();

            @Override
            public Admin mapRow(ResultSet rs, int rowNum) {
                Admin a = new Admin(); //Returned data will be stored here;
                try {
                    a.setAdmin_ID(rs.getInt("Admin_ID"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    a.setUsername(rs.getString("Username"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    a.setPassword(rs.getString("Password"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                return a;
            }
        };

        return jdbc.query(query, mapper);
    }

    public boolean verifyLogin(String username, String password) {
        List<Admin> admins = findAll();

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                // Verify the password using BCryptPasswordEncoder
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                if (encoder.matches(password, admin.getPassword())) {
                    return true; // Password matches
                } else {
                    return false; // Password doesn't match
                }
            }
        }
        return false; // Username not found
    }

}
