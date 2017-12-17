package com.lonelyyhu.exercise.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.btn_simple:
                intent = new Intent(this, SimpleListViewActivity.class);
                break;

            case R.id.btn_head_foot:
                intent = new Intent(this, HeaderFooterActivity.class);
                break;

            case R.id.btn_multi_type_lv:
                intent = new Intent(this, MultiTypeListViewActivity.class);
                break;

            case R.id.btn_simple_rv:
                intent = new Intent(this, SimpleRecyclerViewActivity.class);
                break;

            case R.id.btn_multi_type_rv:
                intent = new Intent(this, MultiTypeRecyclerViewActivity.class);
                break;

            case R.id.btn_head_foot_rv:
                intent = new Intent(this, HeaderFooterRecyclerViewActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }

    }
}
