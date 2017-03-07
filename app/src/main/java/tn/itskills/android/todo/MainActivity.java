package tn.itskills.android.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import tn.itskills.android.todo.Utils.ContentData;
import tn.itskills.android.todo.Utils.event.TodoEvent;
import tn.itskills.android.todo.adapters.TodoAdapter;
import tn.itskills.android.todo.helper.TodoHelper;
import tn.itskills.android.todo.models.Todo;

public class MainActivity extends AppCompatActivity {

    private TodoAdapter mAdapter;
    private List<Todo> mTodoList;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TodoHelper.getInstance().setTodoList(ContentData.getTodoList());
        //mTodoList = TodoHelper.getInstance().getTodoList();
        mTodoList = new ArrayList<>();
        initViews();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
                intent.putExtra("action", "add");
                startActivity(intent);
            }
        });
    }

    private void initViews() {

        mRecyclerView = (RecyclerView) findViewById(R.id.todo_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setVisibility(View.VISIBLE);

        mAdapter = new TodoAdapter(this, mTodoList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTodoList = TodoHelper.getInstance().getTodoList();
        mAdapter.updateTodoList(mTodoList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(TodoEvent.MyEvent event) {
        if (event.getAction().equals("edit")) {
            Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
            intent.putExtra("action", "edit");
            intent.putExtra("position", event.getPosition());
            startActivity(intent);
        }
    }

}
