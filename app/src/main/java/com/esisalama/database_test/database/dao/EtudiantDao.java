package com.esisalama.database_test.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.esisalama.database_test.database.entity.Etudiant;

@Dao
public interface EtudiantDao {

    @Insert
    void insert(Etudiant etudiant);

}
