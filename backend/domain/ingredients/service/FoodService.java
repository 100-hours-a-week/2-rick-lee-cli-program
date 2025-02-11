package backend.domain.ingredients.service;

import backend.domain.ingredients.repository.DataBase;
import common.Food;

/**
 * 요청에 대한 재료를 리턴
 */
public class FoodService {
    DataBase db = new DataBase();

    //요청된 재료를 dish에 추가하는 메서드
    public Food answerFoodSelect(int input){
        Food food;
        String food_name = getFoodString(input);
        food = db.getFoodClass(food_name);
        return food;
    }
    private String getFoodString(int input){
        return FOOD_STRINGS[input];
    }
    private static final String[] FOOD_STRINGS = {
        null,          // index 0: 사용하지 않음
        "양파",        // index 1
        "감자",        // index 2
        "토마토",      // index 3
        "돼지고기",    // index 4
        "소고기",      // index 5
        "닭고기",      // index 6
        "연어",        // index 7
        "참치",        // index 8
        "가리비"       // index 8
    };
}
