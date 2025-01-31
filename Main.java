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
        Food food;

        //입력값
        int input;

        menu.startMenu();
        while (true) {
            while(dish.size() < 5 && headChef.getActionPoint() > 0){    //재료를 5가지 조리하거나 행동포인트를 다쓰면 탈출
                System.out.println("현재 행동 점수: "+ headChef.getActionPoint());
                System.out.println();

                food = null;
                menu.showFoodSelections();
                input = sc.nextInt();
                if(input == 0){
                    System.out.println("    요리를 끝냅니다");
                    break;
                }
                if(!menu.checkFoodSelection(input)){     //값이 유효하지 않으면 다시 시작
                    System.out.println("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
                    menu.makeLine();
                    continue;
                }

                food = menu.selectFood(input);
                if(food == null){                        //선택 실패시 재료선택 화면으로 돌아감
                    continue;
                }
    
                if(food.getType().equals("vege")){    //재료가 야채라면 야채선택지 실행
                    if(!menu.selectVegePrep(headChef, food)){  //재료를 손질실패하면 다시 시작
                        continue;
                    }
                }
                else if(food.getType().equals("meet")){
                    if(!menu.selectVegePrep(headChef, food)){ 
                        continue;
                    }
                }
                //정상적으로 손질을 마쳤다면 요리에 추가
                dish.add(food);
                
    
    
            }
            //요리 채점
        }
        

    }




}
