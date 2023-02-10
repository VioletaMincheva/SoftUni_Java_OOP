package p04_BubbleSortTest;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {

    @Test
    public void when_arrayPassedSortBubbleMethod_then_returnSortedArrayAsc() {
        int[] array = new int[]{5, 9, -13, 7, 81, 56, -100, 47};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-100, -13, 5, 7, 9, 47, 56, 81};
        assertEquals(expectedArray.length, array.length);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void when_arrayIsSortedAndPassedBubbleSortMethod_then_returnSameSortedArray(){
        int[] array = new int[]{-100, -13, 5, 7, 9, 47, 56, 81};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-100, -13, 5, 7, 9, 47, 56, 81};
        assertEquals(expectedArray.length, array.length);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void when_arrayIsEmptyAndPassedBubbleSortMethod_then_returnEmptyArray(){
        int[] array = new int[0];
        Bubble.sort(array);
        int[] expectedArray = new int[0];
        assertEquals(expectedArray.length, array.length);
        assertArrayEquals(expectedArray, array);

    }

}