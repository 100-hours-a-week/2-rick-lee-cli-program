package common.util;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;


/*
 * 사용자에게 선택지를 보여주고 
 * 입력값을 받는 클래스
 */
public class CLIinterface {
    Scanner sc = new Scanner(System.in);

    public void println(String input){
        System.out.println("    "+input);
    }
    public void print(String input){
        System.out.print("    "+input);
    }

    public void makeLine(){
        System.out.println();
        System.out.println("  ――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
    }

    //선택지를 보여주는 메서드들
    public void showTutorial(){
        makeLine();
        println("Hyup's Kitchen에 오신 것을 환영합니다!");
        println("당신은 이제 요리사가 되어, 여러 재료들을 이용하여");
        println("하나의 요리를 완성해야 합니다");
        System.out.println();
        System.out.println();
        println("완성된 요리는 심사위원에게 평가받아 점수를 얻습니다");
        println("요리를 완성하여 최고 점수를 노려보세요!");
        makeLine();
        println("    ※ 게임 규칙 ※");
        System.out.println();
        println("    재료는 총 5가지 선택할 수 있으며,");
        println("    당신은 10개의 행동포인트를 가지고 시작합니다");
        println("    각 재료들을 손질하거나 요리할 때마다 행동포인트가 차감됩니다");
        println("    (단, 재료를 내버려두는 선택지는 행동포인트를 소모하지 않습니다)");
        System.out.println();
        println("    행동 포인트를 전략적으로 사용하여 최고의 요리를 만들어 보세요!");
        makeLine();
    }




    //재료 타입에 따른 손질 선택지를 보여주는 메서드들
    protected int getVegeSelection(){
        int input;
        println("요리 방법을 골라 주세요");
        println("1. 채썰기    2. 깍뚝썰기    3. 다지기    4. 갈기");
        println("5. 볶기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.println();
        System.out.print("    입력값: ");
        input = sc.nextInt();
        return input;
    }

    protected int getMeatSelection(){
        int input;
        println("요리 방법을 골라 주세요");
        println("1. 밑간하기    2.망치질하기     3. 다지기    4. 깍뚝썰기");
        println("5. 굽기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.println();
        print("입력값: ");
        input = sc.nextInt();
        return input;
    }

    protected int getSeafoodSelection(){
        int input;
        println("요리 방법을 골라 주세요");
        println("1. 밑간하기    2.비늘벗기기     3. 회뜨기    4. 깍뚝썰기");
        println("5. 굽기      6. 삶기       7. 찌기      8. 튀기기    0. 냅두기");
        System.out.println();
        print("입력값: ");
        input = sc.nextInt();
        return input;
    }

    protected void showCurrentFood(String foodName){
        println(foodName+"을(를) 손질합니다");
        makeLine();
    }

    protected void showActionPoint(int actionPoint){
        println("현재 행동 점수: "+actionPoint);
        System.out.println();
    }

    protected void showSatusDenied(){
        println("잘못된 선택입니다. 재료손질화면으로 돌아갑니다");
        makeLine();
    }

    protected void showDoubleStatus(String status){
        println("이미"+status+"된 재료입니다. 재료손질화면으로 돌아갑니다");
        makeLine();
    }

    protected void showStatusSucess(String foodName, String status){
        println(foodName+"을 성공적으로 "+status+"하였습니다.");
        makeLine();
    }

    protected int getCookingTime(){
        int input;
        println("요리 시간을 설정해 주세요");
        println("시간 단위는 분이며, 0부터 60가지 설정할 수 있습니다");
        System.out.println();
        print("입력값: ");
        input = sc.nextInt();
        makeLine();
        return input;
    }

    protected int getKeepPrep(){
        println("재료를 추가 손질 하시겠습니까?");
        println("1. 예    2. 아니오");
        println("");
        print("입력값: ");
        int input = sc.nextInt();
        makeLine();
        return input;
    }

    protected void showKeepPrepDined(){
        println("잘못된 선택지 입니다. 다시 골라 주십시오");
        makeLine();
    }

    protected int getEndSelection(){
        print("이대로 요리를 끝내시겠습니까?");
        print("   1. 예    2. 아니오");
        System.out.println();
        print("입력값:");
        int input = sc.nextInt();
        makeLine();
        return input;
    }

    protected void showEndSucess(){
        print("요리를 종료하고 심사위언의 평가를 받습니다...");
        makeLine();
    }

    protected void showEnd(){
        print("");
    }

    protected void showEndDenied(){
        print("잘못된 입력입니다. 자동으로 재료선택 화면으로 넘어갑니다");
    }


    //최종 결과를 출력하는 메서드
    public void showDishScore(ArrayList<String> reveiws){
        println(" ◆심사위원의 총평◆");
        System.out.println();
        for(String review : reveiws){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println(review);
        }
        makeLine();
    }
}
