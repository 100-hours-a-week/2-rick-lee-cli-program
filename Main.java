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
        Set<Food> dish = new HashSet<>();
        Food food = null;

        menu.startMenu();
        while (true) {
            while(dish.size() < 5 && headChef.getActionPoint() > 0){    //재료를 5가지 조리하거나 행동포인트를 다쓰면 탈출
                System.out.println("현재 행동 점수: "+ headChef.getActionPoint());
                System.out.println();

                food = menu.selectFood();
                if(food == null){                        //선택 실패시 재료선택 화면으로 돌아감
                    continue;
                }
                while(!menu.selectPrep(headChef, food));

                
            }
            //정상적으로 손질을 마쳤다면 요리에 추가
            dish.add(food);
        }
        //요리 채점
    }
}
