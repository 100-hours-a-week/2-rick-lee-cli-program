package backend.database.seafood;

import backend.Food;

public class Seafood extends Food{
    public Seafood(){
        this.type = "seafood";
        this.best_dgree = new int[2];
        this.best_status = new String[]{"회뜨기", "삶기"};
        
    }
}
