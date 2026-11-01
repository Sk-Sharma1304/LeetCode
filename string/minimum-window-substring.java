import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) return "";
        
        HashMap<Character, Integer> need = new HashMap<>();
        
        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();   // Unique characters needed
        int formed = 0;               // How many unique chars matched

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if current character fulfills requirement
            if (need.containsKey(c) &&
                window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Try shrinking window
            while (left <= right && formed == required) {

                char ch = s.charAt(left);

                // Update minimum length
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove left character
                window.put(ch, window.get(ch) - 1);

                if (need.containsKey(ch) &&
                    window.get(ch) < need.get(ch)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}