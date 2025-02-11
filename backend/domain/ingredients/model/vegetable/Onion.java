package backend.domain.ingredients.model.vegetable;
public class Onion extends Vegetable{
    public Onion(){
        super();
        this.name = "양파";
        this.best_dgree = new int[]{30, 40};
        this.best_status = new String[]{"굽기", "튀기기"};
        this.worst_status = new String[]{"갈기"};
    }
}