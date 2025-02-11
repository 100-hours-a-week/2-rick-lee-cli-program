package backend.domain.ingredients.model.meat;

public class Pork extends Meat{
    public Pork(){
        super();
        this.name = "돼지고기";
        this.best_dgree = new int[]{80, 90};
        this.best_status = new String[]{"밑간하기", "튀기기"};
    }
}