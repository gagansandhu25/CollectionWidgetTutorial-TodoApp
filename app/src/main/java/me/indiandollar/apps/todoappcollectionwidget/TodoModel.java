package me.indiandollar.apps.todoappcollectionwidget;

/**
 * Created by Indian Dollar on 3/5/2017.
 */

public class TodoModel {

    private String mId;
    private String mText;
    private Integer mPosition;

    public TodoModel(String s, Integer i) {
        setPosition(i);
        setText(s);
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Integer getPosition() {
        return mPosition;
    }

    public void setPosition(Integer position) {
        mPosition = position;
    }
}
