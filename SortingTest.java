package lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    Sorting s = new Sorting();

    @Test
    void mergeSort1() {
        int [] a = {20,43,2,54,1,0,5};
        s.mergeSort(a,0,a.length-1);
        assertArrayEquals(new int[]{0,1,2,5,20,43,54},a);
    }

    @Test
    void mergeSort2() {
        int [] a = {10,9,8,7,6,5,4,3,2,1};
        s.mergeSort(a,0,a.length-1);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10},a);
    }

    @Test
    void mergeSort3() {
        int [] a = {1};
        s.mergeSort(a,0,a.length-1);
        assertArrayEquals(new int[]{1},a);
    }

    @Test
    void mergeSort4() {
        int [] a = {3,1};
        s.mergeSort(a,0,a.length-1);
        assertArrayEquals(new int[]{1,3},a);
    }

    @Test
    void mergeSort5() {
        int [] a = {};
        s.mergeSort(a,0,a.length-1);
        assertArrayEquals(new int[]{},a);
    }

    @Test
    void mergeSort6() {
        int [] a = {2,4,6,7,9,12};
        s.mergeSort(a,0,a.length-1);
        assertArrayEquals(new int[]{2,4,6,7,9,12},a);
    }

    @Test
    void quickSort1() {
        int [] a = {20,43,2,54,1,0,5};
        s.quickSort(a,0,a.length-1);
        assertArrayEquals(new int[]{0,1,2,5,20,43,54},a);
    }

    @Test
    void quickSort2() {
        int [] a = {10,9,8,7,6,5,4,3,2,1};
        s.quickSort(a,0,a.length-1);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10},a);
    }

    @Test
    void quickSort3() {
        int [] a = {1};
        s.quickSort(a,0,a.length-1);
        assertArrayEquals(new int[]{1},a);
    }

    @Test
    void quickSort4() {
        int [] a = {3,1};
        s.quickSort(a,0,a.length-1);
        assertArrayEquals(new int[]{1,3},a);
    }

    @Test
    void quickSort5() {
        int [] a = {3,2,9,8,7,0,5};
        s.quickSort(a,0,a.length-1);
        assertArrayEquals(new int[]{0,2,3,5,7,8,9},a);
    }

    @Test
    void quickSort6() {
        int [] a = {};
        s.quickSort(a,0,a.length-1);
        assertArrayEquals(new int[]{},a);
    }

    @Test
    void quickSort7() {
        int [] a = {2,4,6,7,9,12};
        s.quickSort(a,0,a.length-1);
        assertArrayEquals(new int[]{2,4,6,7,9,12},a);
    }
}
