package neetcode.twopointers;

import java.util.Arrays;

public class MaxAreaContainer {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length -1;
        int maximuArea = Integer.MIN_VALUE;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right -left);

            maximuArea = Math.max(area,maximuArea);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return maximuArea;
    }

    public static void main(String[] args) {

        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {1,1}));

    }
}
