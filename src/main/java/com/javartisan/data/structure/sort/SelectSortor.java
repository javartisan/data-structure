package com.javartisan.data.structure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by liuguangxin on 2018/8/24.
 */
public class SelectSortor {

    public static void main(String[] args) {

        int[] nums = new int[10];
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nums[j] = rn.nextInt(20);
            }

            System.out.println(Arrays.toString(nums));
            sort(nums);
            System.out.println(Arrays.toString(nums));
            System.out.println("--------------------------------------");

        }


    }

    /**
     * 快速排序，每一次选择最小的元素交换到前面
     *
     * @param nums
     */
    public static void sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;// 每一次相对第一个位置假定为最小元素
            for (int j = i; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            Utils.swap(nums, i, minIndex);

        }

    }
}
