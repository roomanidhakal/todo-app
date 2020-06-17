package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from task order by priority")
    LiveData<List<TaskEntry>> loadAllTasks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(TaskEntry task);

    @Update
    void update(TaskEntry task);

    @Delete
    void deleteTask(TaskEntry task);

    @Query("Select * from task where id =:taskId")
    LiveData<TaskEntry> loadTAskById(int taskId);

    @Query("Delete from task")
    void deleteAllTask();


    //Query for Lock Table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLock(LockEntry lock);

    @Query("Select lock from lock where id = 1")
    LiveData<String> loadLockByValue();

    @Query("Select count(*) from lock")
    LiveData<Integer> getCountLock();
}
