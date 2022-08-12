package com.esisalama.database_test.database.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Etudiant {
    @PrimaryKey public int id;
    public String nom;
    public String matricule;
    public int idPromotion;

    public Etudiant(int id, String nom, String matricule,int idPromotion) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.idPromotion=idPromotion;
    }

    public Etudiant() {
    }
}
