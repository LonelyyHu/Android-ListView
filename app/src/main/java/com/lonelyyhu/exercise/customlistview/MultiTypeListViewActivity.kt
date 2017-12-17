package com.lonelyyhu.exercise.customlistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView

import com.lonelyyhu.exercise.customlistview.adapter.MultiTypeListViewAdapter
import com.lonelyyhu.exercise.customlistview.data.Letters
import kotlinx.android.synthetic.main.activity_multi_type_listview.*

class MultiTypeListViewActivity : AppCompatActivity() {

    lateinit var adapter: MultiTypeListViewAdapter
    var lettersData = Letters.getLetters()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_type_listview)

        val listView = findViewById<ListView>(R.id.lv_custom)
        val emptyView = findViewById<View>(R.id.empty_layout)
        adapter = MultiTypeListViewAdapter(lettersData, layoutInflater)
        listView.adapter = adapter
        listView.emptyView = emptyView
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_multi_type_listview, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        Log.wtf("MultiTypeListViewActivity", "onOptionsItemSelected")

        when (item.itemId) {

            R.id.menu_item_reset -> {
                adapter.swapData(lettersData)
            }

            R.id.menu_item_clear -> {
                adapter.clearData()
            }

            R.id.menu_item_update -> {
                adapter.updateItemView(lv_custom, lv_custom.firstVisiblePosition)
            }

        }

        return super.onOptionsItemSelected(item)
    }
}
