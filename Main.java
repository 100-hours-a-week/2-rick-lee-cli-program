
public class Main {

    public static void main(String[] args) {
        //객체 선언
        Viewer front = new Viewer();
        API api;

        front.showTutorial();
        while (true) {
            api = new API();
            while(api.checkKeepPlaying()){    //재료를 5가지 조리하거나 행동포인트를 다쓰면 탈출
                while(!api.selectFood());     //재료를 정상적으로 선택하면 탈출
                //재료를 정상적으로 손질하고, 손질을 그만두면 탈출
                while (true){
                    if(!api.selectPrep()){
                        continue;
                    }
                    if(api.selectKeepPrep()){
                        break;
                    }
                }
                if(api.selectEnd()){
                    break;
                }
            }
            api.showResult();
        }
    }
}
