import java.util.concurrent.TimeUnit;

public class Consumer extends Thread{
    private final Buffor buffor;
    private final int M;

    Consumer(Buffor buffor, int M){
        this.buffor = buffor;
        this.M = M;
    }

    @Override
    public void run() {
        System.out.println("Konsument zaczyna prace");
        for(int i = 0 ; i < 100 ; i ++ ){
            int commission = (int)(Math.random() * M) + 1;
            buffor.take(commission, 666);

            int sleepTime = (int)(Math.random() * 10);
            try{
                TimeUnit.SECONDS.sleep(sleepTime);
            }
            catch(Exception e){
                System.out.println("big ooooof");
            }
        }
        System.out.println("Konsument konczy prace");
    }
}