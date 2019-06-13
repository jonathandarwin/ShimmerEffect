package com.example.shimmereffect;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.shimmereffect.databinding.ListMainItemBinding;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<MainModel> listMain;

    public MainAdapter(Context context, List<MainModel> listMain){
        this.context = context;
        this.listMain = listMain;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ListMainItemBinding binding;
        public ViewHolder(ListMainItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ListMainItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_main_item, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MainModel item = listMain.get(i);
        viewHolder.binding.setViewModel(item);
    }

    @Override
    public int getItemCount() {
        return listMain.size();
    }
}
