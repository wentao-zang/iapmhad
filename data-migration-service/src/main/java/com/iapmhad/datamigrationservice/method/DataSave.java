package com.iapmhad.datamigrationservice.method;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSave {


    private String ip = "127.0.0.1";
    private String port = "3306";
    private String user = "root";
    private String password = "abc123";

    private Connection Conn(String database) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveInfo(String database, String data) throws SQLException {

        Connection conn = Conn(database);
        Statement statement = conn.createStatement();
        statement.executeUpdate(data);
        close(conn, statement);
    }

    public void saveNonInfo(String database, String table, String data) throws SQLException {

        Connection conn = Conn(database);
        Statement statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM " + table);
        statement.executeUpdate(data);
        close(conn, statement);
    }

    private void close(Connection conn, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
