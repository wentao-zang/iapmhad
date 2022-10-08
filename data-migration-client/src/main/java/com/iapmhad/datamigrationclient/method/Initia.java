package com.iapmhad.datamigrationclient.method;

import cn.hutool.http.HttpUtil;
import com.iapmhad.datamigrationclient.entity.InfoEntity;
import com.iapmhad.datamigrationclient.entity.NonInfoEntity;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initia {
     String[] databases1={"hdymzkjqrxt"};
     String[] databases2={"hdym"};

     int[] lastIds;
     List<String> linkC;
     List<String> linkS;
     List<String> tables;


    private  String ip="127.0.0.1";
    private  String port="3306";
    private  String user="root";
    private  String password="root";

    private Connection Conn(String database) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/" + database + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  InfoEntity IniInfo() throws SQLException, IOException {
        linkC=new ArrayList<>();
        linkS=new ArrayList<>();
        tables=new ArrayList<>();
        int len=databases1.length;
        for (int i = 0; i < len; i++) {
            searchTablesInfo(databases1[i],databases2[i]);
        }
        lastIds=getLastIds();
        return new InfoEntity(lastIds,linkC.toArray(new String[0]),linkS.toArray(new String[0]),tables.toArray(new String[0]));
    }
    public  NonInfoEntity IniNonInfo() throws SQLException, IOException {
        linkC=new ArrayList<>();
        linkS=new ArrayList<>();
        tables=new ArrayList<>();
        int len=databases1.length;
        for (int i = 0; i < len; i++) {
            searchTablesNonInfo(databases1[i],databases2[i]);
        }
        return new NonInfoEntity(linkC.toArray(new String[0]),linkS.toArray(new String[0]),tables.toArray(new String[0]));
    }
    public  int[] getLastIds() throws IOException {
        int len=linkS.size();
        StringBuffer st=new StringBuffer();
        for (int i = 0; i < len; i++) {
            st.append(linkS.get(i) +";"+tables.get(i)+',');
        }
        String url= "http://localhost:8003/data/idsearch/"+st;//指定URL
        String str = HttpUtil.createGet(url).execute().body();
        str=str.replaceAll("\\s*", "");
        String[] s=str.split(",");
        int[] nums=new int[s.length];
        for(int i=0;i<s.length;i++){
            nums[i]=Integer.parseInt(s[i]);
        }
        return nums;
    }
     void searchTablesInfo(String database1, String database2) throws SQLException {
        Connection conn = Conn(database1);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW TABLES FROM " + database1);
        while (resultSet.next()) {
            String form = (String) (resultSet.getObject(1));
            //判断是否动态
            if (form.substring(form.length() - 4).equals("info")) {
                tables.add(form);
                linkC.add(database1);
                linkS.add(database2);
            }
        }
        close(conn,statement,resultSet);
        return;
    }
     void searchTablesNonInfo(String database1, String database2) throws SQLException {
        Connection conn = Conn(database1);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW TABLES FROM " + database1);
        while (resultSet.next()) {
            String form = (String) (resultSet.getObject(1));
            //判断是否动态
            if (!form.substring(form.length() - 4).equals("info")) {
                tables.add(form);
                linkC.add(database1);
                linkS.add(database2);
            }
        }
        close(conn,statement,resultSet);
        return;
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
