class Solution {
    public int substrCount(String s, int k) {
        // code here
         int n=s.length();
         int count=0;
         for(int i=0;i<=n-k;i++){
             String str=s.substring(i,i+k);
             
             if(distinctChar(str,k)){
                 count++;
             }
         }
         return count;
    }
    
    boolean distinctChar(String str,int k){
        int n=str.length();
        HashSet<Character>set=new HashSet<>();


        for(char ch:str.toCharArray()){
            set.add(ch);
        }
        
   return (set.size()==k-1);
    }
}