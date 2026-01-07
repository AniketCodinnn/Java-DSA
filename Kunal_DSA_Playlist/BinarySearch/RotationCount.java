package Kunal_DSA_Playlist.BinarySearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println("No of rotations : "+countRotation(arr));
    }
    static int countRotation(int[] arr){
        int pivot = findPivot(arr);
        return pivot+ 1;
    }
    //used the duplicate elements case as it works for both the cases
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end -start)/2;
            //case 1
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid; // found the ans
            }
            //case 2
            else if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            //case 3
            else if( arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip duplicates
                //but before skipping check whether they are pivot or not

                //checking whether start is pivot
                if(arr[start] > arr[start +1]){
                    return start;            //pivot
                }
                start++;           //skipping start as it is not the pivot

                //checking whether end is pivot
                if(arr[end] < arr[end-1]){
                    return end - 1;          //pivot
                }
                end--;         //skipping end as it is not the pivot
            }
            //case 4
            //finding which half of array to check for pivot element
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                //check in the RHS
                start = mid + 1;
            }
            else {
                //check in the LHS
                end = mid - 1;
            }
        }
        return -1;   //pivot not found
    }
}
