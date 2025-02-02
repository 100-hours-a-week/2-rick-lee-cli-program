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
    

    //getter
    protected ArrayList<String> getReviews(){return this.reviews;}
    protected int getDishScore(){return this.dishScore;}


    //재료 조합에 대한 가점 메서드
    private void addCombinationPoint(Food[] dish){
        
    }
    //중복 재료에 대한 감점 메서드
    private void minusCombinationPoint(Food[] dish){

    }
    //재료와 조리법에 대한 가점 메서드
    private void addRecipe(Food[] dish){
        boolean isGreat = false;
        int idx=0;
        while(dish[idx]!=null){
            Food food = dish[idx];
            String[] best_statusArr = food.getBestStatus();
            for(int i = 0; i<best_statusArr.length; i++){
                String best_status = best_statusArr[i];
                if(food.getStatus().contains(best_status)){
                    this.dishScore += 10;
                    isGreat = true;
                }
            }
            idx++;
        }
        if(isGreat){
            reviews.add("재료의 조리법이 훌륭하군요!");
        }
    }

    //재료와 조리법에 대한 감점 메서드
    private void minusRecipe(Food[] dish){
        boolean isBad = false;
        int idx=0;
        while(dish[idx]!=null){
            Food food = dish[idx];
            String[] worst_statusArr = food.getWorstStatus();
            for(int i = 0; i<worst_statusArr.length; i++){
                String worst_status = worst_statusArr[i];
                if(food.getStatus().contains(worst_status)){
                    this.dishScore -= 10;
                    isBad = true;
                }
            }
            idx++;
        }
        if(isBad){
            reviews.add("몇몇 재료의 조리법은 좀 아쉽네요..");
        }

    }
    //재료의 익힘 정도에 대한 체점 메서드
    private void checkEven(Food[] dish){
        int idx = 0;
        boolean isPerfect = false;
        boolean isGood = false;
        boolean isBad = false;
        boolean isWorst = false;

        while (dish[idx] == null) {
            Food food = dish[idx];
            if(food.getStatus().contains("회뜨기")){    //재료가 회뜨기상태면 pass
                continue;
            }
            int foodDgree = food.getHow_much_cooked();
            int topCutoff = food.getBest_dgree()[1];
            int bottomCutoff = food.getBest_dgree()[0];
            int range  = topCutoff - bottomCutoff;
            //가점 
            if(foodDgree>=bottomCutoff && foodDgree<=topCutoff){    //재료의 best_dgree에 맞으면 +20점
                this.dishScore += 30;
                isPerfect = true;
            }
            else if(foodDgree>=(bottomCutoff-range*0.3) && foodDgree<=(topCutoff+range*0.3)){   //익힘정도가 오차범위 30%이내면 +10점
                this.dishScore += 20;
                isGood = true;
            }
            //감점
            else if(foodDgree<(bottomCutoff-range*5) || foodDgree>(topCutoff+range*5)){   //익힘정도가 오차범위 500%밖이면 -30점
                this.dishScore -= 30;
                isBad = true;
            }
            else if(foodDgree<(bottomCutoff-range*2) || foodDgree>(topCutoff+range*2)){   //익힘정도가 오차범위 200%밖이면 -10점
                this.dishScore -= 10;
                isWorst = true;
            }
        }

        if(isPerfect){
            reviews.add("특정 재료가 Even하게 익었네요, 완벽합니다!");
        }
        if(isGood){
            reviews.add("재료의 익힘정도도 나쁘지 않네요");
        }
        if(isBad){
            reviews.add("몇 재료의 익힘정도가 아쉽네요");
        }
        if(isWorst){
            reviews.add("몇 재료의 익힘정도가 끔찍하네요");
        }

    }
    //최종 체점 메서드
    public void gradingDish(Food[] dish){
        if(dish[0] == null){
            reviews.add("지금 장난하시는 건가요?");
            this.dishScore = -100;
            return;
        }

        addRecipe(dish);
        minusRecipe(dish);

    }
}