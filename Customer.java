import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 요리된 재료들을 평가하는 클래스
 * 
 */

public class Customer {
    private int dishScore = 0;
    private ArrayList<String> reviews = new ArrayList<>();
    


    //재료 조합에 대한 가점 메서드
    private void addCombinationPoint(Food[] dish){
        
    }
    //중복 재료에 대한 감점 메서드
    private void minusCombinationPoint(Food[] dish){

    }
    //재료와 조리법에 대한 가점 메서드
    private void addRecipe(Food[] dish){

    }

    //재료와 조리법에 대한 감점 메서드
    private void minusRecipe(Food[] dish){

    }
    //재료의 익힘 정도에 대한 체점 메서드
    private void checkEven(){

    }
    //최종 체점 메서드
    public int scoreDish(Food[] dish){
        if(dish[0] == null){
            reviews.add("지금 장난 하시는 건가요?");
            return -100;
        }

        return dishScore;
    }
}