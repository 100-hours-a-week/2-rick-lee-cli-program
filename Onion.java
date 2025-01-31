import java.util.HashSet;
import java.util.Set;

public class Onion extends Vegetable{
    private String name = "양파";
    private int[] best_dgree = {30, 40};                     //재료의 최적 익힘정도 n~m까지
    private int how_much_cooked;                             //재료의 현재 익힘 정도
    private Set<String> status = new HashSet<String>();      //재료의 손질 상태
}