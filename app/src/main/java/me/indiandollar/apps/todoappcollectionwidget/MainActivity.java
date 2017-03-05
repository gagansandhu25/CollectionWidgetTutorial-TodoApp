package me.indiandollar.apps.todoappcollectionwidget;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mActivity;
    private ArrayList<TodoModel> mTodos = new ArrayList<>();
    private ListView mListView;

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

        mActivity = this;
        mListView = (ListView) findViewById(R.id.lv_todoItems);

        mListView.setAdapter(new TodosAdapter(mActivity, mTodos));
    }
}
