public class Box {
    private volatile boolean tumbler = false;
    private final int SLEEP_TIME = 2000;
    private int counter = 7;

    public void check() {
        try {
            while (counter != 0) {
                System.out.printf("Поток %s включил тумблер.\n", Thread.currentThread().getName());
                tumbler = true;
                counter--;
                Thread.sleep(SLEEP_TIME);
                System.out.println(counter);
            }
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unCheck() {
        while (true) {
            if (tumbler) {
                System.out.printf("Поток %s выключил тумблер.\n", Thread.currentThread().getName());
                tumbler = false;
            }
        }
    }
}
