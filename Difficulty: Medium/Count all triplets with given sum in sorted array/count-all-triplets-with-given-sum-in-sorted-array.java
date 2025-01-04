//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        Map<Integer, Integer> freq = new HashMap<>();
        for (int e : arr) {
            freq.put(e, freq.getOrDefault(e, 0) + 1);
        }

        int ans = 0;

        // Loop through each pair of elements in arr
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.get(arr[i]) - 1); // Decrease the frequency of the current element
            for (int j = 0; j < i; j++) {
                int lookfor = target - arr[i] - arr[j]; // Calculate the value we're looking for
                if (freq.containsKey(lookfor)) {
                    ans += freq.get(lookfor); // Add the frequency of the matching value
                }
            }
        }
        
        return ans;
    }
}