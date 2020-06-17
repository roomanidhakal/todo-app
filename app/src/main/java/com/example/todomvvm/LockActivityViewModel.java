package com.example.todomvvm;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.LockEntry;
import com.example.todomvvm.database.Repository;

import java.io.File;

public class LockActivityViewModel extends AndroidViewModel
{
    AppDatabase database;
    Repository repository;
    LiveData<LockEntry> lock;
    int check = 0;

    public LockActivityViewModel(@NonNull Application application)
    {
        super(application);
        database = AppDatabase.getInstance(application);
        repository = new Repository(database);
    }

    public boolean doesDatabaseExist(Context context, String database)
    {
        File dbFile = context.getDatabasePath(database);
        return dbFile.exists();
    }

    public LiveData<String> getLockValue()
    {
        return repository.getLockByValue();
    }

    public void insertLock(LockEntry lock)
    {
        repository.insertLock(lock);
    }

    public LiveData<Integer> getCount()
    {
        return repository.getLockCount();
    }
}
