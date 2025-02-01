public class Tomato extends Vegetable{
    Tomato(){
        super();
        this.name = "토마토";
        this.best_dgree = new int[]{0, 20};
        this.best_status = new String[]{"삶기"};
        this.worst_status = new String[]{"굽기", "튀기기"};
    }
}