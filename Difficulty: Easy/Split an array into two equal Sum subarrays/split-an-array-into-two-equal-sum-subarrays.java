//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, we can't split it into two equal parts
        if (totalSum % 2 != 0) {
            return false;
        }
        
        // The target sum for each subarray
        int targetSum = totalSum / 2;
        int currentSum = 0;
        
        // Traverse the array to check for valid split
        for (int num : arr) {
            currentSum += num;
            if (currentSum == targetSum) {
                return true;
            }
        }
        
        // If no valid split is found
        return false;
    }
}