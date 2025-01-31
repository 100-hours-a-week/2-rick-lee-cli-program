import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
    
public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //객체 선언
        CLIinterface menu = new CLIinterface();
        Chef headChef = new Chef();               //셰프 객체
        Customer BackJongWon = new Customer();    //심사원 객체

        //요리(다섯개의 재료들의 Set)
        Set<Food> dish = new HashSet<>();
        Food food;

        menu.startMenu();
        while(dish.size() < 5 && headChef.getActionPoint() > 0){    //재료를 5가지 조리하거나 행동포인트를 다쓰면 탈출
            food = menu.selectFood();
            if(food == null){     //실패시 재료선택 화면으로 돌아감
                continue;
            }


        }

    }




}
