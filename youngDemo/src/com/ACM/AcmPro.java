package com.ACM;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by young on 2015/6/7.
 */
public class AcmPro {

    /**
     * day2 检测匹配括号问题
     * 如果匹配返回0
     */
    public static int  Matchbrackets(String inputString) {
        char[] tmp =  inputString.toCharArray();
        int count = 0;
        for(int i=0;i<tmp.length;i++){
            if(Character.toString(tmp[i]).equals("{") ){
                count += 1;
            }else if(Character.toString(tmp[i]).equals("}") ){
                count -= 1;
            }
        }
        return count;
    }

    /** day4 ASCII码排序
     *
     */
    public static void AsciiArray(){
        //进行字符串录入
        Scanner in = new Scanner(System.in);
        System.out.println("输入的数据数量");
        int ArrayNum = in.nextInt();
        ArrayList tmpList = new ArrayList();
        for(int i=1;i<=ArrayNum;i++){
            System.out.println("输入第"+i+"个字符串数组");
            tmpList.add(in.next());
        }
        //进行字符串排序2

        for(int i=0;i<tmpList.size();i++){
            char[] charList = tmpList.get(i).toString().toCharArray();
//            QuickSort.QuickSort(charList,1,charList.length);
            System.out.println(charList);
        }
    }

    public static void main(String args[]){
        AcmPro.AsciiArray();
    }
}

