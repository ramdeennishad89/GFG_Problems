//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public static void sortbyColumn(int a[][], int c){      
      Arrays.sort(a, (x, y) -> Integer.compare(x[c],y[c]));  
    }
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        int n = arr.length;
        int [][]a = new int[n][2];
        for(int i = 0; i < n; i++){
            a[i][0] = arr[i];
            a[i][1] = i;
        }
        sortbyColumn(a,0);
        ArrayList<List<Integer> > ans 
            = new ArrayList<List<Integer> >(); 
        for(int i = 0; i < n; i++){
            int j = i + 1;
            int k = n - 1;
            
            while(j < k){
                int sum = a[i][0] + a[j][0] + a[k][0];
                if(sum == 0){
                    List<Integer>s = new ArrayList<>();
                    s.add(a[i][1]);
                    s.add(a[j][1]);
                    s.add(a[k][1]);
                    Collections.sort(s);
                    ans.add(s);
                    for(int u = j + 1; u < k; u++){
                        if(a[i][0] + a[u][0] + a[k][0] == 0){
                            List<Integer>ss = new ArrayList<>();
                            ss.add(a[i][1]);
                            ss.add(a[u][1]);
                            ss.add(a[k][1]);
                            Collections.sort(ss);
                            ans.add(ss);
                        }
                    }
                    k--;
                }else if(sum > 0) k--;
                else j++;
            }
        }
        return ans;
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

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends