package backend.domain.ingredients.model.meat;

import common.Food;

public abstract class Meat extends Food{
    public Meat(){
        this.type = "meat";
        this.best_dgree = new int[2];
        this.best_status = new String[3];
    }
}
