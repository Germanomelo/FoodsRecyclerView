package com.gdev.alimentos.business;

import com.gdev.alimentos.entity.FoodEntity;
import com.gdev.alimentos.repository.FoodRepository;

import java.util.List;

public class FoodBusiness {

    public List<FoodEntity> getList(){
        return new FoodRepository().getList();
    }

    public FoodEntity get(int id){
        return new FoodRepository().get(id);
    }
}

