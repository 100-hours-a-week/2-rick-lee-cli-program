package backend.domain.Users.service;

import java.util.ArrayList;
import java.util.logging.*;

import common.Food;
/**
 * 사용자의 행동점수를 관리하고,
 * 사용자가 만든 요리(재료5개로 구성)을 관리
 * 
 */
public class UserHandler {

    Food[] dish = new Food[5];
    int dish_idx = 0;
    
    //행동 포인트
    private int action_point = 10;
    Food currentfood;


    public int getActionPoint(){return this.action_point;}
    //chef의 행동점수와 dish_idx가 5가 넘는지 체크하는 메서드
    public boolean answerKeepPlaying(){
        if(headChef.getActionPoint() < 1){
            logger.info("행동 포인트를 모두 소진");
            return false;
        }

        if(dish_idx>=5){
            logger.info("dish의 재료를 모두 채움");
            return false;
        }
        return true;
    }

    //dish에 food 추가하는 메서드
    public void answerAddDish(){
        dish[dish_idx] = food;
        logger.info("Dish["+dish_idx+"]에 "+food.getName()+" 추가");
        dish_idx++;
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