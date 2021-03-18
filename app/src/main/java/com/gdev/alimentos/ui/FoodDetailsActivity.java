package com.gdev.alimentos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.gdev.alimentos.R;
import com.gdev.alimentos.business.FoodBusiness;
import com.gdev.alimentos.entity.FoodEntity;

public class FoodDetailsActivity extends AppCompatActivity {

    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        instanceView();
        populateView();
    }

    private void populateView() {
        int id = getIntent().getIntExtra("ID",0);
        FoodEntity foodEntity = new FoodBusiness().get(id);

        mViewHolder.mTextName.setText(foodEntity.getName());
        mViewHolder.mTextCalorie.setText(String.valueOf(foodEntity.getCalories()));
    }

    private void instanceView(){
        mViewHolder.mTextName = findViewById(R.id.text_name);
        mViewHolder.mTextCalorie = findViewById(R.id.text_calorie);
    }

    private static class ViewHolder{
        TextView mTextName;
        TextView mTextCalorie;
    }
}