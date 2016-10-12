package com.util.arithmetic;

/**
 * Created by young on 2015/6/7.
 */
public class QuickSort {

    public static int Partition(char a[], int p, int r) {
        int x = a[r - 1];
        int i = p - 1;
        char temp;
        for (int j = p; j <= r - 1; j++) {
            if (a[j - 1] <= x) {
                // swap(a[j-1],a[i-1]);
                i++;
                temp = a[j - 1];
                a[j - 1] = a[i - 1];
                a[i - 1] = temp;

            }
        }
        //swap(a[r-1,a[i+1-1]);
        temp = a[r - 1];
        a[r - 1] = a[i + 1 - 1];
        a[i + 1 - 1] = temp;

        return i + 1;

    }

    public static void QuickSort(char a[], int p, int r) {

        if (p < r) {
            int q = Partition(a, p, r);
            QuickSort(a, p, q - 1);
            QuickSort(a, q + 1, r);

        }

    }

    public static void main(String[] stra) {

        char a[] = {23, 53, 77, 36, 84, 76, 93, 13, 45, 23};
        QuickSort(a, 1, 10);

        for (int i = 1; i <= 10; i++)
            System.out.println(a[i - 1]);

    }

}

