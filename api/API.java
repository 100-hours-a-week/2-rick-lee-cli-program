package api;
import backend.*;
import forntend.*;

public class API {
    private final int foodSelection = 9;            //재료 선택지 범위
    private final int vegeSeletion = 8;             //야채 손질 선택지 범위
    private final int meatSeletion = 8;             //고기 손질 선택지 범위
    private final int seafoodSelection = 8;         //해산물 손질 선택지 범위
    private final int cookingtimeSelection = 60;    //요리 시간 선택지 범위

    CLIinterface front = new CLIinterface();
    UserInteract server = new UserInteract();

    //입력의 유효성을 검사하는 메서드
    private boolean checkSelection(int input, int selectionNum){ //선택지 입력 유효성 검사
        if(input < -1 || input > selectionNum){
            return false;
        }
        return true;
    }

    //선택지 인터페이스호출, 요청을 server로 보냄
    public boolean selectFood(){
        int input = front.showFoodSelections();
        if(input == 0 || !checkSelection(input, foodSelection)){
            return false;
        }
        String food_name;
        switch (input) {
            case 1:
                food_name = "양파";
                break;
            case 2:
                food_name = "감자";
                break;
            case 3:
                food_name = "토마토";
                break;
            case 4:
                food_name = "돼지고기";
                break;
            case 5:
                food_name = "소고기";
                break;
            case 6:
                food_name = "닭고기";
                break;
            case 7:
                food_name = "연어";
                break;
            case 8:
                food_name = "참치";
                break;
            case 9:
                food_name = "가리비";
                break;
                
        }
        
        return false;
    }
}
