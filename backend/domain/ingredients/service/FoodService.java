package backend.domain.ingredients.service;

import backend.domain.ingredients.repository.DataBase;
import common.Food;

/**
 * 요청에 대한 재료를 리턴
 */
public class FoodService {
    DataBase db = new DataBase();

    //요청된 재료를 dish에 추가하는 메서드
    public Food answerFoodSelectRequest(String food_name){
        Food food;
        try{
            food = db.getFoodClass(food_name);
        }
        catch(NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        return food;
    }
}
