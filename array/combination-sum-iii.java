import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int start, int k, int n, List<Integer> current, List<List<Integer>> result) {
        // Base condition: if we picked k numbers
        if (current.size() == k) {
            if (n == 0) result.add(new ArrayList<>(current));
            return;
        }

        // Try numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            if (i > n) break;  // pruning: no need to go further
            current.add(i);
            backtrack(i + 1, k, n - i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
