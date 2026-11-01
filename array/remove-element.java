import java.util.*;

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Shift non-val elements to the front
                k++;
            }
        }
        return k; // Return the count of valid elements
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // Input the size of the array
        int n = kb.nextInt();
        int[] nums = new int[n];

        // Input the elements of the array
        for (int i = 0; i < n; i++) {
            nums[i] = kb.nextInt();
        }

        // Input the value to be removed
        int val = kb.nextInt();

        // Create an object of Solution and call the method
        Solution obj = new Solution();
        int newSize = obj.removeElement(nums, val);

        // Output the results
        System.out.println("Output: " + newSize);
        System.out.print("Modified array: ");
        for (int i = 0; i < newSize; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}


    
