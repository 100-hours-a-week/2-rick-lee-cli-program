package forntend;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import backend.domain.ingredients.service.FoodService;

/**
 * 액션포인트 관리 및
 * 각 도메인으로 기능 요청
 */
public class Controller {
    private final int foodSelection = 9;                        //재료 선택지 범위
    private final int vegeSeletion = 8;                         //야채 손질 선택지 범위
    private final int meatSeletion = 8;                         //고기 손질 선택지 범위
    private final int seafoodSelection = 8;                     //해산물 손질 선택지 범위
    private final int cookingtimeSelection = 60;                //요리 시간 선택지 범위

    private int action_point = 10;

    Viewer front = new Viewer();

    //입력의 유효성을 검사하는 메서드
    private boolean checkSelection(int input, int selectionNum){ //선택지 입력 유효성 검사
        if(input > -1 && input <= selectionNum){
            return true;
        }
        return false;
    }

    public boolean checkKeepPlaying(){
        return server.answerKeepPlaying();
    }

    //선택지 인터페이스호출, 선택된 재료 요청을 server로 보냄
    protected boolean selectFood(){
        int input = front.getFoodSelections();
        if(!checkSelection(input, foodSelection)){
            front.showFoodDenied();
            return false;
        }
        String food_name = "";
        switch (input) {
            case 1:
                food_name = "양파";
                break;
            case 2:
                food_name = "감자";
                break;
            case 3:
                food_name = "토마토";
                break;
            case 4:
                food_name = "돼지고기";
                break;
            case 5:
                food_name = "소고기";
                break;
            case 6:
                food_name = "닭고기";
                break;
            case 7:
                food_name = "연어";
                break;
            case 8:
                food_name = "참치";
                break;
            case 9:
                food_name = "가리비";
                break;
        }
        if(server.answerFoodSelectRequest(food_name)){
            return true;
        }
        front.showFoodDenied();
        return false;
    }
    

    //재료 손질 선택
    public boolean selectPrep(){
        int input = 0;
        String foodType = server.answerCurrentFoodType();
        if(foodType == null){       //타입 유효성 검사
            front.showSatusDenied();
            return false;
        }

        String foodName = server.answerCurrentFoodName();
        front.showCurrentFood(foodName);
        front.showActionPoint(server.answerActionPoint());

        String new_status="";
        if(foodType.equals("vege")){
            input = front.getVegeSelection();
            if(!checkSelection(input, vegeSeletion)){   //선택지 유효성 검사
                front.showSatusDenied();
                return false;
            }
            if(input == 0){
                front.showStatusSucess(foodName, "냅두기");
                return true;
            }
            new_status = getVegePrepString(input);
        }
        else if(foodType.equals("meat")){
            input = front.getMeatSelection();
            if(!checkSelection(input, meatSeletion)){   //선택지 유효성 검사
                front.showSatusDenied();
                return false;
            }
            if(input == 0){
                front.showStatusSucess(foodName, "냅두기");
                return true;
            }
            new_status = getMeatPrepString(input);
        }
        else if(foodType.equals("seafood")){
            input = front.getSeafoodSelection();
            if(!checkSelection(input, seafoodSelection)){   //선택지 유효성 검사
                front.showSatusDenied();
                return false;
            }
            if(input == 0){
                front.showStatusSucess(foodName, "냅두기");
                return true;
            }

            new_status = getSeafoodPrepString(input);
        }

        if(cookingStatus.contains(new_status)){     //요리 시간을 필요로하는 손질이라면 요리 시간을 추가 입력
            int cookingtime = front.getCookingTime();
            if(!checkSelection(input, cookingtimeSelection)){
                front.showSatusDenied();
                return false;
            }
            if(!server.answerAddStatus(new_status, cookingtime)){
                front.showSatusDenied();
                return false;
            }
        }
        else{                                       //요리 시간이 필요로 하지 않는다면 서버에 입력값 전송
            if(!server.answerAddStatus(new_status)){
                front.showSatusDenied();
                return false;
            }
        }
        return true;
    }
    
    protected boolean selectKeepPrep(){
        int input = front.getKeepPrep();
        if(input == 1){     //재료 손질을 계속
            return false;
        }
        else if(input == 2){//재료 손질을 그만둠
            server.answerAddDish();
            return true;
        }
        front.showEndDenied();
            return false;
    }

    public boolean selectEnd(){
        int input = front.getEndSelection();
        if(input == 1){
            return true;
        }
        else if(input == 2){
            return false;
        }
        front.showEndDenied();
        return false;
    }

    public void showResult(){
        ArrayList<String> reviews = new ArrayList<String>();
        reviews = server.answerReviewRequest();
        front.showDishScore(reviews);
    }

}

