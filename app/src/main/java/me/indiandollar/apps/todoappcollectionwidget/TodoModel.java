package me.indiandollar.apps.todoappcollectionwidget;

/**
 * Created by Indian Dollar on 3/5/2017.
 */

public class TodoModel {

    private String mId;
    private Integer mText;
    private String mPosition;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Integer getText() {
        return mText;
    }

    public void setText(Integer text) {
        mText = text;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }
}
