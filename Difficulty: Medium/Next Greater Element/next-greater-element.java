//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        
        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements that are not greater than the current element
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            // If the stack is empty, no greater element exists; otherwise, top is next greater
            result[i] = st.isEmpty() ? -1 : st.peek();
            
            // Push current element onto the stack for future comparisons
            st.push(arr[i]);
        }
        
        // Convert the result array to ArrayList
        for (int num : result) {
            list.add(num);
        }
        
        return list;
    }
}