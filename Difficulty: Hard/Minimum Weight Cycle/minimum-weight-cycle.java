//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static class Pair {
        int node, weight;
        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    public int findMinCycle(int V, int[][] edges) {
        // Build adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        int minCycle = Integer.MAX_VALUE;

        // Try each edge
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            // Temporarily remove edge (u,v)
            removeEdge(graph, u, v, w);

            // Dijkstra from u to v
            int dist = dijkstra(V, graph, u, v);
            if (dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + w);
            }

            // Restore edge
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }

    private void removeEdge(List<List<Pair>> graph, int u, int v, int w) {
        graph.get(u).removeIf(p -> p.node == v && p.weight == w);
        graph.get(v).removeIf(p -> p.node == u && p.weight == w);
    }

    private int dijkstra(int V, List<List<Pair>> graph, int src, int target) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node, d = cur.weight;

            if (node == target) return d;

            for (Pair neighbor : graph.get(node)) {
                int next = neighbor.node, weight = neighbor.weight;
                if (dist[next] > d + weight) {
                    dist[next] = d + weight;
                    pq.add(new Pair(next, dist[next]));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
};