package com.company.BinarySearch;

/**
 * 二分查找
 *
 * @author zhangmeng36
 * @date 2019/7/20 下午2:46
 */
public class BinarySearch {
    // 无重复元素最简单的二分查找
    public static int binarySearchA(int[] array, int target) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (array[mid] < target) {
                l = mid + 1;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 有重复元素的二分查找
    public static int binarySearchB(int[] array, int target) {
        int index = -1;
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (array[mid] < target) {
                l = mid + 1;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                index = mid;
                r = mid - 1;
            }
        }
        return index;
    }


    // 无重复元素但是有旋转数据的二分查找
    public static int binarySearchC(int[] array, int target) {
        int index = -1;
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == array[mid]) {
                return mid;
            }
            // 如果中值在前半段有序序列
            if(array[mid] > array[l]){
                // 如果目标target在前半段的前半段 可以退化维普通的二分查找
                if(array[mid] > target && target >= array[l]){
                    r = mid - 1;
                }else {
                    // 如果target 在其他端只能截取 mid后的一端
                    l = mid + 1;
                }
            }
            else{
                // 如果目标target在后半段的后半段 可以退化维普通的二分查找
                if(array[mid] < target && target <= array[r]){
                    l = mid + 1;
                }else {
                    // 如果target 在其他端只能截取 mid的前半端继续之前的过程
                    r = mid - 1;
                }
            }
        }
        return index;

    }

    // 有重复元素有旋转数组的二分查找
    public static int binarySearchD(int[] array, int target) {
        int index = -1;
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if(array[mid] == target){
                index = mid;
                r = mid - 1;
            }
            // 如果中值在前半段有序序列
            if (array[mid] > array[l]) {
                // 如果目标target在前半段的前半段 可以退化为普通的二分查找
                if (array[mid] > target && target >= array[l]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            } else if(array[mid] < array[l]){
                // 如果目标target在后半段的后半段 可以退化为普通的二分查找
                if (array[mid] < target && target <= array[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }else {
                // 处理情况
                if(array[mid] == target){
                    for(int i = array.length -1; i > mid && i > 0; i--){
                        if(array[i] == target){
                            index = i;
                        }
                        if(array[i] != array[i-1]){
                            break;
                        }
                    }
                    return index;
                }
                l++;
            }
        }
        return index;
    }

    // 返回左侧最小值不带重复元素的
    public static int binarySearchE(int[] array, int target){
        int l = 0, r = array.length - 1;
        while(l < r){
            int mid = (l + r + 1) / 2;
            if(target >= array[mid]) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

    public static int binarySearchF(int[] array, int target){
        int l = 0, r = array.length -1;
        while(l < r){
            int mid = (l + r) / 2;
            if(target > array[mid]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return  r;
    }

    // 返回左侧最小值带重复元素的
    public static int binarySearch(int[] array, int target) {

        int l = 0, r = array.length - 1;
        int index = -1;
        boolean isEqual = false;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (target > array[mid]) {
                l = mid;
            } else if (target < array[mid]) {
                r = mid - 1;
            } else {
                index = mid;
                isEqual = true;
                r = mid - 1;
            }
        }
        return isEqual ? index : l;
    }

    //返回左侧没有重复元素最小值
    public static int findMin(int[] array){
        int l = 0, r = array.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(array[mid] > array[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 34, 100, 102, 204, 305};
        int[] ratioArray= new int[]{34, 100, 102, 204, 305, 1, 10, 12, 13, 14};
        int[] ratioDupArray= new int[]{34, 34, 102, 204, 305, 1, 10, 12, 34, 34};

        int index = binarySearchF(array, 101);

        System.out.println(index);
    }
}
