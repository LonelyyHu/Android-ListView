package com.lonelyyhu.exercise.customlistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lonelyyhu.exercise.customlistview.R;
import com.lonelyyhu.exercise.customlistview.data.LetterModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hulonelyy on 2017/11/19.
 */

public class MultiTypeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int VIEW_TYPE_AD = 1;
    public static final int VIEW_TYPE_NORMAL = 0;

    private List<DataModel> dataModels;

    public MultiTypeRecyclerViewAdapter(List<LetterModel> letterModelList) {

        dataModels = new ArrayList<>();

        for (int i = 0; i < letterModelList.size(); i++) {

            if ( (i%5) == 0 ) {
                DataModel model = new DataModel();
                model.viewType = VIEW_TYPE_AD;
                dataModels.add(model);
            }

            DataModel dModel = new DataModel();
            dModel.letterModel = letterModelList.get(i);
            dataModels.add(dModel);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return dataModels.get(position).viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                View view = inflater.inflate(R.layout.layout_list_item, parent, false);
                viewHolder = new LetterViewHolder(view);
                break;
            default:
                View view1 = inflater.inflate(R.layout.layout_list_item_ad, parent, false);
                viewHolder = new AdViewHolder(view1);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case VIEW_TYPE_NORMAL:
                LetterViewHolder letterViewHolder = (LetterViewHolder) holder;
                LetterModel letterModel = dataModels.get(position).letterModel;
                letterViewHolder.tvUpperLetter.setText(letterModel.getUpperCase());
                letterViewHolder.tvLowerLetter.setText(letterModel.getLowerCase());
                break;

            case VIEW_TYPE_AD:
                AdViewHolder adViewHolder = (AdViewHolder) holder;
                String text = "AD"+ (position/5);
                adViewHolder.tvAd.setText(text);
                adViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "On Click Advertisment", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }



    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    private class DataModel {
        int viewType;
        LetterModel letterModel;
    }

    public class LetterViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAlphabet;
        TextView tvUpperLetter;
        TextView tvLowerLetter;

        public LetterViewHolder(View itemView) {
            super(itemView);

            ivAlphabet = itemView.findViewById(R.id.iv_alphabet);
            tvUpperLetter = itemView.findViewById(R.id.tv_upper_case);
            tvLowerLetter = itemView.findViewById(R.id.tv_lower_case);
        }
    }

    public class AdViewHolder extends  RecyclerView.ViewHolder {

        ImageView ivAd;
        TextView tvAd;

        public AdViewHolder(View itemView) {
            super(itemView);

            ivAd = itemView.findViewById(R.id.iv_ad);
            tvAd = itemView.findViewById(R.id.tv_ad);

        }
    }


}
