package com.company.Sort;

/**
 * 冒泡排序
 *
 * @author zhangmeng36
 * @date 2019/7/20 上午12:27
 */
public class BubbleSort {


    public static void BubbleSort(int[] array){
        boolean isContinue = true;
        for(int i = array.length -1; i>= 0; i--){
            if(!isContinue){
                break;
            }
            for(int j = 0; j < i; j++){
                isContinue = false;
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isContinue = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arrary = new int[] {-1,-1,-6,5,2,3,4};
        BubbleSort(arrary);
        for (int i = 0; i < arrary.length; i++) {
            System.out.print(arrary[i] + " ");
        }
    }
}
