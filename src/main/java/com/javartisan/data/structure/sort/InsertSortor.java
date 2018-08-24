package com.javartisan.data.structure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by liuguangxin on 2018/8/24.
 */
public class InsertSortor {

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

        for (int i = 1; i < nums.length; i++) {
            int insertLoc = findInsertIndex(nums, i - 1, i);
            move(nums, insertLoc, i);
        }

    }

    private static void move(int[] nums, int insertLoc, int insertElelemtIndex) {
        int e = nums[insertElelemtIndex];
        for (int i = insertElelemtIndex; i > insertLoc; i--) {
            nums[i] = nums[i - 1];
        }
        nums[insertLoc] = e;
    }

    private static int findInsertIndex(int[] nums, int sortedIndex, int insertIndex) {
        for (int i = 0; i <= sortedIndex; i++) {
            if (nums[i] > nums[insertIndex]) {
                return i;
            }
        }
        return insertIndex;
    }
}
