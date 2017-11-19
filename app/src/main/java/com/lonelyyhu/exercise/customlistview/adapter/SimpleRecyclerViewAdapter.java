package com.lonelyyhu.exercise.customlistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lonelyyhu.exercise.customlistview.R;
import com.lonelyyhu.exercise.customlistview.data.LetterModel;

import java.util.List;

/**
 * Created by hulonelyy on 2017/11/19.
 */

public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder> {

    private List<LetterModel> letterModels;

    public SimpleRecyclerViewAdapter(List<LetterModel> models) {
        letterModels = models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.layout_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        LetterModel model = letterModels.get(position);

        holder.tvUpperLetter.setText(model.getUpperCase());
        holder.tvLowerLeter.setText(model.getLowerCase());
    }

    @Override
    public int getItemCount() {
        return letterModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAlphabet;
        TextView tvUpperLetter;
        TextView tvLowerLeter;

        public ViewHolder(View itemView) {
            super(itemView);

            ivAlphabet = itemView.findViewById(R.id.iv_alphabet);
            tvUpperLetter = itemView.findViewById(R.id.tv_upper_case);
            tvLowerLeter = itemView.findViewById(R.id.tv_lower_case);
        }
    }

}
