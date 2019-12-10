package com.company.Sort;

/**
 * 归并排序
 *
 * @author zhangmeng36
 * @date 2019/7/19 上午11:31
 */
public class MergeSort {
    /**
     * 递归
     * @param array
     */
    public static void mergeSort(int [] array, int l, int r, int[] tmpK){
        if(l >= r){
            return;
        }
        int mid = (l + r)/ 2;
        mergeSort(array, l, mid, tmpK);
        mergeSort(array, mid+1, r, tmpK);
        merge(array, l, mid, r, tmpK);
    }


    private static void merge(int[] array, int l, int mid, int r, int[] tmpK) {
        {
            int i = l, j = mid + 1, k;
            for (k = l; i <= mid && j <= r; ) {
                if (array[i] <= array[j]) {
                    tmpK[k++] = array[i++];
                } else {
                    tmpK[k++] = array[j++];
                }
            }
            while (i <= mid) {
                tmpK[k++] = array[i++];
            }
            while (j <= r) {
                tmpK[k++] = array[j++];
            }
            System.arraycopy(tmpK, l, array, l, r - l + 1);
        }

    }
    /**
     * 非递归
     * @param array
     */
    public static void withRecursiveMergeSort(int[] array) {
        int l = 0, r = array.length - 1;
        int[] tmpK = new int[array.length];
        if (l >= r) {
            return;
        }
        int len = 1;
        while (len < array.length) {
            //一趟归并
            int start = 0;
            // 一次merge
            //如果本次merge归并预计最后一个位置没有越界
            while (start + 2 * len - 1 < array.length) {
                // 一次merge
                merge(array, start, start + len - 1, start + 2 * len - 1, tmpK);
                start += 2 * len;
            }
            //在最后一段merge时，完整的merge区越界，但是最后一段归并的一半没有越界，则最后一段仍需要merge,
            // 否则 最后一段已经是有序的，不再需要再排序了
            if (start + len - 1 < array.length) {
                merge(array, start, start + len - 1, array.length - 1, tmpK);
            }
            len = len * 2;
        }
    }


    public static void main(String[] args) {
        int[] arrary = new int[]{3, -5, 2, 2, -1, -2, 10, 12, 15};
        int[] tempK = new int[arrary.length];
        mergeSort(arrary, 0, arrary.length - 1, tempK);
        //withRecursiveMergeSort(arrary);
        for (int i = 0; i < arrary.length; i++) {
            System.out.print(arrary[i] + " ");
        }
    }
}
