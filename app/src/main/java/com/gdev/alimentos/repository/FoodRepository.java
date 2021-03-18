package com.gdev.alimentos.repository;

import com.gdev.alimentos.entity.FoodEntity;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    private List<FoodEntity> mFoods;

    public FoodRepository() {
        this.mFoods = new ArrayList<>();
        this.mFoods.add(new FoodEntity(0,"Alface crespa",8));
        this.mFoods.add(new FoodEntity(1,"Azeite",90));
        this.mFoods.add(new FoodEntity(2,"Batata doce",115));
        this.mFoods.add(new FoodEntity(3,"Ervilhas cruas",81));
        this.mFoods.add(new FoodEntity(4,"Feijão carioca",77));
        this.mFoods.add(new FoodEntity(5,"File de frango frito",240));
        this.mFoods.add(new FoodEntity(6,"Grão de bico",720));
        this.mFoods.add(new FoodEntity(7,"Macarrão cozido",221));
        this.mFoods.add(new FoodEntity(8,"Pão de forma 12 grãos",110));
        this.mFoods.add(new FoodEntity(9,"Queijo parmesão",18));
        this.mFoods.add(new FoodEntity(10,"Rúcula",5));
        this.mFoods.add(new FoodEntity(11,"Vagem cozida",44));
        this.mFoods.add(new FoodEntity(12,"Vodka",231));
        this.mFoods.add(new FoodEntity(13,"Whiskey",58));
    }

    public FoodEntity get(int id){
        return this.mFoods.get(id);
    }

    public List<FoodEntity> getList(){
        return  this.mFoods;
    }
}
