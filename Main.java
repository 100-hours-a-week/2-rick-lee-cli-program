import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //객체 선언
        CLIinterface menu = new CLIinterface();
        Chef headChef;               //셰프 객체

        //요리(다섯개의 재료들의 Set)
        Food[] dish = new Food[5];
        Food food = null;
        int dish_idx = 0;
        int score= 0;
        int MaxScore = 0;

        menu.startMenu();
        while (true) {
            headChef = new Chef();
            while(dish_idx < 5 && headChef.getActionPoint() > 0){    //재료를 5가지 조리하거나 행동포인트를 다쓰면 탈출
                System.out.println("    현재 행동 점수: "+ headChef.getActionPoint());
                System.out.println();

                food = menu.selectFood();
                if(food == null){                                     //선택 실패시 재료선택 화면으로 돌아감
                    if(menu.selectEnd()){
                        break;
                    }
                    continue;
                }
                while(!menu.selectPrep(headChef, food));

                //정상적으로 손질을 마쳤다면 요리에 추가
                dish[dish_idx] = food;
                dish_idx++;

            }
            //요리 채점
            score = menu.showDishScore(dish);
            if(score>MaxScore){
                MaxScore = score;
            }
            System.out.println();
            System.out.println("지금까지 최고점수: "+MaxScore);
            System.out.println();
        }
        
    }
}
