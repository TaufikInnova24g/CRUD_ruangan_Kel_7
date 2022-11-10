package com.example.pbpcrud.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity
    public class ruangan {

        @PrimaryKey
        public int uid;

        @ColumnInfo(name = "name")
        public String kode_ruangan;

        public String kapasitas;
    }

