package com.esisalama.database_test.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.esisalama.database_test.database.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);
    @Update
    void update(User user);
    @Delete
    void detete(User user);
    @Query("select * from User where id= :id")
    User findOnd(int id);
    @Query("select * from User order by nom ASC")
    List<User> findAll();
}
