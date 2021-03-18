package com.gdev.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.gdev.alimentos.R;
import com.gdev.alimentos.business.FoodBusiness;
import com.gdev.alimentos.entity.FoodEntity;
import com.gdev.alimentos.util.FoodConstants;

public class FoodDetailsActivity extends AppCompatActivity {

    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        instanceView();
        populateView();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateView() {
        int id = getIntent().getIntExtra(FoodConstants.FOOD_ID, 0);
        FoodEntity foodEntity = new FoodBusiness().get(id);

        mViewHolder.mTextName.setText(foodEntity.getName());
        mViewHolder.mTextCalorie.setText(String.valueOf(foodEntity.getCalories()));
    }

    private void instanceView() {
        mViewHolder.mTextName = findViewById(R.id.text_name);
        mViewHolder.mTextCalorie = findViewById(R.id.text_calorie);
    }

    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalorie;
    }
}