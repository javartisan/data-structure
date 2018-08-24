package com.javartisan.data.structure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by liuguangxin on 2018/8/24.
 */
public class BubbleSortor {
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


    public static void sort(int[] nums) {

        boolean changed = false;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (nums[j] > nums[j + 1]) {
                    Utils.swap(nums, j, j + 1);
                    changed = true;
                }
            }
            if (!changed) {
                return;
            }
        }
    }


}
