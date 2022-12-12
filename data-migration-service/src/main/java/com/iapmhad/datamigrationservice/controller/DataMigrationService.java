package com.iapmhad.datamigrationservice.controller;

import com.iapmhad.datamigrationservice.method.DataSave;
import com.iapmhad.datamigrationservice.method.IdSearch;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/data")
@CrossOrigin
public class DataMigrationService {

    @RequestMapping("/idsearch/{str}")
    public String idSearch(@PathVariable("str") String str) throws SQLException {
        IdSearch idSearch=new IdSearch();
        System.out.println(str);
        String[] links=str.split("&");
        Integer[] lastIds=idSearch.idsearch(links);
        String s= Arrays.toString(lastIds);
        System.out.println(s);
        s=s.substring(1,s.length()-1);
        return s;
    }

    @RequestMapping("/datasaveinfo/{database}")
    public void dataSaveInfo(@PathVariable("database") String database, @RequestBody Map<String,String> data) throws SQLException {
        System.out.println(data);
        DataSave dataSave=new DataSave();
        dataSave.saveInfo(database,data.get("data"));
        return;
    }

    @RequestMapping("/datasavenoninfo/{database}/{table}")
    public void dataSaveNonInfo(@PathVariable("database") String database,@PathVariable("table") String table,@RequestBody Map<String,String> data) throws SQLException {
        System.out.println(data);
        DataSave dataSave=new DataSave();
        dataSave.saveNonInfo(database,table,data.get("data"));
        return;
    }

}
