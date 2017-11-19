package com.lonelyyhu.exercise.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lonelyyhu.exercise.customlistview.data.Letters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleListViewActivity extends AppCompatActivity {

    private String keyData1 = "upper";
    private String keyData2 = "lower";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        ListView listView = findViewById(R.id.lv_simple);

//        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Letters.UPPER_CASE_LETTER);

//        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, Letters.UPPER_CASE_LETTER);
//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

//        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Letters.UPPER_CASE_LETTER);
//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

//        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, Letters.UPPER_CASE_LETTER);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ListAdapter adapter = new SimpleAdapter(this, genData(Letters.UPPER_CASE_LETTER, Letters.LOWER_CASE_LETTER), android.R.layout.simple_list_item_2,
                new String[]{keyData1, keyData2}, new int[]{android.R.id.text1, android.R.id.text2});

        listView.setAdapter(adapter);

    }

    private List<Map<String, String>> genData(String[] dataSet1, String[] dataSet2) {

        List<Map<String, String>> rList = new ArrayList<>();

        for (int i=0; i<dataSet1.length;i++) {
            Map<String, String> m = new HashMap<>();
            m.put(keyData1, dataSet1[i]);
            m.put(keyData2, dataSet2[i]);
            rList.add(m);
        }
        return rList;
    }
}
