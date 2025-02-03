package backend.database.vegetable;

import backend.Food;

public class Vegetable extends Food{
    Vegetable(){
        this.type = "vege";
        this.best_dgree = new int[2];
        this.best_status = new String[]{"채썰기", "삶기"};
    
    }
}
