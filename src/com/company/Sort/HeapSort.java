package com.company.Sort;

/**
 * 最正宗的堆排序
 *
 * @author zhangmeng36
 * @date 2019/7/20 上午12:18
 */
public class HeapSort {

    /**
     * 建堆
     */
    public static void creatHeap(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        for(int i = array.length / 2 -1 ; i >= 0; i --){
            adjustHeap(array, i, array.length);
        }
    }

    /**
     * 调整堆
     */
    public static void adjustHeap(int[] array, int i , int h) {
        // 如果有右孩子，则左右两个孩子比较，然后和父节点比较
        while (2 * i + 2 < h) {
            int tmp = i;
            if (array[2 * i + 1] < array[2 * i + 2]) {
                tmp = 2 * i + 2;
            } else {
                tmp = 2 * i + 1;
            }
            if (array[i] < array[tmp]) {
                swap(array, i, tmp);
            }
            if (i != tmp) {
                i = tmp;
            } else {
                break;
            }
        }
        // 如果有左孩子，则左孩子和父节点比较
        if (2 * i + 1 < h) {
            if (array[i] < array[2 * i + 1]) {
                swap(array, i, 2 * i + 1);
            }
        }

    }

    private static void swap(int[] array, int a, int b) {
        // 交换两个数，省去空间
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }

    /**
     * 排序
     */
    public static void heapSort(int[] array) {
        // 第一步先建堆
        creatHeap(array);
        // 第二步利用大顶堆
        for(int i = array.length -1 ; i >= 1; i--){
            swap(array, 0, i);
            adjustHeap(array, 0, i );
        }
    }

    public static void main(String[] args) {
        int [] array = new int [] {0,-1,-5,-1,2,10,1};
        //swap(array, 0, 1);
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
