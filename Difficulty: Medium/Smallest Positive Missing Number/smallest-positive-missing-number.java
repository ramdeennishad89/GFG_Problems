//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the smallest positive number missing from the array.
    void swap(int i, int j, int arr[]){
	   if(arr[i]==arr[j]) {
		   arr[i]=10000001;
		   
	   }else {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
	   }       
    }

    public int missingNumber(int[] arr) {
        int n=arr.length;
      
        for(int i=0;i<n;i++){       	
            if( arr[i]>0 && arr[i]<n && arr[i]!=i+1 ){            	
                swap(i,arr[i]-1, arr);        
                i--;              
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1)return i+1;
            max=Math.max(max, arr[i]);
        }
        
        return max+1;
    }
}