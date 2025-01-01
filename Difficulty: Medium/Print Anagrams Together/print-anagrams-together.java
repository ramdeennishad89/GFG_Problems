//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();
        
        for (String str: arr) {
            char[] currStr = str.toCharArray();
            Arrays.sort(currStr);
            
            String key = new String(currStr);
            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(str);
            } else {
                ArrayList<String> newList = new ArrayList();
                newList.add(str);
                anagrams.put(key, newList);
            }
        }
        
        return new ArrayList<>(anagrams.values());
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends