package com.hosiluan.todo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.hosiluan.todo.Adapter.CustomSpinnerAdapter;
import com.hosiluan.todo.Model.ListType;
import com.hosiluan.todo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mDefaultToolbar;
    private Toolbar mSearchToolbar;
    private Spinner mSpinner;
    private ImageButton mImgButtonSearch;
    private ImageButton mImgButtonBack;
    private FloatingActionButton mFabAdd;
    private EditText mEdtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();

        setSupportActionBar(mDefaultToolbar);

        setEvent();
        initSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void setWidget() {
        mDefaultToolbar = (Toolbar) findViewById(R.id.app_bar);
        mSearchToolbar = (Toolbar) findViewById(R.id.search_bar);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mImgButtonSearch = (ImageButton) findViewById(R.id.img_btn_search);
        mImgButtonBack = (ImageButton) findViewById(R.id.img_btn_back);
        mFabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        mEdtSearch = (EditText) findViewById(R.id.edt_search);
    }

    public void setEvent() {
        mFabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hello boys", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,NewTaskActivity.class));
            }
        });

        mImgButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ahihi", Toast.LENGTH_SHORT).show();
                setSupportActionBar(mSearchToolbar);
                mDefaultToolbar.setVisibility(View.INVISIBLE);
//              mSearchToolbar.setVisibility(View.VISIBLE);
            }
        });

        mImgButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSupportActionBar(mDefaultToolbar);
                mDefaultToolbar.setVisibility(View.VISIBLE);
            }
        });

    }

    public void initSpinner() {
        ArrayList<ListType> list = new ArrayList<>();
        list.add(new ListType("All Lists", R.drawable.ic_todo));
        list.add(new ListType("Default", R.drawable.ic_todo));
        list.add(new ListType("Personal", R.drawable.ic_todo));
        list.add(new ListType("Shopping", R.drawable.ic_todo));
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getApplicationContext(), R.layout.custom_spinner_item, list);
        mSpinner.setAdapter(customSpinnerAdapter);
    }
}
