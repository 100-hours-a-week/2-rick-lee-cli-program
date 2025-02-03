package backend;

import backend.database.*;

public class UserInteract {
    Chef heaChef = new Chef();
    Customer BackJongWon = new Customer();
    DataBase db = new DataBase();
    Food[] dish = new Food[5];
    int dish_idx = 0;
    Food food;


    //chef의 행동점수와 dish_idx가 5가 넘는지 체크하는 메서드
    public boolean checkKeepGoing(){
        if(dish_idx>5 || heaChef.getActionPoint() < 1){
            return false;
        }
        return true;
    }
    //요청된 재료를 dish에 추가
    public boolean getFoodRequest(String food_name){
        Food food = db.getFoodClass(food_name);
        if(food == null){
            return false;
        }
        return true;
    }



    //dish에 food 추가
}