class Solution {
    public boolean checkValidString(String s) {
       int h=0,l=0;
       for(char ch:s.toCharArray()){
        if(ch=='('){
            h++;
            l++;
        }
        else if(ch==')' ){
            h--;
            l--;
        }
        else{
            h++;
            l--;
        }
        if(h<0)
        return false;
        if(l<0)
        l=0;
       } 
       return l==0;
    }
}