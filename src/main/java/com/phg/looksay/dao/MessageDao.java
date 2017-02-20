package com.phg.looksay.dao;

import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.sql.*;

/**
 * Created by milesporter on 2/20/17.
 */
@Component
public class MessageDao {

    private static Connection conn = null;

    private static Connection getConnection() throws URISyntaxException, SQLException {
        if (conn==null) {
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            conn = DriverManager.getConnection(dbUrl);
        }
        return conn;
    }

    public boolean save(int device, int channel, String theMessage) {
        boolean result = false;
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into message (device, channel, message) values (?,?,?)");
            ps.setInt(1, device);
            ps.setInt(2, channel);
            ps.setString(3, theMessage);
            ps.execute();
            result=true;
        } catch (Exception exp) {
            System.out.println("Error: " + exp.toString());
        }
        return result;
    }

    public String get(int device, int channel) {
        String theMessage = null;
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("Select message from message where device=? and channel=?");
            ps.setInt(1,device);
            ps.setInt(2,channel);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                theMessage = rs.getString(1);
            }
        } catch (Exception exp) {
            System.out.println("oops." + exp.toString());
        }
        return theMessage;
    }

    public void delete(int device, int channel) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("Delete from message where device=? and channel=?");
            ps.setInt(1,device);
            ps.setInt(2,channel);
            ps.execute();
        } catch (Exception exp) {
            System.out.println("oops." + exp.toString());
        }
    }
}
