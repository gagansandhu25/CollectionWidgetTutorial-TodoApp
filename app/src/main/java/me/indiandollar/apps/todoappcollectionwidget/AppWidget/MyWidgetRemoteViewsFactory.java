package me.indiandollar.apps.todoappcollectionwidget.AppWidget;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

import me.indiandollar.apps.todoappcollectionwidget.Contract;
import me.indiandollar.apps.todoappcollectionwidget.R;

/**
 * Created by Indian Dollar on 3/22/2017.
 */

public class MyWidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private static final String TAG = "MyWidgetRemoteViewsFac";
    private ArrayList<String> mResults = new ArrayList<>();
    private Context mContext;
    private Cursor mCursor;

    public MyWidgetRemoteViewsFactory(Context applicationContext, Intent intent) {
        mContext = applicationContext;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

        if (mCursor != null) {
            mCursor.close();
        }

        final long identityToken = Binder.clearCallingIdentity();
        Uri uri = Contract.PATH_TODOS_URI;
        mCursor = mContext.getContentResolver().query(uri,
                null,
                null,
                null,
                Contract._ID + " DESC");


        Log.d(TAG, "onDataSetChanged: " + mCursor.getCount());


        Binder.restoreCallingIdentity(identityToken);

    }

    @Override
    public void onDestroy() {
        if (mCursor != null) {
            mCursor.close();
        }
    }

    @Override
    public int getCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        if (position == AdapterView.INVALID_POSITION ||
                mCursor == null || !mCursor.moveToPosition(position)) {
            return null;
        }

        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.collection_widget_list_item);
        rv.setTextViewText(R.id.widgetItemTaskNameLabel, mCursor.getString(1));

        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return mCursor.moveToPosition(position) ? mCursor.getLong(0) : position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
