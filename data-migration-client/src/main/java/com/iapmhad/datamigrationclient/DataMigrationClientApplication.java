package com.iapmhad.datamigrationclient;


import com.iapmhad.datamigrationclient.controller.DataMigrationClientlController;

import java.io.IOException;
import java.sql.SQLException;


public class DataMigrationClientApplication {

    public static void main(String[] args) throws IOException, SQLException {
        DataMigrationClientlController.dataMigration();

    }

}
