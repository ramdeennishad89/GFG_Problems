//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        int[] lps = new int[pat.length()];
        lps[0] = 0;
        int i = 1;
        int length = 0;
        
        while(i < pat.length()) {
            if(pat.charAt(i) == pat.charAt(length)) {
                lps[i++] = ++length;
            } else {
                if(length == 0) lps[i++] = 0;
                else length = lps[length - 1];
            }
        }
        
        i = 0;
        int j = 0;
        while(i < txt.length()) {
            if(txt.charAt(i) != pat.charAt(j)){
                if(j == 0) ++i;
                else j = lps[j - 1];
            } 
            else { ++i; ++j; } 
            if(j == pat.length()) {
                result.add(i - j);
                j = lps[j-1];
            }
        }
        
        return result;
    }
}