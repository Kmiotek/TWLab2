
import java.util.concurrent.TimeUnit;

public class Producer extends Thread{
    private final Buffor buffor;
    private final int M;

    Producer(Buffor buffor, int M){
        this.buffor = buffor;
        this.M = M;
    }

    @Override
    public void run() {
        System.out.println("Start Prepare.Producer");
        for(int i = 0 ; i < 100 ; i ++ ){
            int things = (int)(Math.random() * M);
            buffor.give(things, 727);

            int sleepTime = (int)(Math.random() * 10);
            try{
                TimeUnit.SECONDS.sleep(sleepTime);
            }
            catch(Exception e){
                System.out.println("big ooooof");
            }
        }
        System.out.println("Exit Prepare.Producer");

    }
}