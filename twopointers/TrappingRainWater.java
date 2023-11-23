package neetcode.twopointers;

public class TrappingRainWater {

    public static int trap(int[] height) {

        //int water level
        //int trap
        int result = 0;

        for (int i = 1; i < height.length-2 ; i++) {

            int leftBar = height[i];

            for (int j = 0; j < i; j++) {

                if(height[j] > leftBar) {
                    leftBar = height[j];
                }
            }

        int rightBar = height[i];

            for (int j = i+1; j < height.length; j++) {

                if(height[j] > rightBar) {
                    rightBar = height[j];
                }

            }

            int waterLevel = Math.min(leftBar,rightBar);
            int trappedWater = waterLevel - height[i];
            result = result + trappedWater;

        }

        return result;


    }


    public static void main(String[] args) {

        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

    }
}
