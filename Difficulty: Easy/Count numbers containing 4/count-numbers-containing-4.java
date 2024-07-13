//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {
        // code here
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            count += countDigits(i, 4);
        }
        
        return count;
    }
     private static int countDigits(int number, int digit) {
        int count = 0;
        
        while (number > 0) {
            if (number % 10 == digit) {
                count++;
                break;
            }
            number /= 10;
        }
        
        return count;
    }
}
