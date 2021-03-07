package Lesson_5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final Semaphore semaphore = new Semaphore(Task_1.CARS_COUNT / 2);
    private long finishTima;

    public Tunnel(int length) {
        this.length = length;
        this.description = "Tunnel " + length + " m";
    }

    @Override
    public void go(Car c, int stagePos, int stageCount, long startTime) {
        try {
            try {
                System.out.println(c.getName() + " waiting for: " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " started: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finishTima = System.currentTimeMillis() - startTime;
                System.out.println(c.getName() + " has done: " + description + ", teme from begin = " + ((float) (finishTima) / 1000));
                semaphore.release();
                if (stagePos == stageCount && Task_1.firstFinish) {
                    Task_1.firstFinish = false;
                    System.out.println(c.getName() + " Win!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
