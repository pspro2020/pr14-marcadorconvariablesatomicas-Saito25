package counter;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Counter {

    private final AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(6);

    public void increment(int position) {
        if (position > 5 || position < 0) {
            throw new IllegalArgumentException("El argumento no puede ser mayor a 5 o menor a 0");
        }
        atomicIntegerArray.incrementAndGet(position);
    }

    public int getTotal() {
        int total = 0;

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            total += atomicIntegerArray.get(i);
        }

        return total;
    }

    public int getTotalOfANumber(int position) {
        if (position > 5 || position < 0) {
            throw new IllegalArgumentException("El argumento no puede ser mayor a 5 o menor a 0");
        }
        return atomicIntegerArray.get(position);
    }

}
