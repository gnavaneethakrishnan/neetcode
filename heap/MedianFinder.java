package neetcode.heap;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {

    List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }
    public void addNum(int num) {
        if (nums.isEmpty()) {
            nums.add(num);
        } else {
            int index = binarySearch(num);
            nums.add(index, num);
        }
    }

    private int binarySearch(int num) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (num < nums.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public double findMedian() {
        int size = nums.size();
        if (size % 2 != 0) {
            return nums.get(size / 2);
        } else {
            return (nums.get(size / 2 - 1) + nums.get(size / 2)) / 2.0;
        }
    }


}
