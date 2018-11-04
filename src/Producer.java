import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private BlockingQueue queue;
    private static final int SLEEP = 1000;
    private boolean isRunning = true;
    Random random = new Random();
    @Override
    public void run() {
        while (isRunning){
            try {
                Thread.sleep(SLEEP);
                queue.offer(random.nextInt(),1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        isRunning = false;
    }
}
