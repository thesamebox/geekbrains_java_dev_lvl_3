package Lesson_1;

import java.util.ArrayList;
import java.util.List;

public class Task1_and_2 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        exchange_task_1(arr, 2, 7);

        List<?> listOk = toArrayList_task_2(arr);

        for (Object o : listOk) {
            System.out.print(o + " ");
        }
    }

    public static <T> void exchange_task_1 (T[] arr, int in_1, int in_2) {
        T temp = arr[in_1];
        arr[in_1] = arr[in_2];
        arr[in_2] = temp;
    }

    public static <T> List<T> toArrayList_task_2(T[] arr) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
