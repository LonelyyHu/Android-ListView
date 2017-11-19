package com.lonelyyhu.exercise.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lonelyyhu.exercise.customlistview.adapter.MultiTypeRecyclerViewAdapter;
import com.lonelyyhu.exercise.customlistview.data.Letters;

public class MultiTypeRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.rv_muti_type);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MultiTypeRecyclerViewAdapter adapter = new MultiTypeRecyclerViewAdapter(Letters.getLetters());
        recyclerView.setAdapter(adapter);

    }
}
