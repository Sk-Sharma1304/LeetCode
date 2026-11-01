import java.util.Arrays;
import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; 
        
        int j = 1; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { 
                nums[j] = nums[i];
                j++;
            }
        }
        return j; 
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution solution = new Solution();
        
        int uniqueCount = solution.removeDuplicates(nums); 
        System.out.println("Number of unique elements: " + uniqueCount);
        
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " "); 
        }
    }
}