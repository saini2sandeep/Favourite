package com.example.sandeepsaini.favourite;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowFavouriteList extends AppCompatActivity {


    private RecyclerView recyclerView;
    private TextView noFavtsTV;

    AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_favourite_list);

        recyclerView = findViewById(R.id.recycler_view);
        noFavtsTV = findViewById(R.id.no_favt_text);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        PreferenceManager preferenceManager = new PreferenceManager(sharedPreferences);
        appPreferences = new AppPreferences(preferenceManager);

        fetchData();
    }

    private void fetchData() {
        List<Story> storyList = appPreferences.getFavouriteCardList();

        if (storyList != null && storyList.size() > 0) {
            showNoFavtText(false);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(new RecyclerViewAdapter(storyList, this,appPreferences));
        } else {
            showNoFavtText(true);
        }
    }

    private void showNoFavtText(boolean show) {
        noFavtsTV.setVisibility(show ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
    }
}
