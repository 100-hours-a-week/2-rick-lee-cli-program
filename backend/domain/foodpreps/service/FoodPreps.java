package backend.domain.foodpreps.service;

public class FoodPreps {
    private Set<String> cutStatuSet = new HashSet<String>();

    public FoodPreps(){
        this.cutStatuSet.add("깍뚝썰기");
        this.cutStatuSet.add("다지기");
        this.cutStatuSet.add("채썰기");
        this.cutStatuSet.add("갈기");
        this.cutStatuSet.add("회뜨기");
    }
}
