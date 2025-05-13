//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nCr(int n, int r) {
        // code here
        long ans = 1l;
        for(int i=0; i<r; i++){
            ans = ans * (n-i);
            ans = ans / (i+1);
        }
        return (int)ans;
    }
}