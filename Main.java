import java.util.Scanner;
    
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //객체 선언
        Main main = new Main();
        CLIinterface menu = new CLIinterface();
        Chef headChef = new Chef();               //셰프 객체
        Customer BackJongWon = new Customer();    //심사원 객체

        //시스템 사용값
        Food[] foods = new Food[5]; //고른 재료를 저장
        int foods_idx=0;            //재료를 몇개 저장했는지 

        while(foods_idx < 5){                               //재료를 5가지 조리하면 탈출

            if(main.selectFood(foods, foods_idx)){
                System.out.println(foods[foods_idx].getName()+"를 고르셨습니다");
            }
            else{                                           //실패시 초기화면으로 돌아감
                System.out.println("잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
                break;
            }

            while(headChef.getActionPoint() > 0){          //행동포인트 소진or재료손질 종료시 탈출
                if(foods[foods_idx].getType().equals("Vegetable")){
                    if(main.cookVege(headChef, foods[foods_idx])){

                    }
                    else{
                        System.out.println("재료 선택 화면으로 돌아갑니다.");
                        break;
                    }
                }
                else if(foods[foods_idx].getType().equals("Meet")){
                    //if(main.selectMeetPrep(headChef, foods[foods_idx]))
                }

                foods_idx++;    //재료 손질을 완료하면 food인덱스+1
            }

        }

    }

    /**selectFood
     * 
     * @param foodNum
     * @return Food
     */
    public boolean selectFood(Food[] foods, int foods_idx){
        System.out.println("재료를 골라 주세요");
        System.out.println("1. 양파  2. 돼지 고기");
        int input = sc.nextInt();
        if(input < 1 || input > 2){
            System.out.println("잘못된 입력입니다. 다시 골라주세요");
            return false;
        }
        switch (input) {
            case 1:
                foods[foods_idx] = new Onion();
                return true;
            case 2:
                foods[foods_idx] = new Pork();
                return true;
        
            default:
                break;
        }
        return false;
    }

    /**selectVegePrep
     * 선택된 재료 타입이 야채이면 나오는
     * 손질 선택 인터페이스
     * @param input
     * @return
     */
    public boolean cookVege(Chef headChef, Food food){

        System.out.println("요리 방법을 골라 주세요");
        System.out.println("1. 채썰기  2. 깍뚝썰기  3. 다지기  4. 갈기");
        System.out.println("5. 볶기    6. 삶기      7. 찌기    8. 냅두기");
        int input = sc.nextInt();
        if(input < 1 || input > 8){ //유효성 검사
            System.out.println("잘못된 입력입니다. 재료 선택으로 돌아갑니다");
            return false;
        }

        if(input > 0 && input < 5 ){ //isCuted를 건드리는 선택지들
            String satus = "";
            switch (input) {
                case 1:
                    satus = "fine_cut";
                    break;
                case 2:
                    satus = "dies_cut";
                    break;
                case 3:
                    satus = "crushed";
                    break;
                case 4:
                    satus = "grinded";
                    break;
                default:
                    return false;
            }
            if(headChef.checkCuted(food, satus)&&headChef.checkOverlabStatus(food, satus)){
                headChef.addStatus(food, satus);
            }
            else{
                return false;
            }
        }
        else if(input > 4 && input < 8 ){ //요리하는 선택지들
            String satus = "";
            switch (input) {
                case 5:
                    satus = "roasted";
                    break;
                case 6:
                    satus = "boiled";
                    break;
                case 7:
                    satus = "steamed";
                    break;
                default:
                    return false;
            }
            if(headChef.checkOverlabStatus(food, satus)){
                int cookingtime;
                cookingtime = sc.nextInt();
                headChef.cooking(food, satus, cookingtime);
            }
            else{
                return false;
            }
        }
        else if(input ==8){
            System.out.println(food.getName()+"을 그대로 둡니다");
            return true;
        }
        return false;
    }




}
