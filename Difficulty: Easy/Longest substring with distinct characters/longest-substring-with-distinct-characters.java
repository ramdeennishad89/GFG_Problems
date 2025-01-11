//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int ans = 0;
        int curr = 0;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = s.length();
        for(int i=0;i<end;i++)
        {
            if(set.contains(s.charAt(i)))
            {
                while(start<i && s.charAt(start)!=s.charAt(i))
                {
                    set.remove(s.charAt(start++));
                }
                set.remove(s.charAt(start));
                set.add(s.charAt(i));
                start++;
                curr = set.size();
            }
            else
            {
                curr++;
                set.add(s.charAt(i));
            }
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}