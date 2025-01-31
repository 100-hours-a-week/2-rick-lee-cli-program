import java.util.Scanner;
import java.util.Set;

public class CLIinterface {
    Scanner sc = new Scanner(System.in);

    private final int foodSelection = 2;    //재료 선택지 수
    private final int vegeSeletion = 2;     //야채 손질 선택지 수
    private final int meetSeletion = 2;


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
    
    private boolean checkFoodSelection(int input){
        if(input < 1 || input > foodSelection){
            return false;
        }
        return true;
    }

    /**selectFood
     * 
     * @param foodNum
     * @return Food
     */
    public Food selectFood(){
        System.out.println("    재료를 골라 주세요");
        System.out.println("    1. 양파    2. 돼지 고기");
        System.out.println();
        System.out.print("  입력값: ");
        int input = sc.nextInt();
        makeLine();
        
        if(!checkFoodSelection(input)){     //값이 유효하지 않으면
            System.out.println("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
            makeLine();
            return null;
        }
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

    private boolean checkVegeSelection(int input){
        if(input < 1 || input > vegeSeletion){
            return false;
        }
        return true;
    }

    /**selectVegePrep
     * 선택된 재료 타입이 야채이면 나오는
     * 손질 선택 인터페이스
     * @param input
     * @return
     */
    public boolean cookVege(Chef headChef, Food food){

        System.out.println("    요리 방법을 골라 주세요");
        System.out.println("    1. 채썰기    2. 깍뚝썰기    3. 다지기    4. 갈기");
        System.out.println("    5. 볶기      6. 삶기       7. 찌기      8. 냅두기");
        System.out.print("    입력값: ");
        int input = sc.nextInt();
        if(!checkVegeSelection(input)){ //입력값 유효성 검사
            System.out.println("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
            makeLine();
            return false;
        }

        String new_satus = "";
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
                break;
            case 6:
                new_satus = "삶기";
                break;
            case 7:
                new_satus = "찌기";
                break;
            case 8:
                System.out.println("    "+food.getName()+"을 그대로 둡니다");
                return true;
            default:
                System.out.println("    시스템 에러, 재료선택화면으로 돌아갑니다");
                makeLine();
                return false;
            }
        if(!headChef.addStatus(food, new_satus)){
            System.out.println("    재료 화면으로 돌아갑니다");
        }
        makeLine();
        return false;
    }
}
