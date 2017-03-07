package tn.itskills.android.todo.Utils;

import java.util.ArrayList;

import tn.itskills.android.todo.models.Todo;

/**
 * Created by adnenhamdouni on 07/03/2017.
 */

public class ContentData {

    public static ArrayList<Todo> getTodoList(){

        ArrayList<Todo> todoList = new ArrayList<>();

        for (int i = 0; i<10; i++) {
            Todo todo = new Todo("TODO "+i);
            todoList.add(todo);
        }

        return todoList;

    }
}
