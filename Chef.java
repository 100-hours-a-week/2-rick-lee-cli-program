import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 재료들을 요리하는 클라스
 * 10개의 행동포인트가 있으며,
 * 행동 당 포인트 감소
 */

public class Chef {
    Scanner sc = new Scanner(System.in);
    //행동 포인트
    private int action_point = 10;
    //시간당 요리방법의 온도
    private int fry_heat = 10;
    private int roast_heat = 5;
    private int boil_heat = 3;
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
    protected boolean cooking(Food food, String new_status){
        if(!checkCuted(food, new_status)){      //이미 썰린 상태면 false
            return false;
        }
        if(!food.getStatus().add(new_status)){  //중복된 상태가 있으면 false
            return false;
        }
        this.action_point--;
        return true;
    }

    protected boolean cooking(Food food, String new_status, int cookingtime){
        if(!checkCuted(food, new_status)){      //이미 썰린 상태면 false
            return false;
        }
        if(!food.getStatus().add(new_status)){  //중복된 상태가 있으면 false
            return false;
        }
        switch (new_status) {
            case "굽기":
                food.setHow_much_cooked(this.roast_heat*cookingtime);
                break;
            case "볶기":
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
        this.action_point--;
        return true;
    }
}