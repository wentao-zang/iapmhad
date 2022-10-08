package com.iapmhad.datamigrationservice;


import com.iapmhad.datamigrationservice.controller.DataMigrationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.sql.SQLException;

@SpringBootApplication
@EnableDiscoveryClient
public class DatamigrationServiceApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DatamigrationServiceApplication.class, args);
    }

}
