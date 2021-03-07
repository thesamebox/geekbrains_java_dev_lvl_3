package Lesson_5;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch cdlReady;
    private final CountDownLatch cdlFinish;
    private long startTime;
    private static final CountDownLatch countDownLatch = new CountDownLatch(Task_1.CARS_COUNT);

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdlReady, CountDownLatch cdlFinish) {
        this.race = race;
        this.speed = speed;
        this.cdlReady = cdlReady;
        this.cdlFinish = cdlFinish;
        CARS_COUNT++;
        this.name = "Speeder #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " is preparing");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " is ready");
            countDownLatch.countDown();
            cdlReady.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, i + 1, race.getStages().size(), startTime);
        }
        cdlFinish.countDown();
    }
}
