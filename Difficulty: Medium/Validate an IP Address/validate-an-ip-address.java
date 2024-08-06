//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        // Write your code here
        String str[]=s.split("\\.");
        if(str.length!=4)
        return false;
        else
        {
            for(int i=0;i<str.length;i++)
            {

               //checking for leading zeroes
                if(str[i].length()>1 && Integer.parseInt(str[i])<10)
                return false;
                if(str[i].length()!=0)
                {

                    //checking range
                    if(!(Integer.parseInt(str[i])>=0 && Integer.parseInt(str[i])<=255))
                    return false;
                }
                else
                return false;
            }
        }
        return true;
    }
}