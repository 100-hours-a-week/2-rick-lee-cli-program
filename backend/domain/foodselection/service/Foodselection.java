package backend.domain.foodselection.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import backend.domain.foodselection.Food;
import backend.domain.foodselection.dao.DAO;

/*선택지를 입력받으면, 해당 Food 객체를 반환 */
public class Foodselection {

    private enum FoodItems {
        ONION(1, "양파"),
        POTATO(2, "감자"),
        TOMATO(3, "토마토"),
        PORK(4, "돼지고기"),
        BEEF(5, "소고기"),
        CHICKEN(6, "닭고기"),
        SALMON(7, "연어"),
        TUNA(8, "참치"),
        SCALLOP(9, "가리비");

        private final int idx;
        private final String foodName;

        FoodItems(int idx, String foodName) {
            this.idx = idx;
            this.foodName = foodName;
        }
        public String getFoodName() {
            return foodName;
        }
    }
    private static final Map<Integer, FoodItems> lookup = new HashMap<>();

    DAO db = new DAO();

    private String traslateInputToString(int input){
        FoodItems selectedFood = lookup.get(input);
        return selectedFood.getFoodName();
    }

    public Optional<Food> getFoodbyNum (int input){
        String food_name = traslateInputToString(input);
        Food food = db.getFoodClass(food_name);
        return Optional.ofNullable(food);
    }
}
