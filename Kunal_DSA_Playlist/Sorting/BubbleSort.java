package Kunal_DSA_Playlist.Sorting;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 76,32,13,53,64,235,64,22};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr){
        boolean swapped;                  //used this swapped variable to ensure that loop stops when swapping is not done in a particular pass
        //run the steps n-1 times (pass)
        for (int i = 0; i < arr.length - 1; i++){
            swapped = false;

            //for each step, max intem will come at the last respective index
            for( int j = 1; j < arr.length - i; j++){
                //swap if the item is smaller than the previous item
                if(arr[j] <  arr[j - 1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            //if you did not swap for a particular value of i , it means the array is sorted hence stop the program
            if(swapped == false){
                break;
            }
        }
    }
}
