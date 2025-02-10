package forntend;

import common.util.CLIinterface;


/**
 * 요청을 보내고, 받은 요청을 띄워줌
 */
public class FrontThread extends Thread{

    @Override
    public void run() {
        
        CLIinterface front = new CLIinterface();
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
