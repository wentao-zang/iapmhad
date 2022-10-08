package com.iapmhad.datamigrationservice.method;

import java.sql.*;

public class IdSearch {

    private  String ip="127.0.0.1";
    private  String port="3306";
    private  String user="root";
    private  String password="root";

    private  Connection Conn(String database) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/" + database + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  Integer[] idsearch(String[]  links) throws SQLException {
        int len=links.length;
        Integer[] lastIds=new Integer[len];
        for (int i = 0; i < len; i++) {
            lastIds[i]=getId(links[i]);
        }
        return lastIds;
    }
    public  int getId(String link) throws SQLException {
        String[] s=link.split(";");
        Connection conn = Conn(s[0]);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id FROM " + s[1] + "  ORDER BY id DESC LIMIT 0,1\n");
        int id=0;
        if (resultSet.next()){
            id=(int)resultSet.getObject(1);
        }
        close(conn,statement,resultSet);
        return id;
    }

    public  void close(Connection conn, Statement stmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
