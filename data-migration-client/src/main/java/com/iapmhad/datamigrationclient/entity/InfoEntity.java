package com.iapmhad.datamigrationclient.entity;

import lombok.Data;

@Data
public class InfoEntity {
    int[] lastIds;
    String[] linkC;
    String[] linkS;
    String[] tables;

    public InfoEntity(int[] lastIds, String[] linkC, String[] linkS, String[] tables) {
        this.lastIds = lastIds;
        this.linkC = linkC;
        this.linkS = linkS;
        this.tables = tables;
    }
}
