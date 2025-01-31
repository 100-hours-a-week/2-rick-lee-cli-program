import java.util.Scanner;
import java.util.Set;

public class CLIinterface {
    Scanner sc = new Scanner(System.in);

    private final int foodSelection = 2;    //재료 선택지 수
    private final int vegeSeletion = 8;     //야채 손질 선택지 수
    private final int meetSeletion = 8;

    public void startMenu(){
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
        System.out.println("    Hyup's Kitchen에 오신 것을 환영합니다!");
        System.out.println("    당신은 이제 요리사가 되어, 여러 재료들을 이용하여");
        System.out.println("    하나의 요리를 완성해야 합니다");
        System.out.println();
        System.out.println();
        System.out.println("    완성된 요리는 심사위원에게 평가받아 점수를 얻습니다");
        System.out.println("    요리를 완성하여 최고 점수를 노려보세요!");
        System.out.println();
        System.out.println("  ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
        System.out.println("    ※ 게임 규칙 ※");
        System.out.println();
        System.out.println("    재료는 총 5가지 선택할 수 있으며,");
        System.out.println("    당신은 10개의 행동포인트를 가지고 시작합니다");
        System.out.println("    각 재료들을 손질하거나 요리할 때마다 행동포인트가 차감됩니다");
        System.out.println("    (단, 재료를 내버려두는 선택지는 행동포인트를 소모하지 않습니다)");
        System.out.println();
        System.out.println("    행동 포인트를 전략적으로 사용하여 최고의 요리를 만들어 보세요!");
        System.out.println();
        System.out.println("  ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
    }

    public void makeLine(){
        System.out.println();
        System.out.println("  ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
    }
    

    public void showFoodSelections(){
        System.out.println("    재료를 골라 주세요");
        System.out.println("    1. 양파    2. 돼지 고기");
        System.out.println();
        System.out.print("  입력값: ");
    }
    public boolean checkFoodSelection(int input){
        if(input < 1 || input > foodSelection){
            return false;
        }
        return true;
    }
    /**selectFood
     * 
     * @param input
     * @return Food
     */
    public Food selectFood(int input){
        if(checkFoodSelection(input))
        makeLine();
        switch (input) {
            case 1:
                System.out.println("    양파를 고르셨습니다");
                return new Onion();
            case 2:
                System.out.println("    돼지고기를 고르셨습니다");
                return new Pork();
            default:
                System.out.println("    시스템 에러, 재료선택화면으로 돌아갑니다");
                makeLine();
        }
        return null;
    }


    private void showVegeSelecton(){
        System.out.println("    요리 방법을 골라 주세요");
        System.out.println("    1. 채썰기    2. 깍뚝썰기    3. 다지기    4. 갈기");
        System.out.println("    5. 볶기      6. 삶기       7. 찌기      8. 냅두기");
        System.out.print("    입력값: ");
    }

    private boolean checkVegeSelection(int input){
        if(input < 1 || input > vegeSeletion){
            return false;
        }
        return true;
    }
    private int checkCookingTime(){
        int cookingtime;
        System.out.println("    요리 시간을 설정해 주세요");
        System.out.println("    시간 단위는 분이며, 0부터 60가지 설정할 수 있습니다");
        System.out.print("    입력값: ");
        cookingtime = sc.nextInt();
        makeLine();

        if(cookingtime < 0 || cookingtime > 60){

            return -1;
        }
        return cookingtime;

    }
    /**selectVegePrep
     * 선택된 재료 타입이 야채이면 나오는
     * 손질 선택 인터페이스
     * @param Chef, Food
     * @return 
     */
    public boolean selectVegePrep(Chef headChef, Food food){
        showVegeSelecton();
        int input = sc.nextInt();
        if(!checkVegeSelection(input)){ //입력값 유효성 검사
            System.out.println("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
            makeLine();
            return false;
        }

        String new_satus = "";
        int cookingtime = -2;
        switch (input) {
            case 1:
                new_satus = "채썰기";
                break;
            case 2:
                new_satus = "깍뚝썰기";
                break;
            case 3:
                new_satus = "다지기";
                break;
            case 4:
                new_satus = "갈기";
                break;
            case 5:
                new_satus = "굽기";
                cookingtime = checkCookingTime();
                break;
            case 6:
                new_satus = "삶기";
                cookingtime = checkCookingTime();
                break;
            case 7:
                new_satus = "찌기";
                cookingtime = checkCookingTime();
                break;
            case 8:
                System.out.println("    "+food.getName()+"을 그대로 둡니다");
                return true;
            }
        if(cookingtime == -1){       //요리 시간이 유효하지 않음
            System.out.println("   유효하지 않은 요리 시간 입니다. 재료 화면으로 돌아갑니다");
            makeLine();
            return false;
        }
        else if(cookingtime == -2){  //요리 시간을 필요로 하지 않는 요리
            if(!headChef.cooking(food, new_satus)){
                System.out.println("    "+new_satus+"는 이미 된 상태입니다. 재료선택화면으로 돌아갑니다");
                makeLine();
                return false;
            }
        }
        else if(cookingtime > 0){
            if(!headChef.cooking(food, new_satus, cookingtime)){
                System.out.println("    "+new_satus+"는 이미 된 상태입니다. 재료선택화면으로 돌아갑니다");
                makeLine();
                return false;
            }
        }
        System.out.println("    "+food.getName()+"을(를)성공적으로 "+new_satus+"했습니다");
        makeLine();
        return true;
    }
}
