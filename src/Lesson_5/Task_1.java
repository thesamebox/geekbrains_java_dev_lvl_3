package Lesson_5;

import java.util.concurrent.CountDownLatch;

public class Task_1 {
    public static final int CARS_COUNT = 10;
    public static volatile boolean firstFinish = true;

    public static void main(String[] args) {
        System.out.println("READY");
        Race race = new Race(
                new Road(60),
                new Tunnel(50)
        );
        Car[] cars = new Car[CARS_COUNT];
        CountDownLatch countDownLatchReady = new CountDownLatch(CARS_COUNT);
        CountDownLatch countDownLatchFinish = new CountDownLatch(CARS_COUNT);
        long time;

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() *  10), countDownLatchReady, countDownLatchFinish);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            countDownLatchReady.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("GO!");
        time = System.currentTimeMillis();

        try {
            countDownLatchFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Race is done! Time = " + ((float) (System.currentTimeMillis() - time) / 1000));
    }
}
