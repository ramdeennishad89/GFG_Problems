//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate the current area
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;
            
            // Update the max area if we find a larger one
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer that points to the shorter line
            if (arr[left] < arr[right]) {
                left++;  // Move left pointer rightwards
            } else {
                right--;  // Move right pointer leftwards
            }
        }
        
        return maxArea;  // Return the maximum area found
    }
}