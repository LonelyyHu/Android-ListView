package com.lonelyyhu.exercise.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lonelyyhu.exercise.customlistview.adapter.CustomeAdapter;
import com.lonelyyhu.exercise.customlistview.data.Letters;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        ListView listView = findViewById(R.id.lv_custom);
        ListAdapter adapter = new CustomeAdapter(Letters.getLetters(), getLayoutInflater());
        listView.setAdapter(adapter);

    }
}
