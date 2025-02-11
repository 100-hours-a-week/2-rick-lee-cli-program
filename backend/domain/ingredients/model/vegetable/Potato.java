package backend.domain.ingredients.model.vegetable;
public class Potato extends Vegetable{
    public Potato(){
        super();
        this.name = "감자";
        this.best_dgree = new int[]{60, 70};
        this.best_status = new String[]{"삶기", "찌기", "튀기기"};
    }
}