import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
    
public class Main {

    public static void main(String[] args) {
        //객체 선언
        Scanner sc = new Scanner(System.in);
        CLIinterface menu = new CLIinterface();
        Chef headChef = new Chef();               //셰프 객체
        Customer BackJongWon = new Customer();    //심사원 객체

        //요리(다섯개의 재료들의 Set)
        Food[] dish = new Food[5];
        Food food = null;
        int dish_idx = 0;
        int score= 0;
        int MaxScore = 0;

        menu.startMenu();
        while (true) {
            while(dish_idx < 5 && headChef.getActionPoint() > 0){    //재료를 5가지 조리하거나 행동포인트를 다쓰면 탈출
                System.out.println("현재 행동 점수: "+ headChef.getActionPoint());
                System.out.println();

                food = menu.selectFood();
                if(food == null){                        //선택 실패시 재료선택 화면으로 돌아감
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
            score = BackJongWon.scoreDish(dish);
            System.out.println("최종점수: "+score);
            if(score>MaxScore){
                MaxScore = score;
            }
            System.out.println();
            System.out.println("지금까지 최고점수: "+MaxScore);
        }
        
    }
}
