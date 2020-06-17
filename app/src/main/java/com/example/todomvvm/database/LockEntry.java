package com.example.todomvvm.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lock")
public class LockEntry
{
    @NonNull
    @PrimaryKey
    private int id;
    private String lock;

    public LockEntry(int id, String lock)
    {
        this.id = id;
        this.lock = lock;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLock()
    {
        return lock;
    }

    public void setLock(String lock)
    {
        this.lock = lock;
    }
}
