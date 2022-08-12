package com.esisalama.database_test.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.esisalama.database_test.database.dao.EtudiantDao;
import com.esisalama.database_test.database.dao.PromotionDao;
import com.esisalama.database_test.database.dao.UserDao;
import com.esisalama.database_test.database.entity.Etudiant;
import com.esisalama.database_test.database.entity.EtudiantPromotion;
import com.esisalama.database_test.database.entity.Promotion;
import com.esisalama.database_test.database.entity.User;

@Database(
        entities = {User.class, Etudiant.class, Promotion.class},
        version = 2
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract EtudiantDao etudiantDao();
    public  abstract PromotionDao promotionDao();
}
