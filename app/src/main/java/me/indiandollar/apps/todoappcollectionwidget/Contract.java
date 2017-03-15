package me.indiandollar.apps.todoappcollectionwidget;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Indian Dollar on 3/5/2017.
 */

public class Contract implements BaseColumns {

    public static final String TABLE_NAME = "todos_list";
    public static final String COL_TODO_TEXT = "task";

    public static final String SCHEMA = "content://";
    public static final String AUTHORITY = "me.indiandollar.apps.todoappcollectionwidget";
    public static final Uri BASE_CONTENT_URI = Uri.parse(SCHEMA + AUTHORITY);
    public static final String PATH_TOTOS = "todos";
    public static final Uri PATH_TODOS_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOTOS).build();

}
