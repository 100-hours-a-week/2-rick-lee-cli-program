package common;
import java.util.HashSet;
import java.util.Set;

public class Food {
    protected String name;                                   //재료의 이름
    protected String type;                                   //재료의 종류
    protected int[] best_dgree;                              //재료의 최적 익힘정도 n~m까지
    protected int how_much_cooked=0;                         //재료의 현재 익힘 정도
    protected String[] best_status = new String[]{""};       //각 재료타입에 맞는 최적의 요리법들
    protected String[] worst_status = new String[]{""};      //각 재료타입에 안맞는 요리법들
    protected Set<String> status = new HashSet<String>();    //재료의 손질 상태
    protected boolean isCuted = false;                       //재료가 잘려있는지

    public String getName(){return this.name;}
    public void addStatus(String new_status){
        status.add(new_status);
    }
    public String getType(){return this.type;}
    public int[] getBest_dgree(){return this.best_dgree;}
    public int getHow_much_cooked(){return this.how_much_cooked;}
    public void setHow_much_cooked(int dgree){this.how_much_cooked = dgree;}
    public Set<String> getStatus(){return this.status;}
    public boolean isCuted(){return this.isCuted;}
    public void setCuted(){this.isCuted = true;}
    public String[] getBestStatus(){return this.best_status;}
    public String[] getWorstStatus(){return this.worst_status;}
}
