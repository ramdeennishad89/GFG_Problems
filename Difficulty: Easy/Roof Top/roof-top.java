//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Your code here
        int count = 0; // for counting consecutive smaller buildings
        int n = arr.length;
        if (n <= 1) return 0; // return 0 if there's only one building
    
        int maxi = 0; // Initialize maxi to 0
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++; // Increase count for consecutive smaller buildings
            } else {
                count = 0; // Reset count when the sequence breaks
            }
            maxi = Math.max(maxi, count); // Update maxi with the highest count
        }
    
        return maxi; // Return the maximum count found
    }
}