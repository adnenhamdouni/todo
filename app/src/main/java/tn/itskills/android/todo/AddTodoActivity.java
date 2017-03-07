package tn.itskills.android.todo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import tn.itskills.android.todo.helper.TodoHelper;
import tn.itskills.android.todo.models.Todo;

public class AddTodoActivity extends AppCompatActivity {

    private String mAction;
    private Todo mTodo;
    private List<Todo> mTodoList;

    private EditText mTodoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTodoEditText = (EditText) findViewById(R.id.todo_edittext);

        mAction = getIntent().getStringExtra("action");

        mTodoList = TodoHelper.getInstance().getTodoList();

        if (mAction.equals("edit")){
            int position = getIntent().getIntExtra("position", 0);
            mTodo = TodoHelper.getInstance().getTodoList().get(position);
            mTodoEditText.setText(mTodo.getTitle());

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String todoTitle = mTodoEditText.getText().toString();

                if (mAction.equals("edit")){
                    mTodo.setTitle(todoTitle);

                } else {
                    Todo todo = new Todo(todoTitle);
                    mTodoList.add(todo);
                }

                TodoHelper.getInstance().setTodoList(mTodoList);
                finish();
            }
        });
    }

}
