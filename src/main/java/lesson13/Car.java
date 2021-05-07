package lesson13;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean doWin = true;
    private static Lock lock = new ReentrantLock();

    private Race race;
    private int speed;
    private CyclicBarrier cb;
    private CountDownLatch cdl;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    protected Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        this.cb = cb;
        this.cdl = cdl;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdl.countDown();

        if (checkWinner()) {
            System.out.println(this.name + " WIN!");
        }
    }

    private boolean checkWinner() {
        if (doWin) {
            try {
                lock.lock();
                doWin = false;
            } finally {
                lock.unlock();
            }
            return true;
        }
        return false;
    }
}

