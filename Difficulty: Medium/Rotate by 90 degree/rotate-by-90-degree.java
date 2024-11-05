//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
     
    static void swapIn2DMatrix(int[][] mat, int i, int j){
        int val = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = val;
    }
    
    static void transposeMatrix(int[][] mat, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                swapIn2DMatrix(mat, i, j);
            }
        }
    }
    
    static void reverseRow(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            int val = arr[i];
            arr[i] = arr[j];
            arr[j] = val;
            i++;j--;
        }
    }
    
    static void rotate(int mat[][]) {
        // Code Here
        int n = mat.length;
        int m = mat[0].length;
        transposeMatrix(mat, n, m);
        for(int[] row : mat){
            reverseRow(row);
        }
        return ;
    }
}