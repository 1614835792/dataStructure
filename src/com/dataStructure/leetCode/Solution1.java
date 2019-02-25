package com.dataStructure.leetCode;


public class Solution1 {
    static int arr[]=new int[2];
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]!=nums[j]){
                    if(nums[i]+nums[j]==target){
                        arr[0]=i;
                        arr[1]=j;
                        return arr;
                    }
                }
            }
        }
        return null;
    }
    public static void main(String args[]){
        Solution1 solution1=new Solution1();
        int a[]={2,7,11,15};
        for(int i=0;i<arr.length;i++){
            System.out.println(solution1.twoSum(a,9)[i]);
        }
    }
}
