package Kunal_DSA_Playlist.BinarySearch_In2DArray;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(search(arr,9)));

    }

    //search in the row provided between the columns provided
    static int[] binarysearch(int[][] matrix, int row, int colStart, int colEnd, int target){
        while(colStart <= colEnd){
            int mid = colStart + (colEnd - colStart)/2;
            if(matrix[row][mid] == target){
                return new int[] {row,mid};
            }
            else if( matrix[row][mid] < target){
                colStart = mid+ 1;
            }
            else {
                colEnd = mid - 1;
            }
        }
        return new int[] {-1,-1};
    }
    static int[] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;  //be cautious , matrix may be empty(it may be a single dimension array) so add check

        if(rows == 1){
            return binarysearch(matrix,0,0,cols-1, target);  //this is the check, this is the edge case handling

        }
        int rowStart = 0;
        int rowEnd =  rows -1;

        int colMid = cols / 2;

        //run the loop till 2 rows are remaining
        while(rowStart < (rowEnd - 1)){   //while this is true it will be having more 2 rows , which we are trying to eliminate
            int mid = rowStart + (rowEnd - rowStart)/2;            // ultimately come up with only 2 rows whose condition will be rowStart == (rowEnd - 1)
            if(matrix[mid][colMid] == target){
                return new int[] {mid , colMid};
            }
            else if(matrix[mid][colMid] < target){    //ignore the above rows
                rowStart = mid;
            }
            else{                    //ignore the below rows
                rowEnd = mid;
            }
        }
        //now we have two rows
        //check whether the target is in the col of 2 rows
        if(matrix[rowStart][colMid] == target){
            return new int[] {rowStart, colMid};
        }
        if(matrix[rowStart + 1][colMid] == target){
            return new int[] {rowStart + 1, colMid};
        }

        //search in 1st half
        if(target <= matrix[rowStart][colMid - 1]){
            return binarysearch(matrix, rowStart, 0, colMid - 1, target);
        }

        //search in 2nd half
        if(target >= matrix[rowStart][colMid + 1] && target <= matrix[rowStart][cols - 1] ){
            return binarysearch(matrix, rowStart, colMid + 1, colMid - 1, target);
        }

        //search in 3rd half
        if(target <= matrix[rowStart + 1][colMid - 1]){
            return binarysearch(matrix, rowStart + 1, 0, colMid - 1, target);

        }
        //search in 4th half
        else{
            return binarysearch(matrix, rowStart + 1, colMid + 1, colMid - 1, target);

        }

    }
}
