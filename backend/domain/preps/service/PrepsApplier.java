package backend.domain.preps.service;

import common.Food;

/**
 * 재료들을 요리하는 클라스
 * 행동 당 포인트 감소
 */

public class PrepsApplier {
    //시간당 요리방법의 온도
    private int fry_heat = 10;
    private int roast_heat = 5;
    private int boil_heat = 3;
    private int steam_heat = 1;

    PrepsValidator presVal = new PrepsValidator();

    //food에 새로운 상태 추가 + 추가할 상태가 써는거면 재료의 isCute변경
    protected boolean cooking(Food food, String new_status){
        food.addStatus(new_status);
        if(presVal.checkIsCuttingPreps(new_status)){ //재료를 자르는 요리라면 재료의 상태변경
            food.setCuted();
        }
        return true;
    }

    protected boolean cooking(Food food, String new_status, int cookingtime){

        switch (new_status) {
            case "굽기":
                food.setHow_much_cooked(this.roast_heat*cookingtime);
                break;
            case "삶기":
                food.setHow_much_cooked(this.boil_heat*cookingtime);
                break;
            case "찌기":
                food.setHow_much_cooked(this.steam_heat*cookingtime);
                break;
            case "튀기기":
            food.setHow_much_cooked(this.fry_heat*cookingtime);
            break;
            default:
                break;
        }
        return true;
    }
}