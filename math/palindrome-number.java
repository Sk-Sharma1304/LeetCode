class Solution {
    public boolean isPalindrome(int x) {
      int k=x;
      int s=0;
      while(x>0){
int q=x%10;
s=s*10+q;
x/=10;
      }
      return(s==k);  
    }
}