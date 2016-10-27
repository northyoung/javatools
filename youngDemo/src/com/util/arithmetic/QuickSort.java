package com.util.arithmetic;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * 快速
 * Created by young on 2015/6/7.
 * http://blog.csdn.net/morewindows/article/details/6684558
 *
 * 从数列中挑出一个元素，称为 “基准”（pivot），
 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {


    //先进行挖坑填数
    public int QuickSort(int[] a,int left,int right){
        int i = left,j = right;
        int CenterNum = a[i];
        while(left < right){
            for(;CenterNum > a[right];right--){ //先从右向左找
                a[left] = a[right];
                a[right] = CenterNum;
            }

            for(;CenterNum < a[left];left++){ //在从左向右找
                a[right] = a[left];
                a[left] = CenterNum;
            }
        }
        a[left] = CenterNum;
        return i;
    }

    //进行分治法
    public void quickSort(int[] a ,int left,int right){
        if(left < right){
            int centerNum = QuickSort(a,left,right);//进行第一次排序
            quickSort(a,left,centerNum-1);
            quickSort(a,centerNum+1,right);
        }
    }

    public static void main(String[] stra) {

        int a[] = {23, 53, 77, 36, 84, 76, 93, 13, 45, 23};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a, 0, a.length);

        for (int i = 1; i <= a.length; i++)
            System.out.println(a[i - 1]);

    }

}

