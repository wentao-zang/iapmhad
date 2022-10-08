package com.iapmhad.datamigrationclient.method;

import cn.hutool.http.HttpUtil;
import com.iapmhad.datamigrationclient.entity.InfoEntity;
import com.iapmhad.datamigrationclient.entity.NonInfoEntity;

import java.sql.*;

public class NonInfoDataMigration {
    /**
     * 数据源
     *
     * @return
     */
    //数据库连接配置
    private String ip = "127.0.0.1";
    private String port = "3306";
    private String user = "root";
    private String password = "root";


    String[] linkC;
    String[] linkS;
    String[] tables;

    private Connection formConn(String database) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void subData(NonInfoEntity nonInfoEntity) throws SQLException {
        linkC = nonInfoEntity.getLinkC();
        linkS = nonInfoEntity.getLinkS();
        tables = nonInfoEntity.getTables();
        int len = linkC.length;
        for (int i = 0; i < len; i++) {
            String str = getData(tables[i], linkC[i]);
            if (str.length() > 0) {
                toService(linkS[i], tables[i],str);
            }
        }

    }


    public String getData(String table, String database) throws SQLException {
        //获取源数据库
        Connection formConn = formConn(database);
        Statement statement = formConn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table );
        int size = resultSet.getMetaData().getColumnCount();
        StringBuffer sbf = new StringBuffer();
        sbf.append("INSERT into " + table + " values ");
        boolean cmp = false;
        while (resultSet.next()) {
            if (cmp) {
                sbf.append(",");
            } else {
                cmp = true;
            }
            String link = "(";
            for (int i = 0; i < size; i++) {
                Object object = resultSet.getObject(i + 1);
                if (object == null) {
                    sbf.append(link).append("null");
                } else {
                    sbf.append(link).append("'" + object + "'");

                }
                link = ",";
            }
            sbf.append(")");
        }
        if (!cmp) {
            return "";
        }
        close(formConn, statement, resultSet);
        return sbf.toString();

    }

    void toService(String database,String table, String data) {
        String url= "http://localhost:8003/data/datasavenoninfo/"+database+"/"+table+"/"+data;//指定URL
        System.out.println(data);
        String str = HttpUtil.createGet(url).execute().body();
    }

    public void close(Connection conn, Statement stmt, ResultSet rs) {

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
