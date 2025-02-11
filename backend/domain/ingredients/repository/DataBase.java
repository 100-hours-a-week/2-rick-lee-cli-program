package backend.domain.ingredients.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import backend.domain.ingredients.model.meat.*;
import backend.domain.ingredients.model.seafood.*;
import backend.domain.ingredients.model.vegetable.*;
import common.Food;

/**
 * 재료 클래스의 정보를 저장하고, 요청 시마다 새로운 객체를 생성하여 반환하는 DB 클래스
 */
public class DataBase {
    // 재료 이름(String)과 해당 재료 객체를 생성하는 Supplier<Food>를 매핑하는 static Map
    private static final Map<String, Supplier<Food>> foodSuppliers = new HashMap<>();

    static {
        // 각 재료 이름을 key로 하고, 새로운 객체를 생성하는 람다식을 value로 등록
        foodSuppliers.put("양파", () -> new Onion());
        foodSuppliers.put("감자", () -> new Potato());
        foodSuppliers.put("토마토", () -> new Tomato());
        foodSuppliers.put("돼지고기", () -> new Pork());
        foodSuppliers.put("소고기", () -> new Beef());
        foodSuppliers.put("닭고기", () -> new Chicken());
        foodSuppliers.put("연어", () -> new Salmon());
        foodSuppliers.put("참치", () -> new Tuna());
        foodSuppliers.put("가리비", () -> new Scallops());
    }

    /**
     * 요청한 재료 이름에 해당하는 새로운 객체를 생성하여 반환합니다.
     * 
     * @param className 재료 이름 (예: "Onion", "Pork" 등)
     * @return 새로운 Food 객체
     * @throws NullPointerException 해당 재료가 존재하지 않을 경우
     */
    public Food getFoodClass(String className) {
        Supplier<Food> supplier = foodSuppliers.get(className);
        if (supplier == null) {
            throw new NullPointerException("DB에 해당 자료 없음");
        }
        // 요청 시마다 supplier.get()을 호출하여 새로운 객체를 반환
        return supplier.get();
    }
}
