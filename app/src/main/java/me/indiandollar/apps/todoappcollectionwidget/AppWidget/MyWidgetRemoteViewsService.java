package me.indiandollar.apps.todoappcollectionwidget.AppWidget;

import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViewsService;

/**
 * Created by Indian Dollar on 3/22/2017.
 */

public class MyWidgetRemoteViewsService extends RemoteViewsService {
    private static final String TAG = "WidgetService";

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.d(TAG, "onGetViewFactory: " + "Service called");
        return new MyWidgetRemoteViewsFactory(this.getApplicationContext(), intent);
    }
}
