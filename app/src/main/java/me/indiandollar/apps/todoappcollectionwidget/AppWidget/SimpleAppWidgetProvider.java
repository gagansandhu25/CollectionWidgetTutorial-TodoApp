package me.indiandollar.apps.todoappcollectionwidget.AppWidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;

import me.indiandollar.apps.todoappcollectionwidget.Contract;
import me.indiandollar.apps.todoappcollectionwidget.R;

/**
 * Created by Indian Dollar on 3/15/2017.
 */

public class SimpleAppWidgetProvider extends AppWidgetProvider {

    public static final String ACTION_DETAILS_ACTIVITY = "ACTION_DETAILS_ACTIVITY";
    public static final String EXTRA_SYMBOL = "SYMBOL";
    private static final String TAG = "SimpleAppWidgetProvider";
    private static final String REFRESH_ACTION = "me.indiandollar.apps.todoappcollectionwidget.action.REFRESH";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(

                    context.getPackageName(),
                    R.layout.simple_widget

            );

            Cursor cursor = context.getContentResolver().query(
                    Contract.PATH_TODOS_URI,
                    new String[]{"count(*)"},
                    null,
                    null,
                    null
            );

            cursor.moveToFirst();

            views.setTextViewText(R.id.tv_simpleWidgetTaskCount, String.valueOf(cursor.getInt(0)));

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }

    }

}
