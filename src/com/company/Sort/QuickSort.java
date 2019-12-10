package com.company.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 最正宗的快速排序
 *
 * @author zhangmeng36
 * @date 2019/7/18 下午10:57
 */
public class QuickSort {
    public static Random random = new Random();
    public static void quickSort(int[] array, int i, int j) {
        if (array == null) {
            return;
        }
        if (i > j) {
            return;
        }
        int l = i;
        int r = j;
        // 设定索引index
        int index = l;
        int pivot = array[index];
        while (l < r) {
            while (array[r] >= pivot && l < r) {
                r--;
            }
            array[index] = array[r];
            index = r;
                // 如果不减1 不能跳出while循环
            while (array[l] <= pivot && l < r) {
                l++;
            }
            array[index] = array[l];
            index = l;

        }
        array[index] = pivot;
        quickSort(array, i, index-1);
        quickSort(array, index + 1, j);
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{new int[]{4,5},new int[]{2,4},new int[]{4,6}, new int[]{3,4}, new int[]{0,0}, new int[]{1,1}, new int[]{3,5}, new int[]{2,2}};
        int[] array = {2, 2, 3, 1, 5, 2, 4};
        quickSort(array, 0, array.length-1);
        List list = Arrays.asList(array);
        System.out.println(list);

        List<int[]> ret = new ArrayList<>();
        ret.add(new int[]{1,2});
        ret.add(new int[]{2,3});
        ret.add(new int[]{3,4});
    }
}
