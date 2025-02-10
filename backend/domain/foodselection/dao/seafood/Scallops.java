package backend.domain.foodselection.dao.seafood;
public class Scallops extends Seafood{
    public Scallops(){
        super();
        this.name = "가리비";
        this.best_dgree = new int[]{20, 30};
        this.best_status = new String[]{"굽기", "찌기"};
        this.worst_status = new String[]{"회뜨기", "비늘벗기기"};
    }

}
