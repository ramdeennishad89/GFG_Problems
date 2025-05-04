//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans=str.length();
        int n = map.size();
        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if (map2.size() == n) {
                while (map2.size() == n) {
                    char cj = str.charAt(j);
                    int freq = map2.get(cj) - 1;
                    if (freq == 0) {
                        map2.remove(cj);
                    } else {
                        map2.put(cj, freq);
                    }
                    j++;
                }
                  ans = Math.min(ans, i - j + 2);
                
                
            }
        }

        return ans; 
    }
}