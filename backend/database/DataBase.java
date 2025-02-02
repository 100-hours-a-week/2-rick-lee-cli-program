package backend.database;

import java.util.HashSet;
import java.util.Set;

import backend.database.vegetable.*;
import backend.Food;
import backend.database.meat.*;
import backend.database.seafood.*;

/**
 * 가지고 있는 재료 클래스의 정보를 전부 저장
 * 
 */
public class DataBase {
    private Set<Food> foodDataSet = new HashSet<>();

    public DataBase(){
        foodDataSet.add(new Onion());
        foodDataSet.add(new Potato());
        foodDataSet.add(new Tomato());
        foodDataSet.add(new Pork());
        foodDataSet.add(new Beef());
        foodDataSet.add(new Chicken());
        foodDataSet.add(new Salmon());
        foodDataSet.add(new Tuna());
        foodDataSet.add(new Scallops());
    }

    //요청한 클래스에 맞는 재료 클래스를 반환
    public Food getFoodClass(String className){
        for(Food food : this.foodDataSet){
            if(food.getName().equals(className)){
                return food;
            }
        }
        return null;
    }
}
