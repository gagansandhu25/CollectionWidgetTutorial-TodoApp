package me.indiandollar.apps.todoappcollectionwidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Indian Dollar on 3/5/2017.
 */

public class TodosAdapter extends BaseAdapter {

    private static final String TAG = "MovieReviewAdapter";
    private ArrayList<TodoModel> mTodos;
    private Context mContext;

    private ArrayList<TodoModel> arList = new ArrayList();


    private LayoutInflater inflater;

    public TodosAdapter(Context c, ArrayList<TodoModel> reviews) {

        mContext = c;
        inflater = LayoutInflater.from(mContext);
        //mTodos = reviews;
        mTodos.add(new TodoModel("todo item 1", 1));
        mTodos.add(new TodoModel("todo item 2", 2));
        mTodos.add(new TodoModel("todo item 3", 3));

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
