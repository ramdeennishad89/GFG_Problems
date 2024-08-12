//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int len=arr1.length+arr2.length;  //getting total length of merged array
        int idx1=0,idx2=0,ans=0,i=0;
        while(idx1<arr1.length && idx2<arr2.length && i<len)
        {
            int curr=0;
            if(arr1[idx1]<=arr2[idx2])  //if arr1 element is smaller
            {
                curr=arr1[idx1];  //set current element as arr1 element
                idx1++;
            }else
            {
                curr=arr2[idx2];  //else set current element as arr2 element
                idx2++;
            }
            if(i==(len/2 -1)|| i==(len/2))
            {
                ans+=curr;  //if current element is middle, add to answer
            }
            i++;
        }
        return ans;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends