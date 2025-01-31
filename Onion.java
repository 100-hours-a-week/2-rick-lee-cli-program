public class Onion extends Food{
    private String name = "onion";
    private String type = "Vegetable";
    private int[] best_dgree = {30, 40};          //재료의 최적 익힘정도 n~m까지
    private int how_much_cooked;                  //재료의 현재 익힘 정도
    private String[] status = new String[10];                       //재료의 손질 상태
    private int status_idx = 0;                    //status 배열의 인덱스
    private boolean isCuted = false;              //재료가 잘려있는지

    @Override
    protected String getName(){return this.name;}
    @Override
    protected String getType(){return this.type;}
    @Override
    protected int[] getBest_dgree(){return this.best_dgree;}
    @Override
    protected int getHow_much_cooked(){return this.how_much_cooked;}
    @Override
    protected void setHow_much_cooked(int dgree){this.how_much_cooked = dgree;}
    @Override
    protected String[] getStatus(){return this.status;}
    @Override
    protected String getFinalStatus(){return this.status[status_idx];}
    @Override
    protected void setStatus(String new_status){
        this.status[status_idx] = new_status;
        status_idx++;
    }
    @Override
    protected boolean isCuted(){return this.isCuted;}
    @Override
    protected void setCuted(){this.isCuted = true;}
}