//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        // Find the row which can have the value of x using first element of each row
        int row = mat.length-1;
        for(int i=-1;i<mat.length-1;i++){
            if(mat[i+1][0] > x){
                row = i;
                if(row < 0)
                    row = 0;
                break;
            }
        }
        // Consumed Binary search algorithm to find in sorted array
        int l = 0, r = mat[row].length-1, mid = 0;
        while(l <= r) {
            mid = l + (r-l)/2;
            if(mat[row][mid] == x) {
                return true;
            } else if(mat[row][mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
