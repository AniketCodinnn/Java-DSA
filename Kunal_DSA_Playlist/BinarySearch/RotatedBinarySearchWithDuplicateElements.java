package Kunal_DSA_Playlist.BinarySearch;

public class RotatedBinarySearchWithDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));

    }
    static int search(int[] arr, int target){
        int pivot = findPivot(arr);

        //if you didn't find the pivot, it means the array is not rotated
        if(pivot == -1){
            //just do normal binary search as array is not rotated
            return binarySearch(arr, target, 0, arr.length -1);
        }
        //if pivot is found means that we have found 2 ascending sorted array
        //and here we have 3 cases
        //case 1
        if(arr[pivot] == target){
            return pivot;
        }
        //case 2
        else if(target >= arr[0]){
            return binarySearch(arr, target, 0 , pivot -1);
        }
        //case 3
        //target < start  so simply search in the second half of array i.e, from (pivot + 1 to end) bcoz all
        //elements from start till pivot are going to be > target
        return binarySearch(arr, target, pivot +1, arr.length-1);

    }
    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;

            if(target< arr[mid]){
                end = mid -1;
            }
            else if(target > arr[mid] ){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }


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
