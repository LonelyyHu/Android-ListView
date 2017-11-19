package com.lonelyyhu.exercise.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lonelyyhu.exercise.customlistview.adapter.HeaderFooterRecyclerViewAdapter;
import com.lonelyyhu.exercise.customlistview.data.Letters;

public class HeaderFooterRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_footer_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.rv_head_foot);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        HeaderFooterRecyclerViewAdapter adapter = new HeaderFooterRecyclerViewAdapter(Letters.getLetters());
        adapter.setHeaderView(getLayoutInflater().inflate(R.layout.layout_listview_header, null));
        adapter.setFooterView(getLayoutInflater().inflate(R.layout.layout_listview_footer, null));
        recyclerView.setAdapter(adapter);



    }
}
