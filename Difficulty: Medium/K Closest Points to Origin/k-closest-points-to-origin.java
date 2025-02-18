//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    class Pair {
        int x, y;
        int dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        int N = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for(int i = 0; i < N; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = (x*x+y*y);
            pq.add(new Pair(x, y, distance));
        }
        
        
        int i = 0;
        int[][] res = new int[k][2];
        while(i < k) {
            Pair p = pq.peek();
            res[i][0] = p.x;
            res[i][1] = p.y;
            pq.poll();
            ++i;
        }
        return res;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends