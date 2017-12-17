package com.lonelyyhu.exercise.customlistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.lonelyyhu.exercise.customlistview.adapter.MultiTypeRecyclerViewAdapter
import com.lonelyyhu.exercise.customlistview.data.Letters
import kotlinx.android.synthetic.main.activity_multi_type_listview.*
import kotlinx.android.synthetic.main.activity_multi_type_listview.view.*
import kotlinx.android.synthetic.main.activity_multi_type_recycler_view.*

class MultiTypeRecyclerViewActivity : AppCompatActivity() {

    lateinit var adapter: MultiTypeRecyclerViewAdapter

    val lettersData = Letters.getLetters()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_type_recycler_view)

        val recyclerView = rv_muti_type
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MultiTypeRecyclerViewAdapter(Letters.getLetters())
        recyclerView.adapter = adapter

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_multi_type_recyclerview, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        Log.wtf("MultiTypeRecyclerViewActivity", "onOptionsItemSelected")

        when (item.itemId) {

            R.id.menu_item_reset -> {
                adapter.swapData(lettersData)
            }

            R.id.menu_item_clear -> {
                adapter.clearData()
            }

            R.id.menu_item_insert -> {
                val manager = rv_muti_type.layoutManager as LinearLayoutManager
                adapter.insertItemView(manager.findFirstCompletelyVisibleItemPosition())
            }

            R.id.menu_item_delete -> {
                val manager = rv_muti_type.layoutManager as LinearLayoutManager
                adapter.removeItemView(manager.findFirstCompletelyVisibleItemPosition())
            }

            R.id.menu_item_update -> {
                val manager = rv_muti_type.layoutManager as LinearLayoutManager
                adapter.updateItemView(manager.findFirstCompletelyVisibleItemPosition())



            }

        }

        return super.onOptionsItemSelected(item)
    }

}
