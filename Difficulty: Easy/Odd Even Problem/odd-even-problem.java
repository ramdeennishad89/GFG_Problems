//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
          int[] count = new int[26];

        // Calculate frequencies of characters
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int x = 0, y = 0;

        // Iterate over the English alphabet
        for (int i = 0; i < 26; i++) {
            // Check even position in the alphabet
            if ((i + 1) % 2 == 0) {
                if (count[i] > 0 && count[i] % 2 == 0) {
                    x++;
                }
            } 
            // Check odd position in the alphabet
            else {
                if (count[i] > 0 && count[i] % 2 != 0) {
                    y++;
                }
            }
        }

        // Return "EVEN" if the sum of x and y is even; otherwise, return "ODD"
        return (x + y) % 2 == 0 ? "EVEN" : "ODD";
    }
}
