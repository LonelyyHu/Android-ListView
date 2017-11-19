package com.lonelyyhu.exercise.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lonelyyhu.exercise.customlistview.data.Letters;
import com.lonelyyhu.exercise.customlistview.adapter.SimpleRecyclerViewAdapter;

public class SimpleRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.rv_simple);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        SimpleRecyclerViewAdapter adapter = new SimpleRecyclerViewAdapter(Letters.getLetters());

        recyclerView.setAdapter(adapter);

    }
}
