package com.gdev.alimentos.ui;

import android.content.Intent;
import android.os.Bundle;

import com.gdev.alimentos.OnListClick;
import com.gdev.alimentos.R;
import com.gdev.alimentos.adapter.FoodAdapter;
import com.gdev.alimentos.business.FoodBusiness;
import com.gdev.alimentos.entity.FoodEntity;
import com.gdev.alimentos.util.FoodConstants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        instanceView();
        initRecycler();
    }

    private void instanceView() {
        mViewHolder.mRecyclerFoods = findViewById(R.id.recycler_foods);
    }

    private void initRecycler() {
        List<FoodEntity> foodEntityList = new FoodBusiness().getList();

        OnListClick foodListener = id -> {
            Intent i = new Intent(MainActivity.this, FoodDetailsActivity.class);
            i.putExtra(FoodConstants.FOOD_ID, id);
            startActivity(i);
        };

        FoodAdapter foodAdapter = new FoodAdapter(foodEntityList, foodListener);
        this.mViewHolder.mRecyclerFoods.setAdapter(foodAdapter);

        this.mViewHolder.mRecyclerFoods.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFoods;
    }
}