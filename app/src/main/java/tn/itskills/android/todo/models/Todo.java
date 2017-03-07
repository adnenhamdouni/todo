package tn.itskills.android.todo.models;

/**
 * Created by adnenhamdouni on 07/03/2017.
 */

public class Todo {

    private String mTitle;

    public Todo() {}

    public Todo(String pTitle) {
        mTitle = pTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String pTitle) {
        mTitle = pTitle;
    }
}
