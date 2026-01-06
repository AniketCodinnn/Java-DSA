package Kunal_DSA_Playlist.BinarySearch;
//Leetcode Hard Problem no 1095
//https://leetcode.com/problems/find-in-mountain-array/description/
// The approach used here is totally correct but in the question we can't access the array like arr[i] we have to use the api
// so we have to use MountainArray.get(index) instead of arr[index] and MountainArray.length() instead of arr.length
public class FindInMountainArray_Leetcode_Hard {
    public static void main(String[] args) {

    }
    static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        //start searching in the ascending part
        int firstTry = orderagnosticBS(arr, target, 0, peak);
        //if peak is found in asc part return it, else search in desc part
        if(firstTry != -1){
            return firstTry;
        }
        //try to search in second half
        return orderagnosticBS(arr, target, peak+1, arr.length -1 );
    }
    static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length -1;
        while(start < end){        // if the = condition is there then it will become infinite loop
            int mid = start + (end -start)/2;
            if(arr[mid] > arr[mid + 1]){
                //we are in decreasing part of aray;
                //this may be the ans , but look at left
                //this is why end ! = mid -1;
                end = mid;
            }
            else{
                //we are in ascending part of array
                start = mid + 1; // bcoz we know that mid + 1 element > mid element
            }
            //in the end start == end pointing to the largest number bcoz of the 2 checks
            //start and end are always trying to find the max element in the above 2 checks
            //hence, when they are pointing to just one element , that is the max element as that is what the checks says
            //more elaboration: at evey point of time for start and end, they have the best possible answer till that time
            // and if we are saying that only one item is remaining hence bcoz of the above line that is the best possible answer

        }
        return start; // we can return end aswell as start = end
    }
    static int orderagnosticBS(int[] arr, int target, int start, int end){
//Finding whether the array is sorted in ascending or descending order
        boolean isAsc = arr[start] <arr[end];

        while(start <= end){
            int mid = start + (end - start)/2;
//Common case for both ascending or descending
            if(arr[mid ] == target){
                return mid;
            }
            if(isAsc){
                if(target>arr[mid]){
                    start = mid+1;
                }
                else {
                    end = mid - 1;
                }
            }
            else {
                if(target<arr[mid]){
                    start = mid+1;
                }
                else{
                    end = mid - 1;
                }
            }

        }
        return -1;

    }
}
