/**
 * 재료들의 추상 클래스
 */

public abstract class Food {
    private String name;                //재료의 이름름
    private String type;                //재료의 종류(야채, 고기, 해산물)
    private int[] best_dgree;           //재료의 최적 익힘정도 n~m까지
    private int how_much_cooked;        //재료의 현재 익힘 정도
    private String[] status;             //재료의 손질 상태
    private int status_idx = 0;          //status 배열의 인덱스
    private boolean isCuted = false;    //재료가 잘려있는지

    protected abstract String getName();
    protected abstract String getType();
    protected abstract int[] getBest_dgree();
    protected abstract int getHow_much_cooked();
    protected abstract void setHow_much_cooked(int dgree);
    protected abstract String[] getStatus();
    protected abstract String getFinalStatus();
    protected abstract void setStatus(String new_status);
    protected abstract boolean isCuted();
    protected abstract void setCuted();
}
