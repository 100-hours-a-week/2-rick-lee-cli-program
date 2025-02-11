package backend.domain.preps.service;

import java.util.HashSet;
import java.util.Set;

import common.Food;

/*
 * 추가 손질의 유효성 검사 및
 * 각 손질의 유형 반환(요리 시간이 필요한지, 자르는 손질인지)
 */
public class PrepsValidator {
    private Set<String> cutStatuSet = new HashSet<String>();    //재료를 자르는 status들
    private Set<String> cookingStatus = new HashSet<String>();  //요리시간을 필요로 하는 status들

    public PrepsValidator(){
        //재료를 자르는 손질들
        this.cutStatuSet.add("깍뚝썰기");
        this.cutStatuSet.add("다지기");
        this.cutStatuSet.add("채썰기");
        this.cutStatuSet.add("갈기");
        this.cutStatuSet.add("회뜨기");
        //요리 시간이 필요한 손질들
        this.cookingStatus.add("굽기");
        this.cookingStatus.add("찌기");
        this.cookingStatus.add("삶기");
        this.cookingStatus.add("튀기기");
    }

    protected void checkllegalStatus(Food food, String new_status){
        checkCuted(food, new_status);
        checkDoubleStatus(food, new_status);
    }
    protected boolean checkNeedCookingTime(String new_status){
        if(cookingStatus.contains(new_status)){
            return true;
        }
        return false;
    }
    protected boolean checkIsCuttingPreps(String new_status){
        if(cutStatuSet.contains(new_status)){
            return true;
        }
        return false;
    }

    //재료가 썰렸는데 추가로 썰려는 요청인지 검사
    private boolean checkCuted(Food food, String new_status){
        if(food.isCuted() && cutStatuSet.contains(new_status)){
            throw new IllegalStateException("이미 잘린 재료 입니다");
        }
        return true;
    }
    //재료에 이미 처리된 손질을 중복으로 요청하는 경우
    private boolean checkDoubleStatus(Food food, String new_status){
        if(food.getStatus().contains(new_status)){
            throw new IllegalStateException("이미 "+new_status+"된 재료 입니다");
        }
        return true;
    }
}