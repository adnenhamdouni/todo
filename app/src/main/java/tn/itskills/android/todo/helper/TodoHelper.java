package tn.itskills.android.todo.helper;

import java.util.ArrayList;
import java.util.List;

import tn.itskills.android.todo.models.Todo;

/**
 * Created by adnenhamdouni on 07/03/2017.
 */

public class TodoHelper {

    private static volatile TodoHelper mInstance = null;

    private ArrayList<Todo> mTodoList = null;

    public static TodoHelper getInstance() {

        synchronized (TodoHelper.class) {
            if (mInstance == null) {
                mInstance = new TodoHelper();
            }
        }
        return mInstance;
    }

    private TodoHelper() {
        mTodoList = new ArrayList<>();
    }


    public void reset() {
        mInstance = null;
        mTodoList = null;
    }

    /**
     *
     */

    public void setTodoList(List<Todo> pTodoList) {
        mTodoList.clear();
        if (pTodoList != null & pTodoList.size() > 0) {
            for (Todo todo : pTodoList) {
                mTodoList.add(todo);
            }
        }
    }

    public List<Todo> getTodoList() {
        List<Todo> rTodoList = new ArrayList<>();
        if (mTodoList != null & mTodoList.size() > 0) {
            for (Todo todo : mTodoList) {
                rTodoList.add(todo);
            }
        }
        return rTodoList;
    }
}
