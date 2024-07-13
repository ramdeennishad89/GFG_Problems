//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    
    Boolean binSearch(long arr[], long x){
        int low = 0;
        int high= arr.length-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid] == x) return true;
            else if(x<arr[mid]) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
    
    
    long findSwapValues(long A[], int n, long B[], int m) {
        // Your code goes here
        Arrays.sort(A);
        Arrays.sort(B);
        long s1=0, s2=0;
        for(long x:A) s1+=x;
        for(long x:B) s2+=x;
        if((s1+s2)%2==1) return -1;
        long avg= (s1+s2)/2;
        long diff=avg- Math.min(s1,s2);
        
        for(long x:A){
            if(binSearch(B, x+diff) || binSearch(B, x-diff)) return 1;
        }
        
        return -1;
        
        
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends