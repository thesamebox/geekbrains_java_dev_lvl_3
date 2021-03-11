package Lesson_6;

import java.util.Arrays;

public class Task2_3 {
    public static int[] task2_array;
    public static int[] task3_array;

    public static void main(String[] args) {
        task2_array = task2_createArray();
        System.out.print(Arrays.toString(task2_array));
        System.out.println(Arrays.toString(task2_figuresAfterLastFour(task2_array)));

        task3_array = task3_createArray();
        System.out.print(Arrays.toString(task3_array));
        System.out.println(task3_checkForOneAndFour(task3_array));

    }
    
    public static int[] task2_createArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    public static int[] task2_figuresAfterLastFour(int[] arr) throws RuntimeException {
        boolean temp = false;
        for (int i : arr) {
            if (arr[i] == 4){
                temp = true;
                break;
            }
        }
        if (temp){
            for (int i = arr.length - 1; i >= 0 ; i--) {
                if (arr[i] == 4) {
                    return Arrays.copyOfRange(arr, i + 1, arr.length);
                }
            }
        }
        return null;
    }

    public static int[] task3_createArray() {
        int temp;
        int[] arr = new int [10];
        for (int i = 0; i < arr.length ; i++) {
            temp = (int) (Math.random() * 10);
            if (temp >= 7) {
                arr[i] = 4;
            } else {
                arr[i] = 1;
            }
        }
        return arr;
    }

    public static boolean task3_checkForOneAndFour(int[] arr) {
        for (int i : arr) {
            if (i == 1 || i == 4) {
                return true;
            }
        }
        return false;
    }
}
