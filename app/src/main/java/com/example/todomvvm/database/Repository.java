package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    TaskDao dao;

    public Repository(AppDatabase appDatabase){
        dao = appDatabase.taskDao();
    }

    public LiveData<List<TaskEntry>> getTasks(){
       return dao.loadAllTasks();
    }

    public LiveData<TaskEntry> getTaskById(int taskId){
        return dao.loadTAskById(taskId);
    }

    public void updateTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(task);
            }
        });
    }

    public void deleteTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
               dao.deleteTask(task);
            }
        });
    }

    public  void  insertTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertTask(task);
            }
        });
    }




    public  void  insertLock(final LockEntry lock)
    {
        AppDatabase.databaseWriteExecutor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                dao.insertLock(lock);
            }
        });
    }

    public LiveData<String> getLockByValue()
    {
        return dao.loadLockByValue();
    }

    public LiveData<Integer> getLockCount()
    {
        return dao.getCountLock();
    }
}
