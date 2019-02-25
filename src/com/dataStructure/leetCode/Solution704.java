package com.dataStructure.leetCode;

public class Solution704 {
    //二分查找
    public int search(int[] nums, int target) {
        int head=0;
        int tail=nums.length-1;
        while(head<=tail){
            int mid=(head+tail)/2;
            if(nums[mid]==target){
                 return mid;
            }
            if(target<nums[mid]){
                tail=mid-1;
            }
            if(target>nums[mid]){
                head=mid+1;
            }
        }
        return -1;
    }
}
