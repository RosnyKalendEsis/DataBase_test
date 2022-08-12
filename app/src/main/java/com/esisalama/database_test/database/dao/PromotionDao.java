package com.esisalama.database_test.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.esisalama.database_test.database.entity.EtudiantPromotion;
import com.esisalama.database_test.database.entity.Promotion;

import java.util.List;

@Dao
public interface PromotionDao {
    @Insert
    void insert(Promotion promotion);

    @Query("select * from Promotion")
    List<Promotion> findAll();

    @Transaction
    @Query("select * from Promotion")
    List<EtudiantPromotion> findPromotionEtudiant();
}
