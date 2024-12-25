//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        Set<Integer> r=new HashSet<>();
        Set<Integer> c=new HashSet<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
        
               if(mat[i][j]==0){
                   r.add(i);
                   c.add(j);
                   int k=i;
                    while(k>=0){
                       mat[k][j]=0;
                       k--;
                   }
                   k=j;
                   while(k>=0){
                       mat[i][k]=0;
                       k--;
                   }
                   
               } 
               
               if(r.contains(i) || c.contains(j)){
                   mat[i][j]=0;
               }
            }
        }
    }
}