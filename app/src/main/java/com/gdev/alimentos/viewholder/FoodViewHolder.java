package com.gdev.alimentos.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gdev.alimentos.OnListClick;
import com.gdev.alimentos.R;
import com.gdev.alimentos.entity.FoodEntity;
import com.gdev.alimentos.ui.FoodDetailsActivity;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView mTextName;
    private final TextView mTextCalories;
    private FoodEntity mFood;
    private OnListClick mClick;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mTextName= itemView.findViewById(R.id.text_name);
        mTextCalories= itemView.findViewById(R.id.text_calorie);
    }

    public void bind(FoodEntity foodEntity, OnListClick click){
        mFood = foodEntity;
        mClick = click;
        this.mTextName.setText(foodEntity.getName());
        this.mTextCalories.setText(String.valueOf(foodEntity.getCalories()));

    }

    @Override
    public void onClick(View v) {
        mClick.onClick(mFood.getId());
    }
}
