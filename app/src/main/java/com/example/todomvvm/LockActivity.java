package com.example.todomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.LockEntry;
import com.example.todomvvm.tasks.MainActivity;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class LockActivity extends AppCompatActivity
{
    LockActivityViewModel viewModel;
    String lock_value;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        //Referencing patternView by patternLockView
        final PatternLockView patternLockView = findViewById(R.id.patternView);
        viewModel = ViewModelProviders.of(this).get(LockActivityViewModel.class);

        patternLockView.addPatternLockListener(new PatternLockViewListener()
        {
            //Implementing Listener methods
            @Override
            public void onStarted()
            {
            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern)
            {
            }

            @Override
            public void onCleared()
            {
            }

            @Override
            public void onComplete(List pattern)
            {
                Log.d("LOCK", "Getting the pattern from user");
                lock_value = PatternLockUtils.patternToString(patternLockView, pattern);
                Log.d("LOCK", "Pattern is: " + lock_value);

                viewModel.getCount().observe(LockActivity.this, new Observer<Integer>()
                {
                    @Override
                    public void onChanged(Integer integer)
                    {
                        Log.d("LOCK", "Checking to see if its the first value of table");
                        Log.d("LOCK", "If 0 yesm if 1 no: " + integer);
                        if(integer == 0)
                        {
                            Log.d("LOCK", "If table is empty, insert this value with id 1");
                            LockEntry lock = new LockEntry(1, lock_value);
                            viewModel.insertLock(lock);
                            Log.d("LOCK", "Data inserted");
                            Toast.makeText(LockActivity.this, "Pattern Saved.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LockActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            viewModel.getLockValue().observe(LockActivity.this, new Observer<String>()
                            {
                                @Override
                                public void onChanged(String string)
                                {
                                    Log.d("LOCK", "Saved Pattern is: " + string);
                                    Log.d("LOCK", "User input is: " + lock_value);
                                    Log.d("LOCK", "Checking to see if the user input patten is correct");
                                    if(string.equals(lock_value))
                                    {
                                        patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
                                        Log.d("LOCK", "Correct");
                                        Intent intent = new Intent(LockActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        patternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
                                        Log.d("LOCK", "Incorrect");
                                        Toast.makeText(LockActivity.this, "Incorrect pattern", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}
