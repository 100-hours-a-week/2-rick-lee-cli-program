package forntend.domain.selectfood.controller;

import java.util.Scanner;
import common.util.CLIinterface;
import forntend.API;
import common.util.RequestSoket;

public class FoodController extends API{

    private final int foodSelection = 9;
    Scanner sc = new Scanner(System.in);
    CLIinterface viewer = new CLIinterface();
    String requestType = "FoodSelect";


    private void showFoodSelecion(){
        viewer.println("재료를 골라 주세요");
        viewer.println("1. 양파      2. 감자    3. 토마토");
        viewer.println("4. 돼지고기  5. 소고기  6. 닭고기");
        viewer.println("7. 연어      8. 참치    9. 가리비");
        System.out.println();
    }

    private void showFoodDenied(){
        viewer.println("잘못된 선택입니다. 재료선택화면으로 돌아갑니다");
        viewer.makeLine();
    }

    //선택지 인터페이스호출, 선택된 재료 요청을 server로 보냄
    protected boolean selectFood(){
        showFoodSelecion();
        viewer.print("입력값: ");
        int input = sc.nextInt();
        viewer.makeLine();
        if(!checkSelection(input, foodSelection)){
            showFoodDenied();
            return false;
        }
        //입력값을 요청
        RequestSoket request = new RequestSoket(requestType, input);
        requestMessage(request);
        return true;
    }
}
