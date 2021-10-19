public class Buffor {
    public int used;
    public int capacity;

    public Buffor(int capacity) {
        this.capacity = capacity;
        used = 0;
    }

    public synchronized void give(int howMuch, int portion){
        System.out.println("Dodaje " + howMuch);
        while((this.capacity - this.used) <= howMuch){
            try {
                wait();
            } catch (InterruptedException e)  {
                System.out.println("big ooof");
            }
        }
        used += howMuch;
        System.out.println("Dalem " + howMuch + " z p " + portion + " teraz tu jest " + used);

        notifyAll();
    }

    public synchronized void take(int howMuch, int portion){

        System.out.println("Biore " + howMuch);
        while((this.used) <= howMuch){
            try {
                wait();
            } catch (InterruptedException e)  {
                System.out.println("big ooof");
            }
        }
        used -= howMuch;
        System.out.println("Wzialem " + howMuch + " i wsadzilem do p " + portion + " teraz tu jest " + used);

        notifyAll();
    }
}
