//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

import java.util.Arrays; // Import statement must be outside the class

class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;

        // Step 1: Find the dip
        int dip = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                dip = i;
                break;
            }
        }

        // Step 2: Handle the case where the array is in descending order
        if (dip == -1) {
            Arrays.sort(arr);
            return;
        }

        // Step 3: Find the smallest number greater than arr[dip] to its right
        for (int i = n - 1; i > dip; i--) {
            if (arr[i] > arr[dip]) {
                // Swap arr[i] and arr[dip]
                int temp = arr[i];
                arr[i] = arr[dip];
                arr[dip] = temp;
                break;
            }
        }

        // Step 4: Sort the subarray to the right of the dip
        Arrays.sort(arr, dip + 1, n);
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends