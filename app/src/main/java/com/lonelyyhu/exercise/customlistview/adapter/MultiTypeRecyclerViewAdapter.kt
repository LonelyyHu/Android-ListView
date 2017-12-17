package com.lonelyyhu.exercise.customlistview.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.lonelyyhu.exercise.customlistview.R
import com.lonelyyhu.exercise.customlistview.data.LetterModel

import java.util.ArrayList

/**
 * Created by hulonelyy on 2017/11/19.
 */

class MultiTypeRecyclerViewAdapter(letterModelList: List<LetterModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataModels = mutableListOf<DataModel>()

    companion object {
        const val VIEW_TYPE_EMPTY = -1
        const val VIEW_TYPE_AD = 1
        const val VIEW_TYPE_NORMAL = 0
    }

    init {

        for (i in letterModelList.indices) {

            if (i % 5 == 0) {
                val model = DataModel()
                model.viewType = VIEW_TYPE_AD
                dataModels.add(model)
            }

            val dModel = DataModel()
            dModel.letterModel = letterModelList[i]
            dataModels.add(dModel)
        }
    }

    override fun getItemViewType(position: Int): Int {

        Log.wtf("MultiTypeRecyclerViewAdapter", "getItemViewType:$position")

        return if (dataModels.size > 0)
            dataModels[position].viewType
        else
            VIEW_TYPE_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        Log.wtf("MultiTypeRecyclerViewAdapter", "onCreateViewHolder")

        val inflater = LayoutInflater.from(parent.context)

        val viewHolder: RecyclerView.ViewHolder

        when (viewType) {

            VIEW_TYPE_EMPTY -> {
                val view = inflater.inflate(R.layout.layout_empty_view, parent, false)
                viewHolder = EmptyViewHolder(view)
            }

            VIEW_TYPE_NORMAL -> {
                val view = inflater.inflate(R.layout.layout_list_item, parent, false)
                viewHolder = LetterViewHolder(view)
            }
            else -> {
                val view = inflater.inflate(R.layout.layout_list_item_ad, parent, false)
                viewHolder = AdViewHolder(view)
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        Log.wtf("MultiTypeRecyclerViewAdapter", "onBindViewHolder:$position")

        when (holder.itemViewType) {

            VIEW_TYPE_NORMAL -> {
                val letterViewHolder = holder as LetterViewHolder
                val letterModel = dataModels[position].letterModel
                letterViewHolder.tvUpperLetter.text = letterModel!!.upperCase
                letterViewHolder.tvLowerLetter.text = letterModel.lowerCase
            }

            VIEW_TYPE_AD -> {
                val adViewHolder = holder as AdViewHolder
                val text = "AD" + position / 5
                adViewHolder.tvAd.text = text
                adViewHolder.itemView.setOnClickListener { v -> Toast.makeText(v.context, "On Click Advertisment", Toast.LENGTH_SHORT).show() }
            }
        }


    }

    override fun getItemCount(): Int {
        return if (dataModels.size > 0)
            dataModels.size
        else
            1
    }

    fun swapData(lettersData: List<LetterModel>) {

        dataModels.clear()

        for ( i in lettersData) {

            val data = DataModel()
            data.letterModel = i
            dataModels.add(data)

        }

        notifyDataSetChanged()
    }

    fun clearData() {
        dataModels.clear()
        notifyDataSetChanged()
    }

    fun insertItemView(position: Int) {

        val data = DataModel()
        data.viewType = VIEW_TYPE_NORMAL
        data.letterModel = LetterModel("-", "-")

        dataModels.add(position, data)
        notifyItemInserted(position)
    }

    fun removeItemView(position: Int) {

        dataModels.removeAt(position)

        notifyItemRemoved(position)

    }

    fun updateItemView(position: Int) {

        val data = dataModels[position]

        when (data.viewType) {

            VIEW_TYPE_NORMAL -> {
                data.letterModel?.lowerCase = "-"
                data.letterModel?.upperCase = "-"
            }

        }

        notifyItemChanged(position)
    }

    private inner class DataModel {
        internal var viewType: Int = 0
        internal var letterModel: LetterModel? = null
    }

    private inner class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var ivAlphabet: ImageView
        internal var tvUpperLetter: TextView
        internal var tvLowerLetter: TextView

        init {

            ivAlphabet = itemView.findViewById(R.id.iv_alphabet)
            tvUpperLetter = itemView.findViewById(R.id.tv_upper_case)
            tvLowerLetter = itemView.findViewById(R.id.tv_lower_case)
        }
    }

    private inner class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var ivAd: ImageView
        internal var tvAd: TextView

        init {

            ivAd = itemView.findViewById(R.id.iv_ad)
            tvAd = itemView.findViewById(R.id.tv_ad)

        }
    }

    private inner class EmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

        }

    }




}
