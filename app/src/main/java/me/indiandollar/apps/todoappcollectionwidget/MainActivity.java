package me.indiandollar.apps.todoappcollectionwidget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static Context mContext;
    private ArrayList<TodoModel> mTodos = new ArrayList<>();
    private ListView mListView;
    private TodosAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddTodoDialog().show(getFragmentManager(), "AddTodoDialogFragment");
            }
        });

        mContext = this;
        mListView = (ListView) findViewById(R.id.lv_todoItems);

        getTodoList();
    }

    private void setTodosAdapter() {
        mAdapter = new TodosAdapter(mContext, mTodos);
        mListView.setAdapter(mAdapter);
    }

    public void addTodoItem(final String s) {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                ContentValues values = new ContentValues();
                values.put(Contract.COL_TODO_TEXT, s);

                final Uri uri = mContext.getContentResolver().insert(Contract.PATH_TODOS_URI, values);

                MainActivity a = (MainActivity) mContext;
                if(uri != null) {
                    a.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mContext, "New task created", Toast.LENGTH_LONG).show();
                            getTodoList();
                        }
                    });
                } else {
                    a.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mContext, "Something went wrong, task cannot be created.", Toast.LENGTH_LONG).show();
                        }
                    });
                }

                return null;

            }
        }.execute();
    }


    private void setTodoItems(ArrayList items) {
        mTodos = items;
    }


    public void getTodoList() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                Cursor cursor = null;

                try {

                    cursor = mContext.getContentResolver().query(
                            Contract.PATH_TODOS_URI,
                            null,
                            null,
                            null,
                            Contract._ID + " DESC"
                    );
                }
                catch (Exception e) {

                }


                final ArrayList<TodoModel> items = new ArrayList<>();
                while(cursor.moveToNext()) {
                    TodoModel item = new TodoModel(cursor.getInt(0), cursor.getString(1));
                    items.add(item);
                }

                cursor.close();

                MainActivity a = (MainActivity) mContext;
                a.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setTodoItems(items);
                        setTodosAdapter();
                    }
                });


                return null;

            }
        }.execute();


    }
}
