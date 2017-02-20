package com.phg.looksay.dao;

import java.net.URISyntaxException;
import java.sql.*;

/**
 * Created by milesporter on 2/20/17.
 */
public class MessageDao {

    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }

    public int save(int id, String theMessage) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into message (id, message) values (?,?)");
            ps.setInt(1, id);
            ps.setString(2, theMessage);
            ps.execute();
        } catch (Exception exp) {
            System.out.println("Error: " + exp.toString());
        }
        return id;
    }

    public String get(int id) {
        String theMessage = null;
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("Select message from message where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                theMessage = rs.getString(1);
            }
        } catch (Exception exp) {
            System.out.println("oops." + exp.toString());
        }
        return theMessage;
    }

    public void delete(int id) {
        String theMessage = null;
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("Delete from message where id=?");
            ps.setInt(1,id);
            ps.execute();
        } catch (Exception exp) {
            System.out.println("oops." + exp.toString());
        }
    }
}
