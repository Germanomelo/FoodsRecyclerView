package com.gdev.alimentos.ui;

import android.content.Intent;
import android.os.Bundle;

import com.gdev.alimentos.OnListClick;
import com.gdev.alimentos.R;
import com.gdev.alimentos.adapter.FoodAdapter;
import com.gdev.alimentos.business.FoodBusiness;
import com.gdev.alimentos.entity.FoodEntity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        instanceView();
        initRecycler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void instanceView() {
        mViewHolder.mRecyclerFoods = findViewById(R.id.recycler_foods);
    }

    private void initRecycler() {
        List<FoodEntity> foodEntityList = new FoodBusiness().getList();

        OnListClick foodListener = new OnListClick() {
            @Override
            public void onClick(int id) {
                Intent i = new Intent(MainActivity.this, FoodDetailsActivity.class);
                i.putExtra("ID", id);
                startActivity(i);
            }
        };

        FoodAdapter foodAdapter = new FoodAdapter(foodEntityList, foodListener);
        this.mViewHolder.mRecyclerFoods.setAdapter(foodAdapter);

        this.mViewHolder.mRecyclerFoods.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFoods;
    }
}