package Main;

import counter.Counter;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public Main() {
        Counter counter = new Counter();
        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int result = 0;
                    for (int i = 0; i < 10000; i++) {
                        result = random.nextInt(6);
                        counter.increment(result);
                    }
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("El número %d, ha salido %d veces\n",
                    i + 1,
                    counter.getTotalOfANumber(i));
        }
        System.out.printf("En total, se ha tirado el dado %d",
                counter.getTotal());
    }

    public static void main(String[] args) {
        new Main();
    }
}
