package com.javartisan.data.structure.sort;

/**
 * Created by liuguangxin on 2018/8/24.
 */
public class Utils {

    public static void swap(int[] num, int i, int j) {
        if (i == j) {
            return;
        }
        num[i] = num[i] + num[j];
        num[j] = num[i] - num[j];
        num[i] = num[i] - num[j];
    }
}
