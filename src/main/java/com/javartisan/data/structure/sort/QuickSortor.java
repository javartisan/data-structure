package com.javartisan.data.structure.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * Created by liuguangxin on 2018/8/24.
 */
public class QuickSortor {

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nums[j] = rn.nextInt(20);
            }
            System.out.println(Arrays.toString(nums));
            sort(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
            System.out.println("--------------------------------------");

        }
    }


    public static void sort(int[] nums, int start, int end) {
        // 结束调用
        if (start >= end) {
            return;
        }
        int mid = partition(nums, start, end);
        sort(nums, start, mid - 1);
        sort(nums, mid + 1, end);

    }

    private static int partition(int[] nums, int start, int end) {

        int e = nums[start];
        while (start < end) {
            // end向前寻找，寻找到之后交换
            while (nums[end] >= e && end > start)
                end--;
            Utils.swap(nums, end, start);

            //后面寻找之后从前向后寻找交换
            while (nums[start] <= e && start < end)
                start++;
            Utils.swap(nums, end, start);
        }
        return start;
    }


}
