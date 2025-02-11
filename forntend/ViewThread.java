package forntend;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ViewThread extends Thread{
    private final BlockingQueue<String> Msgque = new LinkedBlockingQueue<>();;

    @Override
    public void run() {
        // 스레드가 중단되기 전까지 반복
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // 1초 대기
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 인터럽트 발생 시 종료하기 위해 현재 스레드 인터럽트 상태 복원
                Thread.currentThread().interrupt();
            }
            
            // 큐에서 모든 요소를 꺼내어 출력
            String item;
            while ((item = Msgque.poll()) != null) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(item);
            }
        }
    }

    public void putString(String text){
        try {
            Msgque.put(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
