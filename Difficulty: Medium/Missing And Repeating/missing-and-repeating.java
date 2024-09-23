//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int[] result = new int[2];
        Set<Integer> uniqueNumbers = new TreeSet<>();
        
        result[1] = 1;
        
        for (int number : arr) {
            if (!uniqueNumbers.add(number)) {
                result[0] = number; // This is the first duplicate
            }
        }
        
        for (int num : uniqueNumbers) {
            if (num == result[1]) {
                result[1]++;
            } else {
                break; // Stop if we find a number that isn't consecutive
            }
        }
        return result;
    }
}