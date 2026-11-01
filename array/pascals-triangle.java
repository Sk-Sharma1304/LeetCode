class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            row.add(1);

            long ans = 1;

            for (int j = 1; j < i; j++) {
                ans = ans * (i - j+1);
                ans = ans / j;
                row.add((int) ans);
            }

            if (i > 0) {
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }
}