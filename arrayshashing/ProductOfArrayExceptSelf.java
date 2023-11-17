package neetcode.arrayshashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] arr1 = new int[nums.length];
//        int[] arr2 = new int[nums.length];
            int left = 1;
            int right = 1;
            for (int i = 0; i < nums.length; i++) {
                arr1[i] = left;
                left = left * nums[i];
            }
        System.out.println(Arrays.toString(arr1) + "After left product");

        for (int i = nums.length - 1; i >= 0; i--) {
                arr1[i] = arr1[i] * right;
                right = right * nums[i];
            }
//        System.out.println(Arrays.toString(arr1) + "After right product");

            return arr1;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
