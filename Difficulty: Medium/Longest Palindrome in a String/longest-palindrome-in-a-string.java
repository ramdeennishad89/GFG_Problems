//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static  String find(String s, int x, int y){
        String temp="";
        while(x>=0 && y<s.length() && s.charAt(x)==s.charAt(y)){
            temp=s.substring(x,y+1);
            x--;
            y++;
        }
        return temp;
    }
    
    
    
    static String longestPalindrome(String s) {
        int ans=0;
        String temp="";
        for(int i=0;i<s.length()-1;i++){
            String a=find(s, i, i);
            String b=find(s, i, i+1);
            if(a.length()>ans){
                temp=a;
                ans=a.length();
            }
            if(b.length()>ans){
                temp=b;
                ans=b.length();
            }
        }
        return temp;
        
    }
}