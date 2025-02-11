package backend.domain.ingredients.model.seafood;

public class Tuna extends Seafood{
    public Tuna(){
        super();
        this.name = "참치";
        this.best_dgree = new int[]{50, 60};
        this.best_status = new String[]{"회뜨기", "비늘벗기기"};
        this.worst_status = new String[]{"굽기", "삶기"};
    }
}