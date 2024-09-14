//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        int posIndex = 0, negIndex = 0, i = 0;
        while (posIndex < positive.size() && negIndex < negative.size()) {
            arr.set(i++, positive.get(posIndex++)); 
            arr.set(i++, negative.get(negIndex++)); 
        }
        while (posIndex < positive.size()) {
            arr.set(i++, positive.get(posIndex++));
        }
        while (negIndex < negative.size()) {
            arr.set(i++, negative.get(negIndex++));
        }
    }
}