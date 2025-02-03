package backend.database.meat;

public class Chicken extends Meat{
    public Chicken(){
        super();
        this.name = "닭고기";
        this.best_dgree = new int[]{50, 60};
        this.best_status = new String[]{"밑간하기", "굽기", "튀기기기"};
        this.worst_status = new String[]{"삶기", "다지기"};
    }
}