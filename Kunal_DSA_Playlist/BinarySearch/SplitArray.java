package Kunal_DSA_Playlist.BinarySearch;
//leetcode Hard problem 410
//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArray {
    public static void main(String[] args) {

    }
    static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++){
            start = Math.max(start, nums[i]);  //in the end of the loop this will contain the max item from the array
            end += nums[i];
        }
        // binary search
        while(start < end){
            //try for the mid as potential ans
            int mid = start + (end-start)/2;

            //calculate how many pieces we can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for(int num : nums){
                if( sum + num > mid){
                    //we cannot add this in this subarray , so make a new subarray
                    //say we add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                }
                else{
                    sum = sum + num;
                }
            }
            if(pieces > m){
                start = mid +1;
            }
            else{
                end = mid;
            }
        }
        return end;    //here start == end
    }
}
