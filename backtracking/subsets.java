class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;  
    }
    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case: add the current subset to result
        result.add(new ArrayList<>(current));

        // Recursive case: explore further elements
        for (int i = index; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);

            // Recurse with the next index
            backtrack(nums, i + 1, current, result);

            // Backtrack: remove the last added element
            current.remove(current.size() - 1);
        }
    }
}