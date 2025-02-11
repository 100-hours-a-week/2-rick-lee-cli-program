package backend.domain.preps.service;

import common.Food;

/**
 * 입력값과 선택지를 매핑하고,
 * 추가 페이지 필요시 이를 알림
 */
public class PrepInputHandler {
    PrepsApplier headChef = new PrepsApplier();
    PrepsValidator prepsVal = new PrepsValidator();


    //현재 고른 재료에 추가 손질 요청
    private void answerAddStatus(Food food, String new_status){
        //추가할 손질이 유효한지 검사
        prepsVal.checkllegalStatus(food, new_status);

        //요리시간을 필요로하는 손질이면 추가 입력 요청
        if(prepsVal.checkNeedCookingTime(new_status)){
            throw new IllegalArgumentException("요리 시간 필요");
        }
        headChef.cooking(food, new_status);

    }
    
    //요리시간이 필요한 재료 손질이 들어오면 반영하여 재료 손질
    public void answerAddStatus(String new_status, Food food, int cookingtime){
        //추가할 손질이 유효한지 검사
        prepsVal.checkllegalStatus(food, new_status);

        headChef.cooking(food, new_status);
    }

    /**
     * 입력된 인덱스에 해당하는 손질 문자열을 반환
     * @param idx 손질 방법 번호 (1 ~ 8)
     * @return 채소 손질 문자열, 유효하지 않은 경우 null
     */
    public String getPrepString(Food food , int idx) {
        if(food.getType().equals("vege")){
            if (idx > 0 && idx < VEGE_PREPS.length) {
                return VEGE_PREPS[idx];
            }
            throw new NullPointerException("야채 손질 선택지가 유효하지 않습니다");
        }
        else if(food.getType().equals("meat")){
            if (idx > 0 && idx < MEAT_PREPS.length) {
                return MEAT_PREPS[idx];
            }
            throw new NullPointerException("고기 손질 선택지가 유효하지 않습니다");
        }
        else if(food.getType().equals("seafood")){
            if (idx > 0 && idx < SEAFOOD_PREPS.length) {
                return SEAFOOD_PREPS[idx];
            }
            throw new NullPointerException("해산물 손질 선택지가 유효하지 않습니다");
        }
        throw new NullPointerException("재료 손질 선택지가 유효하지 않습니다");
    }

    // 채소 손질 문자열 배열 (인덱스 0은 사용하지 않음)
    private static final String[] VEGE_PREPS = {
        null,         // index 0
        "채썰기",     // index 1
        "깍뚝썰기",   // index 2
        "다지기",     // index 3
        "갈기",       // index 4
        "굽기",       // index 5
        "삶기",       // index 6
        "찌기",       // index 7
        "튀기기"      // index 8
    };

    // 고기 손질 문자열 배열
    private static final String[] MEAT_PREPS = {
        null,          // index 0: 사용하지 않음
        "밑간하기",    // index 1
        "망치질하기",  // index 2
        "다지기",      // index 3
        "깍뚝썰기",    // index 4
        "굽기",       // index 5
        "삶기",       // index 6
        "찌기",       // index 7
        "튀기기"       // index 8
    };

    // 해산물 손질 문자열 배열
    private static final String[] SEAFOOD_PREPS = {
        null,          // index 0: 사용하지 않음
        "밑간하기",    // index 1
        "비늘 벗기기", // index 2
        "회뜨기",     // index 3
        "깍뚝썰기",    // index 4
        "굽기",       // index 5
        "삶기",       // index 6
        "찌기",       // index 7
        "튀기기"       // index 8
    };

}