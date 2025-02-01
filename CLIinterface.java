import java.util.Scanner;
import java.util.Set;

public class CLIinterface {
    Scanner sc = new Scanner(System.in);

    private final int foodSelection = 2;    //재료 선택지 수
    private final int vegeSeletion = 8;     //야채 손질 선택지 수
    private final int meatSeletion = 8;
    private final int cookingtimeSelection = 60;


    //선택지를 보여주는 메서드들
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

    private void showVegeSelecton(){
        System.out.println("    요리 방법을 골라 주세요");
        System.out.println("    1. 채썰기    2. 깍뚝썰기    3. 다지기    4. 갈기");
        System.out.println("    5. 볶기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.print("    입력값: ");
    }

    private void showMeatSelecton(){
        System.out.println("    요리 방법을 골라 주세요");
        System.out.println("    1. 밑간하기    2. 깍뚝썰기    3. 다지기    4. 갈기");
        System.out.println("    5. 굽기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.print("    입력값: ");
    }

    private void showCookingTime(){
        System.out.println("    요리 시간을 설정해 주세요");
        System.out.println("    시간 단위는 분이며, 1부터 60가지 설정할 수 있습니다");
        System.out.print("    입력값: ");
    }


    //입력의 유효성을 검사하는 메서드
    private boolean checkSelection(int input, int selectionNum){ //선택지 입력 유효성 검사
        if(input < 0 || input > selectionNum){
            return false;
        }
        return true;
    }


    //선택지 인터페이스들
    public Food selectFood(){
        showFoodSelections();
        int input = sc.nextInt();
        if(!checkSelection(input, foodSelection)){
            System.out.println("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
            makeLine();
            return null;
        }
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
    private int selectCookingtime(){
        showCookingTime();
        int cookingtime = sc.nextInt();
        makeLine();

        if(!checkSelection(cookingtime, cookingtimeSelection)){
            return -1;
        }
        return cookingtime;
    }

    private String choiceVegePreps(int input){
        switch (input) {
            case 1:
                return "채썰기";
            case 2:
                return "깍뚝썰기";
            case 3:
                return "다지기";
            case 4:
                return "갈기";
            case 5:
                return "굽기";
            case 6:
                return "삶기";
            case 7:
                return "찌기";
            case 8:
                return "튀기기";
            }
            return "";
    }

    private String choiceMeatPreps(int input){
        switch (input) {
            case 1:
                return "밑간하기";
            case 2:
                return "깍뚝썰기";
            case 3:
                return "다지기";
            case 4:
                return "갈기";
            case 5:
                return "굽기";
            case 6:
                return "삶기";
            case 7:
                return "찌기";
            case 8:
                return "튀기기";
            }
            return "";
    }

    public boolean selectPrep(Chef headChef, Food food){
        int input = sc.nextInt();
        if(input == 0){              //내비둠을 선택
            System.out.println("    "+food.getName()+"을 그대로 둡니다");
            return true;
        }

        String new_satus = "";
        if(food.getType().equals("vege")){
            showVegeSelecton();
            if(!checkSelection(input, vegeSeletion)){ //입력값 유효성 검사
                System.out.println("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
                makeLine();
                return false;
            }
            new_satus=choiceVegePreps(input);
        }
        else if(food.getType().equals("meat")){
            showMeatSelecton();
            if(!checkSelection(input, meatSeletion)){ //입력값 유효성 검사
                System.out.println("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
                makeLine();
                return false;
            }
            new_satus=choiceMeatPreps(input);
        }
        

        if(input>0 && input<5){     //요리시간을 안쓰는 선택지들
            if(!headChef.cooking(food, new_satus)){
                System.out.println("    "+new_satus+"는 이미 된 상태입니다. 재료선택화면으로 돌아갑니다");
                makeLine();
                return false;
            }
        }
        
        else if(input>4 && input<8){    //요리시간을 쓰는 요리들
            int cookingtime;
            cookingtime = selectCookingtime();
            if(cookingtime == -1){       //요리 시간이 유효하지 않음
                System.out.println("   유효하지 않은 요리 시간 입니다. 재료 화면으로 돌아갑니다");
                makeLine();
                return false;
            }
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
