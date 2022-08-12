package com.esisalama.database_test.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Promotion {
    @PrimaryKey public int id;
    public String nom;

    public Promotion(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Promotion() {
    }
}
