//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        final int MOD = 1000000007;
        if (n <= 2)
            return 1;

        int p0 = 1, p1 = 1, p2 = 1;
        for (int i = 3; i <= n; i++) {
            int p3 = (p1 + p0) % MOD;
            p0 = p1;
            p1 = p2;
            p2 = p3;
        }

        return p2;
    }
    
}
