class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        java.util.Stack<Character> st = new java.util.Stack<>();

        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // if removals left, remove from end
        while (k > 0) {
            st.pop();
            k--;
        }

        // build result and remove leading zeros
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);

        // remove leading zeros
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;

        String res = sb.substring(i);
        return res.length() == 0 ? "0" : res;
    }
}