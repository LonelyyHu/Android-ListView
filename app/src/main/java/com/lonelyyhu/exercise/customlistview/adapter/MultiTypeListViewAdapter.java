package com.lonelyyhu.exercise.customlistview.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lonelyyhu.exercise.customlistview.R;
import com.lonelyyhu.exercise.customlistview.data.LetterModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hulonelyy on 2017/11/18.
 */

public class MultiTypeListViewAdapter extends BaseAdapter {

    public static final int VIEW_TYPE_NORMAL = 0;
    public static final int VIEW_TYPE_AD = 1;

    private List<DataModel> dataModels = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public MultiTypeListViewAdapter(List<LetterModel> letterModels, LayoutInflater layoutInflater) {

        this.layoutInflater = layoutInflater;

        for (int i = 0; i < letterModels.size(); i++) {

            DataModel model = new DataModel();

            if ( i > 0 && (i%5) == 0) {
                DataModel adModel = new DataModel();
                adModel.viewType = VIEW_TYPE_AD;
                dataModels.add(adModel);
            }

            model.letterModel = letterModels.get(i);
            dataModels.add(model);

        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return dataModels.get(position).viewType;
    }

    @Override
    public int getCount() {
        return dataModels.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.wtf("MultiTypeListViewAdapter", "getView, position: " + position);
        Log.wtf("MultiTypeListViewAdapter", "getView, convertView: " + convertView);

        DataModel model = dataModels.get(position);
        ViewHolder holder = null;

        int viewType = getItemViewType(position);

        switch (viewType) {

            case VIEW_TYPE_AD:

                if (convertView == null) {
                    convertView = layoutInflater.inflate(R.layout.layout_list_item_ad, null);
                }

                break;

            case VIEW_TYPE_NORMAL:

                if (convertView == null) {
                    convertView = layoutInflater.inflate(R.layout.layout_list_item, null);
                    TextView tvUpper = convertView.findViewById(R.id.tv_upper_case);
                    TextView tvLower = convertView.findViewById(R.id.tv_lower_case);
                    ImageView ivAdv = convertView.findViewById(R.id.iv_ad);

                    holder = new ViewHolder();
                    holder.upperLetter = tvUpper;
                    holder.lowerLetter = tvLower;
                    holder.advImage = ivAdv;
                    convertView.setTag(holder);

                } else {

                    holder = (ViewHolder) convertView.getTag();

                }

                holder.upperLetter.setText(model.letterModel.getUpperCase());
                holder.lowerLetter.setText(model.letterModel.getLowerCase());

                break;


        }

        return convertView;
    }

    public void clearData() {
        dataModels.clear();
        notifyDataSetChanged();
    }

    public void swapData(List<LetterModel> letterModels) {

        dataModels.clear();

        for (int i = 0; i < letterModels.size(); i++) {

            DataModel model = new DataModel();

            if ( i > 0 && (i%5) == 0) {
                DataModel adModel = new DataModel();
                adModel.viewType = VIEW_TYPE_AD;
                dataModels.add(adModel);
            }

            model.letterModel = letterModels.get(i);
            dataModels.add(model);

        }

        notifyDataSetChanged();
    }

    public void updateItemView(ListView listView, int position) {
        int index = position - listView.getFirstVisiblePosition();
        if (index >= 0 && index < listView.getChildCount()) {
            DataModel dataModel = dataModels.get(position);

            if (dataModel.viewType == VIEW_TYPE_NORMAL) {
                dataModel.letterModel.setLowerCase("-");
                dataModel.letterModel.setUpperCase("-");
            }

            View itemView = listView.getChildAt(index);
            getView(position, itemView, listView);
//            notifyDataSetChanged();
        }
    }

    private class ViewHolder {
        TextView upperLetter;
        TextView lowerLetter;
        ImageView advImage;
    }

    private class DataModel {
        int viewType;
        private LetterModel letterModel;

    }
}
