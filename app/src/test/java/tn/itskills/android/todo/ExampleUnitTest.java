package tn.itskills.android.todo;

import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import tn.itskills.android.todo.Utils.ContentData;
import tn.itskills.android.todo.helper.TodoHelper;
import tn.itskills.android.todo.models.Todo;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    private EditText mEditText;

    @Test
    public void todoTitle() {
        Todo todo = new Todo();
        todo.setTitle("hello");

        // assert statements
        assertEquals("hello", todo.getTitle());
        assertTrue(todo.getTitle().equals("hello"));
    }



    @Test
    public void testGetTodoList() {
        ArrayList<Todo> todoList = ContentData.getTodoList();

        for (int i = 0; i<10; i++) {
            Todo todo = new Todo("TODO "+i);
            todoList.add(todo);
        }

        assertNotNull(todoList);

    }

    @Before
    public void initSingleton() {
        List<Todo> todoList = ContentData.getTodoList();
        TodoHelper.getInstance().setTodoList(todoList);
        List<Todo> todoListSingleton = TodoHelper.getInstance().getTodoList();
        assertNotNull(todoList);
        assertEquals(todoListSingleton.size(), todoList.size());

    }

    @Test
    public void testContentData() {
        ArrayList<Todo> todoList = ContentData.getTodoList();

        for (int i = 0; i<10; i++) {
            Todo todo = new Todo("TODO "+i);
            todoList.add(todo);
        }

        assertNotNull(todoList);

    }
}