package Lesson_6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Tests {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 1, 1}, new int[]{1, 1}, true},
                {new int[]{0, 0, 4, 0, 0, 0, 0}, new int[]{0, 0, 0, 0}, true},
                {new int[]{2, 2, 2, 2, 2, 2, 2, 2}, new int[]{}, false},
                {new int[]{4, 4, 4, 1}, new int[]{1}, true}
        });
    }

    private final int[] addArr;
    private final int[] outArr;
    private final boolean expectedResult;

    public Tests(int[] arr, int[] outArr, boolean expectedResult) {
        this.addArr = arr;
        this.outArr = outArr;
        this.expectedResult = expectedResult;
    }

    @Test
    public void checkOneOrFourTest() {
        Assert.assertEquals(expectedResult, Task2_3.task3_checkForOneAndFour(addArr));
    }

    @Test
    public void toArrayAfterFourTest() {
        Assert.assertArrayEquals(outArr, Task2_3.task2_figuresAfterLastFour(addArr));

    }

    @Test(expected = RuntimeException.class)
    public void toArrayAfterFourTestException() {
        Task2_3.task2_figuresAfterLastFour(addArr);
    }

}
