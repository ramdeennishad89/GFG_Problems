//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        // Your code goes here
        int dp[][]=new int[pattern.length()+1][str.length()+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return recurse(0,0,pattern,str,dp);
  
    }
    
    int recurse(int i,int j,String pat,String str,int dp[][]){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i>=pat.length() && j>=str.length()) return 1;
        else if (i<pat.length()){
            int a=0,b=0;
            if(j<str.length() && pat.charAt(i)==str.charAt(j))a= recurse(i+1,j+1,pat,str,dp);
            else if(pat.charAt(i)=='*'){
                a=recurse(i+1,j,pat,str,dp);
               if(j<str.length()) b=recurse(i,j+1,pat,str,dp);
            }
            else if(pat.charAt(i)=='?' && j<str.length()){
                a=recurse(i+1,j+1,pat,str,dp);
            }
            dp[i][j]=Math.max(a,b);
        }
        return dp[i][j];
    }
}
