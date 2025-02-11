package forntend;
import java.util.ArrayList;

import backend.domain.ingredients.service.FoodService;
import backend.domain.preps.service.PrepsHandler;
import backend.domain.score.service.ScoringService;
import common.Food;

/**
 * 액션포인트 와 현재 요리 관리 및
 * 각 도메인으로 기능 요청
 */
public class Controller {
    private final int foodSelection = 9;                        //재료 선택지 범위
    private final int vegeSeletion = 8;                         //야채 손질 선택지 범위
    private final int meatSeletion = 8;                         //고기 손질 선택지 범위
    private final int seafoodSelection = 8;                     //해산물 손질 선택지 범위
    private final int cookingtimeSelection = 60;                //요리 시간 선택지 범위

    private int actionPoint = 10;
    private Food[] dish = new Food[5];
    private int dish_idx = 0;
    private Food food;

    
    Viewer front;
    FoodService foodService = new FoodService();
    PrepsHandler prepService = new PrepsHandler();
    ScoringService scoringService = new ScoringService();
    public Controller(ViewThread viewThread){
        front = new Viewer(viewThread);
    }

    //입력의 유효성을 검사하는 메서드
    private boolean checkSelection(int input, int selectionNum){ //선택지 입력 유효성 검사
        if(input > -1 && input <= selectionNum){
            return true;
        }
        return false;
    }

    public boolean checkActionPoint(){
        if(actionPoint>0){
            return true;
        }
        return false;
    }
    public boolean checkDish(){
        if(dish_idx<5){
            return true;
        }
        return false;
    }



    //선택지 인터페이스호출, 선택된 재료 요청을 server로 보냄
    protected boolean selectFood(){
        int input = front.getFoodSelections();
        if(!checkSelection(input, foodSelection)){
            front.showFoodDenied("잘못된 입력입니다");
            return false;
        }

        try{
            this.food = foodService.answerFoodSelect(input);
        }
        catch(NullPointerException e){
            front.showFoodDenied(e.getMessage());
            return false;
        }
        return true;
    }
    
    //재료 손질 선택
    public boolean selectPrep(){
        int input = 0;
        String foodType = this.food.getType();
        String foodName = this.food.getName();
        int selectionRange = 0;
        
        if(foodType.equals("vege")){
            selectionRange = vegeSeletion;
        }
        else if(foodType.equals("meat")){
            selectionRange = meatSeletion;
        }
        else if(foodType.equals("seafood")){
            selectionRange = seafoodSelection;
        }
        
        input = front.getPrepsSelection(foodType, foodName, actionPoint);

        if(!checkSelection(input, selectionRange)){   //선택지 유효성 검사
            front.showSatusDenied("잘못된 선택입니다");
            return false;
        }
        if(input == 0){
            front.showStatusSuccess(foodName);
            return true;
        }
        
        try{
            prepService.answerAddStatus(food, input);
            front.showStatusSuccess(foodName);
        }
        catch(IllegalStateException e){
            front.showSatusDenied(e.getMessage());
            return false;
        }
        catch(IllegalArgumentException e){
            selectCookingtime(food, input);
        }
        actionPoint--;
        return true;
    }

    private boolean selectCookingtime(Food food, int input){
        int cookingtime = front.getCookingTime();
        if(!checkSelection(cookingtime, cookingtimeSelection)){
            front.showSatusDenied("잘못된 입력입니다.");
            return false;
        }
        
        try{
            prepService.answerAddStatus(food, input, cookingtime);
        }
        catch(IllegalStateException e){
            front.showSatusDenied(e.getMessage());
        }
        return true;
    }
    protected boolean selectKeepPrep(){
        int input = front.getKeepPrep();
        if(input == 1){     //재료 손질을 계속
            return true;
        }
        else if(input == 2){//재료 손질을 그만둠
            dish[dish_idx] = food;
            dish_idx++;
            return false;
        }
        front.showSatusDenied("잘못된 선택입니다");
        return true;
    }

    public void showResult(){
        ArrayList<String> reviews = new ArrayList<String>();
        reviews = scoringService.gradingDish(this.dish);
        front.showDishScore(reviews);
    }

}

