package me.indiandollar.apps.todoappcollectionwidget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Indian Dollar on 3/3/2017.
 */

public class AddTodoDialog extends DialogFragment {

    private TextView mTodoItemText;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View custom = inflater.inflate(R.layout.add_todo_dialog, null);

        mTodoItemText = (TextView) custom.findViewById(R.id.dialogTask);


        builder.setView(custom);

        builder.setMessage(getString(R.string.todo_dialog_title));
        builder.setPositiveButton(getString(R.string.todo_dialog_add),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        addTodo();
                    }
                });
        builder.setNegativeButton(getString(R.string.todo_dialog_cancel), null);

        Dialog dialog = builder.create();

        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }

        return dialog;

    }

    private void addTodo() {
        MainActivity a = (MainActivity) getActivity();
        a.addTodoItem(mTodoItemText.getText().toString());
    }


}
