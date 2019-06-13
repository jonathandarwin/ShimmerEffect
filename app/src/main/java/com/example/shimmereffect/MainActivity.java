package com.example.shimmereffect;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shimmereffect.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements APIHandler{

    ActivityMainBinding binding;
    MainAdapter adapter;
    List<MainModel> listMain;
    MainRepostiory repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        startAnimation();
        initAdapter();
        repo = new MainRepostiory(this, this);
        repo.getData();

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listMain.clear();
                adapter.notifyDataSetChanged();
                startAnimation();
                repo.getData();
            }
        });
    }

    private void initAdapter(){
        listMain = new ArrayList<>();
        adapter = new MainAdapter(this, listMain);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void success(List<MainModel> response) {
        binding.swipeRefresh.setRefreshing(false);
        listMain.clear();
        listMain.addAll(response);
        adapter.notifyDataSetChanged();
        stopAnimation();
    }

    private void startAnimation(){
        binding.mainShimmer.startShimmerAnimation();
        binding.mainShimmer.setVisibility(View.VISIBLE);
    }

    private void stopAnimation(){
        binding.mainShimmer.stopShimmerAnimation();
        binding.mainShimmer.setVisibility(View.GONE);
    }
}
