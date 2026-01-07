package Kunal_DSA_Playlist.BinarySearch_In2DArray;
import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        int[] result = search(arr, 37);
        System.out.println(Arrays.toString(result));

    }
    static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length - 1;                                          //taking the last column
                                                                             // using matrix.length this works only when N*N matrix is there for N*M matrix use col = M - 1
        while(row < matrix.length && col >= 0){
            if( matrix[row][col] == target){
                return new int[]{row , col};
            }
            else if(matrix[row][col] < target){
                row++;
            }
            else {
                col--;
            }
        }
        return new int[] {-1,-1};
    }
}
