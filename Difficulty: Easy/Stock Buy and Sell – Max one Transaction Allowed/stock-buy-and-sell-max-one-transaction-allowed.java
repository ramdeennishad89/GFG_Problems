//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        // Length of the prices array
        int n = prices.length;
        int[] suffixMax = new int[n];
        int[] prefixMin = new int[n];
    
        // Calculate prefixMin array (minimum price up to index i)
        prefixMin[0] = prices[0];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prices[i], prefixMin[i - 1]);
        }
    
        // Calculate suffixMax array (maximum price from index i to end)
        suffixMax[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(prices[i], suffixMax[i + 1]);
        }
    
        // Calculate maximum profit
        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, suffixMax[i] - prefixMin[i]);
        }
    
        return profit;
    }
}