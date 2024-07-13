//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int dfs(int i,int j,int grid[][],int color,int n){
        if(i<0 || j<0 || i==n || j==n || grid[i][j]!=1) return 0;
        grid[i][j]=color;
        int currArea=1;
        currArea+=dfs(i+1,j,grid,color,n);
        currArea+=dfs(i-1,j,grid,color,n);
        currArea+=dfs(i,j+1,grid,color,n);
        currArea+=dfs(i,j-1,grid,color,n);
        return currArea;
    }

    public int MaxConnection(int grid[][]) {
        // Your code here
         int color=2,maxArea=1,n=grid.length;
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,0);
        //coloring
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int currArea=dfs(i,j,grid,color,n);
                    hm.put(color,currArea);
                    color++;
                }
            }
        }
        //finding maxArea
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //finding maxArea by connecting using 0
                if(grid[i][j]==0){
                    int area=1;
                    Set<Integer> h=new HashSet<>();
                    if(i>0){
                        area+=hm.get(grid[i-1][j]);
                        h.add(grid[i-1][j]);
                    }
                    if(j>0 && !h.contains(grid[i][j-1])){
                        area+=hm.get(grid[i][j-1]);
                        h.add(grid[i][j-1]);
                    }
                    if(i<n-1 && !h.contains(grid[i+1][j])){
                        area+=hm.get(grid[i+1][j]);
                        h.add(grid[i+1][j]);
                    }
                    if(j<n-1 && !h.contains(grid[i][j+1])){
                        area+=hm.get(grid[i][j+1]);
                    }
                    maxArea=Math.max(area,maxArea);
                }
                //finding maxArea without zero
                maxArea=Math.max(maxArea,hm.get(grid[i][j]));
            }
        }
        return maxArea;
    }
}