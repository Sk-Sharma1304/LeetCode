class Solution {
    public List<String> addOperators(String num, int target) {
        List<String >result=new ArrayList<>();
        backtrack(result,"",num,target,0,0,0);
        return result;
    }
    void backtrack(List<String>res,String path,String num,int target,int index,long eval,long prev){
        if(index==num.length()){
            if(eval==target){
                res.add(path);
            }
            return;
        }
        for(int i=index;i<num.length();i++){
            if(i!=index && num.charAt(index)=='0'){
            break;
            }
            String currStr=num.substring(index,i+1);
            long curr=Long.parseLong(currStr);
            if(index==0){
                backtrack(res,currStr,num,target,i+1,curr,curr);
            }
            else{
                backtrack (res,path+"+"+currStr,num,target,i+1,eval+curr,curr);
                backtrack (res,path+"-"+currStr,num,target,i+1,eval-curr,-curr);
                backtrack (res,path+"*"+currStr,num,target,i+1,eval-prev+prev*curr,prev*curr);
                
            }
        }
    }
}