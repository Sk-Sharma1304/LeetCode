class Solution {
    public String reverseWords(String s) {
        String[] str1 = s.trim().split("\\s+");
        StringBuilder str = new StringBuilder();
        int l = str1.length;
        
        for (int i = l - 1; i >= 0; i--) {
            str.append(str1[i]);
            if (i > 0) {
                str.append(" ");
            }
        }
        return str.toString();
    }
}
