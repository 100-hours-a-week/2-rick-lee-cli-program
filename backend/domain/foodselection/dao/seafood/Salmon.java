package backend.domain.foodselection.dao.seafood;
public class Salmon extends Seafood{
    public Salmon(){
        super();
        this.name = "연어";
        this.best_dgree = new int[]{30, 40};
        this.best_status = new String[]{"굽기", "회뜨기", "비늘벗기기"};
    }
}