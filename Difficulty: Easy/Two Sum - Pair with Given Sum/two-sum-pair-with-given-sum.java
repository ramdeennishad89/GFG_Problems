//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().twoSum(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        // Using HashSet to store elements
        HashSet<Integer> set = new HashSet<>();
        
        // Adding all array elements to the HashSet
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        
        // Iterating through the HashSet
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int val = it.next();
            int remaining = target - val;
            
            // Checking if the complement exists and is not the same as the current element
            if (set.contains(remaining) && remaining != val) return true;
        }
        
        // If no pair found
        return false;
    }
}