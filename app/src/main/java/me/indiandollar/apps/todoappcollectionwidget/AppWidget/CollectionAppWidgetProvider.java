package me.indiandollar.apps.todoappcollectionwidget.AppWidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.RemoteViews;

import me.indiandollar.apps.todoappcollectionwidget.MainActivity;
import me.indiandollar.apps.todoappcollectionwidget.R;

/**
 * Created by Indian Dollar on 3/22/2017.
 */

public class CollectionAppWidgetProvider extends AppWidgetProvider {

    public static final String EXTRA_SYMBOL = "";
    private static final String TAG = "CollectionAppWidgetP";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(

                    context.getPackageName(),
                    R.layout.collection_widget

            );

            Log.d(TAG, "onUpdate: " + "provider called");

            Intent intent = new Intent(context, MyWidgetRemoteViewsService.class);
            views.setRemoteAdapter(R.id.widgetListView, intent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
