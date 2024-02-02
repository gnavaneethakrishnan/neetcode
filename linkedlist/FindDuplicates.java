package neetcode.linkedlist;

public class FindDuplicates {

    public int findDuplicates(int[] nums) {

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        slow = 0;

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[fast];

        }

        return slow;


    }
}
