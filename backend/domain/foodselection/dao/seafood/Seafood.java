package backend.domain.foodselection.dao.seafood;

import backend.domain.foodselection.Food;

public class Seafood extends Food{
    public Seafood(){
        this.type = "seafood";
        this.best_dgree = new int[2];
        this.best_status = new String[]{"회뜨기", "삶기"};
        
    }
}
