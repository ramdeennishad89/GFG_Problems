//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        
        int m = x.length();
        int n = y.length();
        
        // create a dp table to store the minimum cost to string identical
        int [][] dp= new int [m+1][n+1];
        
        //fill the dp table using bottom  up approach
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0)
                    dp[i][j]=j*costY;
                else if(j==0){
                    dp[i][j]= i*costX;
                }
                else if(x.charAt(i-1) == y.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(dp[i-1][j]+costX , dp[i][j-1]+costY);
            }
        }
        
        return dp[m][n];
        
        
    }
}
