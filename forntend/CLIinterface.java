package forntend;
import java.util.Scanner;
import java.util.Set;

import backend.Chef;
import backend.Customer;
import backend.Food;
import backend.database.meat.Beef;
import backend.database.meat.Chicken;
import backend.database.meat.Pork;
import backend.database.seafood.Salmon;
import backend.database.seafood.Scallops;
import backend.database.seafood.Tuna;
import backend.database.vegetable.Onion;
import backend.database.vegetable.Potato;
import backend.database.vegetable.Tomato;

public class CLIinterface {
    Scanner sc = new Scanner(System.in);


    public void print(String input){
        System.out.println("    "+input);
    }
    public void print(String[] inputs){
        for(String input : inputs)
            System.out.println("    "+input);
    }
    public void makeLine(){
        System.out.println();
        System.out.println("  ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
    }
    private void showSelectedresult(String input){
        print(input+"을 고르셨습니다");
    }

    //선택지를 보여주는 메서드들
    public void startMenu(){
        makeLine();
        print("Hyup's Kitchen에 오신 것을 환영합니다!");
        print("당신은 이제 요리사가 되어, 여러 재료들을 이용하여");
        print("하나의 요리를 완성해야 합니다");
        System.out.println();
        System.out.println();
        print("완성된 요리는 심사위원에게 평가받아 점수를 얻습니다");
        print("요리를 완성하여 최고 점수를 노려보세요!");
        makeLine();
        print("    ※ 게임 규칙 ※");
        System.out.println();
        print("    재료는 총 5가지 선택할 수 있으며,");
        print("    당신은 10개의 행동포인트를 가지고 시작합니다");
        print("    각 재료들을 손질하거나 요리할 때마다 행동포인트가 차감됩니다");
        print("    (단, 재료를 내버려두는 선택지는 행동포인트를 소모하지 않습니다)");
        System.out.println();
        print("    행동 포인트를 전략적으로 사용하여 최고의 요리를 만들어 보세요!");
        makeLine();
    }

    public void showFoodSelectionDenied(){
        print("    잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
        makeLine();
    }

    public int showFoodSelections(){
        int input;
        print("재료를 골라 주세요");
        print("1. 양파      2. 감자    3. 토마토");
        print("4. 돼지고기  5. 소고기  6. 닭고기");
        print("7. 연어      8. 참치    9. 가리비    0.요리 끝내기");
        System.out.println();
        print("입력값: ");
        input = sc.nextInt();
        makeLine();
        return input;
    }

    private int showVegeSelection(){
        int input;
        print("요리 방법을 골라 주세요");
        print("1. 채썰기    2. 깍뚝썰기    3. 다지기    4. 갈기");
        print("5. 볶기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.println();
        System.out.print("    입력값: ");
        input = sc.nextInt();
        return input;
    }

    private int showMeatSelection(){
        int input;
        print("요리 방법을 골라 주세요");
        print("1. 밑간하기    2.망치질하기     3. 다지기    4. 깍뚝썰기");
        print("5. 굽기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.println();
        print("입력값: ");
        input = sc.nextInt();
        return input;
    }

    private int showSeafoodSelection(){
        int input;
        print("요리 방법을 골라 주세요");
        print("1. 밑간하기    2.비늘벗기기     3. 회뜨기    4. 깍뚝썰기");
        print("5. 굽기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.println();
        System.out.print("    입력값: ");
        input = sc.nextInt();
        return input;
    }

    private int showCookingTime(){
        int input;
        System.out.println("    요리 시간을 설정해 주세요");
        System.out.println("    시간 단위는 분이며, 0부터 60가지 설정할 수 있습니다");
        System.out.println();
        System.out.print("    입력값: ");
        input = sc.nextInt();
        return input;
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
        
        else if(input>4 && input<9){    //요리시간을 쓰는 요리들
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

    //최종 결과를 출력하는 메서드
    public int showDishScore(Food[] dish){
        Customer BackJongWon = new Customer();
        BackJongWon.gradingDish(dish);

        System.out.println();
        System.out.println("     ◆심사위원의 총평◆");
        System.out.println();
        for(String review : BackJongWon.getReviews()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("    "+review);
        }
        System.out.println();
        System.out.println("    최종점수: "+BackJongWon.getDishScore());
        makeLine();
        return BackJongWon.getDishScore();
    }
}
