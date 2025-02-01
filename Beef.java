public class Beef extends Meat{
    Beef(){
        super();
        this.name = "소고기";
        this.best_dgree = new int[]{20, 30};
        this.best_status = new String[]{"밑간하기", "굽기"};
        this.worst_status = new String[]{"삶기", "찌기"};
    }
}