package com.gdev.alimentos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gdev.alimentos.OnListClick;
import com.gdev.alimentos.R;
import com.gdev.alimentos.entity.FoodEntity;
import com.gdev.alimentos.viewholder.FoodViewHolder;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder>{
    private final List<FoodEntity> mFoods;
    private OnListClick mOnListClick;

    public FoodAdapter(List<FoodEntity> foodEntityList, OnListClick onListClick) {
        this.mFoods = foodEntityList;
        this.mOnListClick = onListClick;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(this.mFoods.get(position), this.mOnListClick);
    }

    @Override
    public int getItemCount() {
        return this.mFoods.size();
    }
}
