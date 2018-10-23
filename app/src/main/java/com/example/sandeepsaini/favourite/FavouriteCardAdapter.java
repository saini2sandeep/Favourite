package com.example.sandeepsaini.favourite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Sandeep Saini on 10/23/2018
 */
public class FavouriteCardAdapter extends RecyclerView.Adapter<FavouriteCardAdapter.FavouriteViewHolder> {


    private List<Story> storyList;
    private Context context;

    public FavouriteCardAdapter(List<Story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavouriteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final FavouriteViewHolder holder, int position) {

        holder.textView.setText(storyList.get(position).getTitle());
        if (storyList.get(position).getIsLiked() == 1)
            holder.likeCheckBox.setChecked(true);
        else
            holder.likeCheckBox.setChecked(false);


        holder.likeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isPressed()) {
                    if (isChecked) {
                        holder.likeCheckBox.setChecked(false);
                    } else {
                        holder.likeCheckBox.setChecked(true);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return storyList == null ? 0 : storyList.size();
    }

    public class FavouriteViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CheckBox likeCheckBox;

        public FavouriteViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            likeCheckBox = itemView.findViewById(R.id.like_button_cb);
        }
    }
}
