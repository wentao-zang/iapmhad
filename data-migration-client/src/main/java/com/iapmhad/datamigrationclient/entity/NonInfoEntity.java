package com.iapmhad.datamigrationclient.entity;

import lombok.Data;

@Data
public class NonInfoEntity {
    String[] linkC;
    String[] linkS;
    String[] tables;


    public NonInfoEntity(String[] linkC, String[] linkS, String[] tables) {
        this.linkC = linkC;
        this.linkS = linkS;
        this.tables = tables;
    }
}
