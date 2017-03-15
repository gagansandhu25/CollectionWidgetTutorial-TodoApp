package me.indiandollar.apps.todoappcollectionwidget;

/**
 * Created by Indian Dollar on 3/5/2017.
 */

public class TodoModel {

    private int mId;
    private String mText;
    private Integer mPosition;

    public TodoModel(int i, String s) {
        setId(i);
        setText(s);
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
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
