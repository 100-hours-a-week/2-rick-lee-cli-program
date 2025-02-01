import java.util.Scanner;
import java.util.Set;

public class CLIinterface {
    Scanner sc = new Scanner(System.in);

    private final int foodSelection = 9;    //재료 선택지 수
    private final int vegeSeletion = 8;     //야채 손질 선택지 수
    private final int meatSeletion = 8;
    private final int seafoodSelection = 8;
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
        System.out.println("    1. 양파      2. 감자    3. 토마토");
        System.out.println("    4. 돼지고기  5. 소고기  6. 닭고기");
        System.out.println("    7. 연어      8. 참치    9. 가리비");
        System.out.println();
        System.out.print("    입력값: ");
    }

    private void showVegeSelection(){
        System.out.println("    요리 방법을 골라 주세요");
        System.out.println("    1. 채썰기    2. 깍뚝썰기    3. 다지기    4. 갈기");
        System.out.println("    5. 볶기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.print("    입력값: ");
    }

    private void showMeatSelection(){
        System.out.println("    요리 방법을 골라 주세요");
        System.out.println("    1. 밑간하기    2.망치질하기     3. 다지기    4. 깍뚝썰기");
        System.out.println("    5. 굽기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.print("    입력값: ");
    }

    private void showSeafoodSelection(){
        System.out.println("    요리 방법을 골라 주세요");
        System.out.println("    1. 밑간하기    2.비늘벗기기     3. 회뜨기    4. 깍뚝썰기");
        System.out.println("    5. 굽기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.print("    입력값: ");
    }

    private void showCookingTime(){
        System.out.println("    요리 시간을 설정해 주세요");
        System.out.println("    시간 단위는 분이며, 0부터 60가지 설정할 수 있습니다");
        System.out.print("    입력값: ");
    }


    //입력의 유효성을 검사하는 메서드
    private boolean checkSelection(int input, int selectionNum){ //선택지 입력 유효성 검사
        if(input < -1 || input > selectionNum){
            return false;
        }
        return true;
    }


    //선택지 인터페이스들
    public Food selectFood(){
        showFoodSelections();
        int input = sc.nextInt();
        if(input == 0 || !checkSelection(input, foodSelection)){
            System.out.println();
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
                System.out.println("    감자를 고르셨습니다");
                return new Potato();
            case 3:
                System.out.println("    토마토를 고르셨습니다");
                return new Tomato();
            case 4:
                System.out.println("    돼지고기를 고르셨습니다");
                return new Pork();
            case 5:
                System.out.println("    소고기를 고르셨습니다");
                return new Beef();
            case 6:
                System.out.println("    닭고기를 고르셨습니다");
                return new Chicken();
            case 7:
                System.out.println("    연어를 고르셨습니다");
                return new Salmon();
            case 8:
                System.out.println("    참치를 고르셨습니다");
                return new Tuna();
            case 9:
                System.out.println("    가리비를 고르셨습니다");
                return new Scallops();
                
        }
        makeLine();
        return null;
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
                return "망치질하기";
            case 3:
                return "다지기";
            case 4:
                return "깍뚝썰기";
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
    private String choiceSeafoodPreps(int input){
        switch (input) {
            case 1:
                return "밑간하기";
            case 2:
                return "비늘 벗기기";
            case 3:
                return "회뜨기";
            case 4:
                return "깍뚝썰기";
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

    private int selectCookingtime(){
        showCookingTime();
        int cookingtime = sc.nextInt();
        makeLine();

        if(!checkSelection(cookingtime, cookingtimeSelection)){
            return -1;
        }
        return cookingtime;
    }

    public boolean selectEnd(){
        System.out.println("   이대로 요리를 끝내시겠습니까?");
        System.out.println("   1. 예    2. 아니오");
        System.out.println();
        System.out.print("    입력값:");
        int input = sc.nextInt();
        if(input == 1){
            System.out.println();
            System.out.println("    요리를 종료하고 심사위언의 평가를 받습니다...");
            System.out.println();
            makeLine();
            return true;
        }
        else if(input == 2){
            System.out.println("    요리를 계속합니다. 재료선택 화면으로 돌아갑니다");
            System.out.println();
            makeLine();
            return false;
        }
        else{
            System.out.println("    잘못된 입력입니다. 자동으로 다음으로 넘어갑니다");
            System.out.println();
            makeLine();
            return false;
        }
    }
    //재료 손질 선택
    public boolean selectPrep(Chef headChef, Food food){
        int input=0;
        String new_satus = "";

        if(food.getType().equals("vege")){
            showVegeSelection();
            input = sc.nextInt();
            if(input == 0){              //내비둠을 선택
                System.out.println("    "+food.getName()+"을 그대로 둡니다");
                return true;
            }
            if(!checkSelection(input, vegeSeletion)){ //입력값 유효성 검사
                System.out.println("    잘못된 선택입니다."+food.getName()+" 손질 화면으로 돌아갑니다");
                makeLine();
                return false;
            }
            new_satus=choiceVegePreps(input);
        }
        else if(food.getType().equals("meat")){
            showMeatSelection();            
            input = sc.nextInt();
            if(input == 0){
                System.out.println("    "+food.getName()+"을 그대로 둡니다");
                return true;
            }
            if(!checkSelection(input, meatSeletion)){ 
                System.out.println("    잘못된 선택입니다."+food.getName()+" 손질 화면으로 돌아갑니다");
                makeLine();
                return false;
            }
            new_satus=choiceMeatPreps(input);
        }
        else if(food.getType().equals("seafood")){
            showSeafoodSelection();            
            input = sc.nextInt();
            if(input == 0){
                System.out.println("    "+food.getName()+"을 그대로 둡니다");
                return true;
            }
            if(!checkSelection(input, seafoodSelection)){ 
                System.out.println("    잘못된 선택입니다."+food.getName()+" 손질 화면으로 돌아갑니다");
                makeLine();
                return false;
            }
            new_satus=choiceSeafoodPreps(input);
        }
        

        if(input>0 && input<5){     //요리시간을 안쓰는 선택지들
            if(!headChef.cooking(food, new_satus)){
                System.out.println("    "+new_satus+"는 이미 된 상태입니다."+food.getName()+" 손질 화면으로 돌아갑니다");
                makeLine();
                return false;
            }
        }
        
        else if(input>4 && input<8){    //요리시간을 쓰는 요리들
            int cookingtime;
            cookingtime = selectCookingtime();
            if(cookingtime == -1){       //요리 시간이 유효하지 않음
                System.out.println("   유효하지 않은 요리 시간 입니다." + food.getName()+ " 손질 화면으로 돌아갑니다");
                makeLine();
                makeLine();
                return false;
            }
            if(!headChef.cooking(food, new_satus, cookingtime)){
                System.out.println("    "+new_satus+"는 이미 된 상태입니다" + food.getName()+ " 손질 화면으로 돌아갑니다");
                makeLine();
                return false;
            }
        }
        System.out.println("    "+food.getName()+"을(를)성공적으로 "+new_satus+"했습니다");
        System.out.println();
        System.out.println("    재료를 추가 손질 하시겠습니까?");
        System.out.println("    1. 예    2. 아니오");
        System.out.println();
        System.out.print("    입력값: ");
        input = sc.nextInt();
        if(input == 1){
            System.out.println("    "+food.getName()+"을(를) 추가 손질 합니다");
            makeLine();
            return false;
        }
        else if(input == 2){
            System.out.println("    "+food.getName()+" 손질을 그만 둡니다");
            makeLine();
            return true;
        }
        System.out.println("    잘못된 선택입니다."+food.getName()+" 손질 화면으로 돌아갑니다");
        makeLine();
        return false;
    }
}
