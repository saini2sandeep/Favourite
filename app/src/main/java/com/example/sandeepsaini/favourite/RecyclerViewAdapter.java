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
 * Created by Sandeep Saini on 10/22/2018
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static final String ACTION_LIKE_IMAGE_CLICKED = "action_like_image_button";

    private List<Story> storyList;
    private Context context;

    private int changedItemPosition;
    private boolean isLiked;
    private AppPreferences appPreferences;

    public RecyclerViewAdapter(List<Story> storyList, Context context,AppPreferences appPreferences) {
        this.storyList = storyList;
        this.context = context;
        this.appPreferences = appPreferences;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setViewData(storyList.get(position), holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private CheckBox likeCheckBox;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            likeCheckBox = itemView.findViewById(R.id.like_button_cb);
        }

        public void setViewData(final Story story, final int adapterPosition) {
            textView.setText(story.getTitle());

            if (story.getIsLiked() == 1)
                likeCheckBox.setChecked(true);
            else
                likeCheckBox.setChecked(false);


            likeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    changedItemPosition = adapterPosition;
                    if (buttonView.isPressed()) {
                        if (isChecked) {
                            isLiked = true;
                            updateLikes();
                            appPreferences.saveFavouriteCard(story);
                            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                        } else {
                            isLiked = false;
                            updateLikes();
                            appPreferences.deleteCard(story.getIdStory());
                            Toast.makeText(context, "Removed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }

    public void updateLikes() {
        if (isLiked && storyList.get(changedItemPosition).getIsLiked() == 0) {
            storyList.get(changedItemPosition).setIsLiked(1);
            notifyItemChanged(changedItemPosition, ACTION_LIKE_IMAGE_CLICKED);
        } else if (!isLiked && storyList.get(changedItemPosition).getIsLiked() == 1) {
            storyList.get(changedItemPosition).setIsLiked(0);
            notifyItemChanged(changedItemPosition, ACTION_LIKE_IMAGE_CLICKED);
        }
    }

}
