class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int []>ans=new ArrayList<>();
        ans.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int curr[]=intervals[i];
            int prev[]=ans.get(ans.size()-1);

            if(curr[0]<=prev[1])
            prev[1]=Math.max(prev[1],curr[1]);

            else
            ans.add(curr);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}