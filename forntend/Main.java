package forntend;

public class Main {

    public static void main(String[] args) {
        //객체 선언

        Controller controller;
        ViewThread monitor = new ViewThread();
        Viewer front = new Viewer(monitor);
        monitor.start();

        front.showTutorial();
        while (true) {
            controller = new Controller(monitor);
            
            while (controller.checkDish()) {
                int input = front.getMenuSelection();
                if(input == 1){
                    while (!controller.selectFood());
                    while (controller.checkActionPoint()){
                        if(!controller.selectPrep()){
                            continue;
                        }
                        if(!controller.selectKeepPrep()){
                            break;
                        }
                    }
                }
                else if(input == 2){
                    break;
                }
                else{
                    continue;
                }
            }
            controller.showResult();
        }
    }
}
