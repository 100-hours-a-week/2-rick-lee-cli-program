import java.util.HashSet;
import java.util.Set;

/**
 * 재료들을 요리하는 클라스
 * 10개의 행동포인트가 있으며,
 * 행동 당 포인트 감소
 */

public class Chef {
    //행동 포인트
    private int action_point = 10;
    //시간당 요리방법의 온도
    private int fry_heat = 4;
    private int roast_heat = 3;
    private int boil_heat = 2;
    private int steam_heat = 1;

    //setter, getter
    protected int getActionPoint(){return this.action_point;}

    //유효성 검사
    protected boolean checkCuted(Food food, String new_status){ //이미 잘려져 있는 지 확인
        if(food.isCuted() &&                        
        (new_status.equals("깍뚝썰기") ||
        new_status.equals("다지기") ||
        new_status.equals("채썰기") ||
        new_status.equals("갈기") ||
        new_status.equals("회뜨기"))){
        System.out.println("    이미 잘린 재료 입니다!");
            return false;
        }
        return true;
    }
    

    //상태 중복 유효성검사 + food에 새로운 상태 추가
    protected boolean addStatus(Food food, String new_status){

        checkCuted(food, new_status);
        if(!food.getStatus().add(new_status)){  //중복된 상태가 있으면 false
            return false;
        }
        return true;
    }

    protected void cooking(Food food, String new_status){
        int cookingtime=0;
        if(addStatus(food, new_status)){
            switch (new_status) {
                case "roasted":
                    food.setHow_much_cooked(this.roast_heat*cookingtime);
                    break;
                case "boiled":
                    food.setHow_much_cooked(this.boil_heat*cookingtime);
                    break;
                case "steamed":
                    food.setHow_much_cooked(this.steam_heat*cookingtime);
                    break;
                default:
                    break;
            }
        }
    }
}