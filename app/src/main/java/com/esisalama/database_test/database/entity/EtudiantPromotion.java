package com.esisalama.database_test.database.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

public class EtudiantPromotion {
    @Embedded
    public Promotion promotion;
    @Relation(
            parentColumn = "id",
            entityColumn = "idPromotion"
    )
    public Etudiant etudiant;
}
