import java.util.ArrayList;

public class Main {

    private static final int M = 100;
    private static final int P = 2;
    private static final int K = 3;

    public static void main(String[] args) {
        Buffor bufor = new Buffor(M*2);

        ArrayList<Thread> workers = new ArrayList<>();

        for (int i = 0; i < P; i++){
            workers.add(new Producer(bufor, M));
        }

        for (int i = 0; i < K; i++){
            workers.add(new Consumer(bufor, M));
        }

        workers.forEach(Thread::start);

        workers.forEach(worker -> {
            try{
                worker.join();
            }catch(Exception e){
                System.out.println("super ooof");
            }
        });

    }
}
