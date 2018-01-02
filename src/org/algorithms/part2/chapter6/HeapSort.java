package org.algorithms.part2.chapter6;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] num = { 4, 10, 14, 16, 29, 23, 22, 1, 3};
//        maxHeapify(num, 0);
        buildMaxHeap(num);
        Arrays.stream(num).forEach(System.out::println);
    }

    /**
     * 维护最大堆性质
     * @param num
     * @param i
     */
    public static void maxHeapify(int[] num, int i) {
        int left =  2 * i + 1;
        int right = 2 * (i + 1);
        int largest = i;
        if (left < num.length && num[left] > num[i]) {
            largest = left;
        }else {
            largest = i;
        }
        if (right < num.length && num[right] > num[largest]) {
            largest = right;
        }
        if (largest != i) {
            int exchange = num[i];
            num[i] = num[largest];
            num[largest] = exchange;
            maxHeapify(num, largest);
        }
    }

    /**
     *创建堆
     * @param num
     */
    public static void  buildMaxHeap(int[] num) {
        for (int i = num.length / 2; i >= 0; i--) {
            maxHeapify(num, i);
        }
    }

    /**
     * 维护最小堆性质
     * @param num
     * @param i
     */
    public static void minHeapify(int[] num, int i) {
        int left =  2 * i + 1;
        int right = 2 * (i + 1);
        int minimum = i;
        if (left < num.length && num[left] < num[i]) {
            minimum = left;
        }else {
            minimum = i;
        }
        if (right < num.length && num[right] < num[minimum]) {
            minimum = right;
        }
        if (minimum != i) {
            int exchange = num[i];
            num[i] = num[minimum];
            num[minimum] = exchange;
            maxHeapify(num, minimum);
        }
    }
}
