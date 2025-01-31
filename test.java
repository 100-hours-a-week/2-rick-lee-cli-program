import java.util.*;

public class test {

    public static void main(String[] args) {
        Food onion1 = new Onion();
        Food onion2 = new Onion();

        onion1.setCuted();
        Set<Food> dish = new HashSet<Food>();
        dish.add(onion1);

        System.out.println(onion1.getClass());
    }
}