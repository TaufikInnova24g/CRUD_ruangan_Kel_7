package com.example.pbpcrud.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.pbpcrud.database.entitas.ruangan;

import java.util.List;

@Dao
public interface ruanganDao {
    @Query("SELECT * FROM ruangan")
    List<ruangan> getAll();

    @Query("INSERT INTO ruangan (name,kapasitas) VALUES(:name, :kapasitas)")
    void insertAll(String name, String kapasitas);

    @Query("UPDATE ruangan SET name=:name, kapasitas=:kapasitas WHERE uid=:uid")
    void update(int uid, String name, String kapasitas);

    @Query("SELECT * FROM ruangan WHERE uid=:uid")
    ruangan get(int uid);

    @Delete
    void delete(ruangan ruangan);
}
