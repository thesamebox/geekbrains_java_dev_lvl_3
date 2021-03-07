package Lesson_4;

import java.sql.SQLOutput;

public class Task_1 {
    static String a = "A";

    public static void main(String[] args) {
        Object lock = new Object();
        class WorkClass implements Runnable {
            private String b;
            private String nextB;

            public WorkClass(String b, String nextB) {
                this.b = b;
                this.nextB = nextB;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        try {
                           while (!a.equals(b))
                                lock.wait();
                            System.out.print(b);
                            a = nextB;
                            Thread.sleep(1);
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        new Thread (new WorkClass("A", "B")).start();
        new Thread (new WorkClass("B", "C")).start();
        new Thread (new WorkClass("C", "D")).start();
        new Thread (new WorkClass("D", "E")).start();
        new Thread (new WorkClass("E", "A")).start();
    }
}
