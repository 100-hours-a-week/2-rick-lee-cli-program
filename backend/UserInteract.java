package backend;

import java.util.ArrayList;
import java.util.logging.*;
import backend.database.*;

public class UserInteract {
    private static final Logger logger = Logger.getLogger(UserInteract.class.getName());

    Chef headChef = new Chef();
    Customer BackJongWon = new Customer();
    DataBase db = new DataBase();
    Food[] dish = new Food[5];
    int dish_idx = 0;
    Food food;


    //chef의 행동점수와 dish_idx가 5가 넘는지 체크하는 메서드
    public boolean answerKeepPlaying(){
        if(headChef.getActionPoint() < 1){
            logger.info("행동 포인트를 모두 소진");
            return false;
        }

        if(dish_idx>5){
            logger.info("dish의 재료를 모두 채움");
            return false;
        }
        return true;
    }

    //요청된 재료를 dish에 추가하는 메서드
    public boolean answerFoodSelectRequest(String food_name){
        Food food = db.getFoodClass(food_name);
        if(food == null){
            logger.warning("DB에서 재료 클래스를 불러오는데 실패");
            return false;
        }
        this.food = food;
        logger.info("DB에서 재료 객체를 불러오는데 성공");
        return true;
    }

    //현재 고른 재료를 손질하는 함수
    public boolean answerAddStatus(String new_status){
        if(!headChef.cooking(food, new_status)){
            logger.info(new_status+"추가 실패");
            return false;
        }
        logger.info(food.getName()+"에 "+new_status+"추가 성공");
        return true;
    }
    //요리시간이 필요한 재료 손질이 들어오면 반영하여 재료 손질
    public boolean answerAddStatus(String new_status, int cookingtime){
        if(!headChef.cooking(food, new_status, cookingtime)){
            logger.info(new_status+"추가 실패");
            return false;
        }
        logger.info(food.getName()+"에 "+new_status+"추가 성공");
        return true;
    }

    //dish에 food 추가하는 메서드
    public void answerAddDish(){
        dish[dish_idx] = food;
        dish_idx++;
        logger.info("Dish["+dish_idx+"]에 "+food.getName()+" 추가");
    }

    //심사평을 반환하는 메서드
    public ArrayList<String> answerReviewRequest(){
        BackJongWon.gradingDish(this.dish);
        return BackJongWon.getReviews();
    }

    //현재 고른 재료의 타입을 반환하는 함수
    public String answerCurrentFoodType(){
        if(food == null){
            logger.warning("현재 Food클래스가 존재하지 않음");
            return null;
        }
        return this.food.getType();
    }

    //현재 고른 재료의 이름을 반환하는 함수
    public String answerCurrentFoodName(){
        if(food == null){
            logger.warning("현재 Food클래스가 존재하지 않음");
            return null;
        }
        return this.food.getName();
    }
    public int answerActionPoint(){
        return headChef.getActionPoint();
    }

}