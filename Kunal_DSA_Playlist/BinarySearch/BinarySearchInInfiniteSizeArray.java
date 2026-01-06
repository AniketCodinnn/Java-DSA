package Kunal_DSA_Playlist.BinarySearch;

//simply we can't use length method here so first we need to find the start and end index
public class BinarySearchInInfiniteSizeArray {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,90,100,130,140,160,170,190,200,210,220,230,250,260,270,280,290,300};
        int target = 10;
        System.out.println(ans(arr,target));
    }
    static int ans(int[] arr, int target){
        //first find the range
        //start with the box of size 2
        int start = 0;
        int end = 1;

        //condition for the target to lie in the range
        while(target > arr[end]){
            int temp = end +1;  //this is my new start . Used another variable name as we are using start below this so can't update start now
            //double the size of box
            //end = previous end + sizeOfBox*2
            end = end + (end - start + 1) *2;
            start = temp;
        }
        return binarysearch(arr,target, start,end);
    }

    static int binarysearch(int[] arr, int target, int start, int end){
//int mid = (start + end)/2; might be possible that (start + end) exceed the range of int in java .length -1;
        while(start <=end){
            int mid = start + (end - start)/2;
            if(target>arr[mid]){
                start = mid+1;
            }
            else if(target<arr[mid]){
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;  //loop overed means no value has been found that means the target doesn't exist
    }
}
