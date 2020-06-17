package com.example.todomvvm.tasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.todomvvm.R;

public class AlertFragment extends AppCompatDialogFragment
{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        //the view to show
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dialog, null);

        //button Listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
        {
            MainActivityViewModel viewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);;
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch (which)
                {
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(getActivity(), "All Tasks Deleted", Toast.LENGTH_LONG).show();
                        viewModel.deleteAllTasks();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getActivity(), "Delete Cancled", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Confirm Delete")
                .setView(view)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }

}
