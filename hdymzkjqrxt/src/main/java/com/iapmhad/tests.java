package com.iapmhad;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tests {
    public static void main(String[] args) {
        String str="[[0,[\"1.00\",\"daohang\",\"cexiangdaohang\"]],[1,[\"zhinan\",\"daohang\",\"dingbudaohang\"]]]";
//        String str = "{\"product\":\"1\",\"code\":\"5772\",\"param\":\"200\"}";
        Pattern p1= Pattern.compile("\"(.*?)\"");
        Matcher m = p1.matcher(str);
        List<String> params = new ArrayList<>();
        while (m.find()) {
            System.out.println((m.group().trim().replace("\"","")));
            params.add((m.group().trim().replace("\"","")));
        }
        Object[] objects = params.toArray();
        System.out.println(Double.parseDouble((String) objects[0]));
    }
}
