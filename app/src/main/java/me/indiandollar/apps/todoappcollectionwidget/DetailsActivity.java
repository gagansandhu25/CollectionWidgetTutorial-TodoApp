package me.indiandollar.apps.todoappcollectionwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import me.indiandollar.apps.todoappcollectionwidget.AppWidget.CollectionAppWidgetProvider;

/**
 * Created by Indian Dollar on 3/22/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView) findViewById(R.id.detailViewTaskNameLabel);

        String text = getIntent().getStringExtra(CollectionAppWidgetProvider.EXTRA_LABEL);

        textView.setText(text);

    }
}
