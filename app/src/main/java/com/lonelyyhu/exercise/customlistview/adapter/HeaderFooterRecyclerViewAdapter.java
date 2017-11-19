package com.lonelyyhu.exercise.customlistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lonelyyhu.exercise.customlistview.R;
import com.lonelyyhu.exercise.customlistview.data.LetterModel;

import java.util.List;

/**
 * Created by hulonelyy on 2017/11/19.
 */

public class HeaderFooterRecyclerViewAdapter extends RecyclerView.Adapter {

    public static final int VIEW_TYPE_NORMAL = 0;
    public static final int VIEW_TYPE_HEADER = 1;
    public static final int VIEW_TYPE_FOOTER = 2;

    private List<LetterModel> letterModels;
    private View headerView;
    private View footerView;

    public HeaderFooterRecyclerViewAdapter(List<LetterModel> models) {
        letterModels = models;
    }

    @Override
    public int getItemViewType(int position) {

        if (headerView != null && position == 0) {
            return VIEW_TYPE_HEADER;
        }

        if (footerView != null && position == (getItemCount()-1) ) {
            return VIEW_TYPE_FOOTER;
        }

        return VIEW_TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {

            case VIEW_TYPE_HEADER:
                viewHolder = new HFViewHolder(headerView);
                break;
            case VIEW_TYPE_FOOTER:
                viewHolder = new HFViewHolder(footerView);
                break;
            default:
                View view = inflater.inflate(R.layout.layout_list_item, parent, false);
                viewHolder = new LetterViewHolder(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == VIEW_TYPE_NORMAL) {

            LetterViewHolder viewHolder = (LetterViewHolder) holder;

            int index = position;

            if (headerView != null) {
                index--;
            }

            LetterModel letterModel = letterModels.get(index);
            viewHolder.tvUpperLetter.setText(letterModel.getUpperCase());
            viewHolder.tvLowerLetter.setText(letterModel.getLowerCase());

        } else {

            HFViewHolder viewHolder = (HFViewHolder) holder;
            final View itemView = viewHolder.itemView;

            switch (viewHolder.getItemViewType()) {

                case VIEW_TYPE_HEADER:
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "click header", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;

                case VIEW_TYPE_FOOTER:
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "click footer", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
            }


        }

    }

    @Override
    public int getItemCount() {

        int count = letterModels.size();

        if (headerView != null) {
            count++;
        }

        if (footerView != null) {
            count++;
        }

        return count;
    }

    public View getHeaderView() {
        return headerView;
    }

    public void setHeaderView(View headerView) {
        this.headerView = headerView;
    }

    public View getFooterView() {
        return footerView;
    }

    public void setFooterView(View footerView) {
        this.footerView = footerView;
    }

    public class HFViewHolder extends RecyclerView.ViewHolder {
        public HFViewHolder(View itemView) {
            super(itemView);
        }
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
}
