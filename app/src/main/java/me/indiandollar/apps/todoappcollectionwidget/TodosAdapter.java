package me.indiandollar.apps.todoappcollectionwidget;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Indian Dollar on 3/5/2017.
 */

public class TodosAdapter extends BaseAdapter {

    private static final String TAG = "TodosAdapter";
    private ArrayList<TodoModel> mTodos = new ArrayList<>();
    private Context mContext;


    private LayoutInflater inflater;

    public TodosAdapter(Context c, ArrayList items) {

        mContext = c;
        inflater = LayoutInflater.from(mContext);
        mTodos = items;

    }


    @Override
    public int getCount() {
        return mTodos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        View inflater1;

        if (convertView == null) {

            inflater1 = inflater.inflate(R.layout.todo_items_list_view_single, null);
            textView = (TextView) inflater1.findViewById(R.id.tv_singleTodoItemText);

        }
        else {
            inflater1 = convertView;
            textView = (TextView) inflater1.findViewById(R.id.tv_singleTodoItemText);
        }

        textView.setText(mTodos.get(position).getText());


        return inflater1;
    }
}
