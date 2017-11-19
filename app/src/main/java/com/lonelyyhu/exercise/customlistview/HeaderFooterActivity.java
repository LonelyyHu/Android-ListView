package com.lonelyyhu.exercise.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lonelyyhu.exercise.customlistview.data.Letters;

public class HeaderFooterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_footer);


        ListView listView = findViewById(R.id.lv_head_foot);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Letters.UPPER_CASE_LETTER);
        listView.setAdapter(adapter);

        View headerView = getLayoutInflater().inflate(R.layout.layout_listview_header, null);
        View footerView = getLayoutInflater().inflate(R.layout.layout_listview_footer, null);

        listView.addHeaderView(headerView);
        listView.addFooterView(footerView);


    }
}
