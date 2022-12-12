package com.iapmhad.datamigrationclient.method;


import com.alibaba.fastjson.JSONArray;
import com.iapmhad.datamigrationclient.entity.HttpGetWithEntity;
import com.iapmhad.datamigrationclient.entity.NonInfoEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class NonInfoDataMigration {
    /**
     * 数据源
     *
     * @return
     */
    //数据库连接配置
    private String ip = "127.0.0.1";
    private  String sip="192.168.94.224";
    private String port = "3306";
    private String user = "root";
    private String password = "abc123";


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
        String url= "http://"+sip+":8003/data/datasavenoninfo/"+database+"/"+table;//指定URL
        System.out.println(data);
        Map<String, String> map = new HashMap<>();
        map.put("data",data);
        String reqParams = JSONArray.toJSON(map).toString();
        try {
            String str = sendJsonByGetReq(url, reqParams, "UTF-8");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sendJsonByGetReq(String url, String param, String encoding) throws Exception {
        String body = "";
        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGetWithEntity httpGetWithEntity = new HttpGetWithEntity(url);
        HttpEntity httpEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
        httpGetWithEntity.setEntity(httpEntity);
        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpGetWithEntity);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        //释放链接
        response.close();
        return body;
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
