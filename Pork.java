import java.util.HashSet;
import java.util.Set;

public class Pork extends Meet{
    private String name = "돼지고기";
    private int[] best_dgree = {80, 90};                     //재료의 최적 익힘정도 n~m까지
    private int how_much_cooked;                             //재료의 현재 익힘 정도
    private Set<String> status = new HashSet<String>();      //재료의 손질 상태
}