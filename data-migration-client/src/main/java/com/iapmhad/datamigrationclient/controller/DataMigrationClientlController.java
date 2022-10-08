package com.iapmhad.datamigrationclient.controller;

import com.iapmhad.datamigrationclient.entity.InfoEntity;
import com.iapmhad.datamigrationclient.entity.NonInfoEntity;
import com.iapmhad.datamigrationclient.method.InfoDataMigration;
import com.iapmhad.datamigrationclient.method.Initia;
import com.iapmhad.datamigrationclient.method.NonInfoDataMigration;

import java.io.IOException;
import java.sql.SQLException;



public class DataMigrationClientlController {

    static InfoEntity infoEntity;
    static NonInfoEntity nonInfoEntity;

    public static void dataMigration() throws IOException, SQLException {
        Initia initia=new Initia();
        InfoDataMigration infoDataMigration=new InfoDataMigration();
        NonInfoDataMigration nonInfoDataMigration=new NonInfoDataMigration();
        infoEntity= initia.IniInfo();
        nonInfoEntity= initia.IniNonInfo();

        int i = 0;
        //静态信息表同步间隔/s
        int step = 5;
        while (true) {
            i++;
//        动态数据表同步
            infoDataMigration.subData(infoEntity);

            if (i > step) {
                //        静态数据表同步
                nonInfoDataMigration.subData(nonInfoEntity);
                i -= step;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

}
