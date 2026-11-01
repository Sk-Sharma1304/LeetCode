class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    void backtrack(int candidate[],int target,int index,List<Integer>curr,List<List<Integer>>result){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target<0||index>=candidate.length)
        return;
        curr.add(candidate[index]);
        backtrack(candidate,target-candidate[index],index,curr,result);
        curr.remove(curr.size()-1);
        backtrack(candidate,target,index+1,curr,result);
    
    }
    public static void main(String args[]){
        Solution sol=new Solution();
        int candidates[]={2,3,6,7};
        int target=7;
        System.out.println(sol.combinationSum(candidates,target));
    }
}