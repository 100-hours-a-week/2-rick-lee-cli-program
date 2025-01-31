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
    protected void reduceActionPoint(){this.action_point--;}

    //유효성 검사
    protected boolean checkCuted(Food food, String new_status){ //이미 잘려져 있는 지 확인
        if(food.isCuted() ||                        
        (new_status.equals("dies_cut") ||
        new_status.equals("crushed") ||
        new_status.equals("fine_cut") ||
        new_status.equals("grinded") ||
        new_status.equals("sasimi"))){
        System.out.println("이미 잘린 재료 입니다!");
            return false;
        }
        return true;
    }
    
    protected boolean checkOverlabStatus(Food food, String new_status){ // status중복 발견
        if(food.getStatus() ==null){
            return true;
        }
        Set<String> statusSet = new HashSet<>();
        statusSet.add(new_status);
        for (String status : food.getStatus()) {
            if (!statusSet.add(status)) { // 중복 발견
                System.out.println("이미" + new_status +"된 재료입니다!");
                return false;
            }
        }
        return true;
    }

    //재료의 상태 추가
    protected boolean addStatus(Food food, String new_status){  

        // 상태를 재료에 추가
        System.out.println(food.getName()+"을(를)"+new_status+"하였습니다.");
        food.setStatus(new_status);
        this.action_point--;
        return true;
    }

    protected void cooking(Food food, String new_status, int cookingtime){
        Chef chef = new Chef();
        if(chef.checkOverlabStatus(food, new_status)){
            addStatus(food, new_status);
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