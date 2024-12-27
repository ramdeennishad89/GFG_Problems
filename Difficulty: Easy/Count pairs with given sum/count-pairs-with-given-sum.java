//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {

    int countPairs(int arr[], int k) {
        // Your code here
        int cnt=0;
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int a:arr)map.put(a,map.getOrDefault(a,0)+1);
        
        for(int i=0;i<n;i++){
            int temp=k-arr[i];
            if(temp!=arr[i] && map.containsKey(temp))cnt+=map.get(temp);
            if(temp==arr[i] && map.containsKey(temp) ){
                cnt+=map.get(temp);
                cnt--;
            }
        }
        return cnt/2;
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends