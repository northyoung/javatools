package com.util.arithmetic;

/**
 * Created with IDEA
 * User: sunsy3
 * Time: 2016/10/26
 * Commit:
 */
public class BubbleSort {
    Integer[] s = new Integer[]{1,22,3,55,5};
    public Integer[] sort(Integer[] s){
        Integer loopLength = s.length;
        for(;loopLength>1;loopLength--){
            for(int count =0;count<loopLength-1;count++){
                if(s[count] > s[count+1]){
                    Integer tmp = s[count+1];
                    s[count+1] = s[count];
                    s[count] = tmp;
                }
            }
        }
        return s;
    }

    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(bubbleSort.sort(bubbleSort.s));
    }
}
