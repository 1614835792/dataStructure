package com.dataStructure.leetCode;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution349 {
    //求两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList <Integer>arrayList=new ArrayList<Integer>();
        TreeSet treeSet=new TreeSet();
        for(int num1:nums1){
            treeSet.add(num1);
        }
        for(int num2:nums2){
            if(treeSet.contains(num2)){
                arrayList.add(num2);
                treeSet.remove(num2);
            }
        }
        System.out.println(arrayList);
        int []ints=new int[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            ints[i]=arrayList.get(i);
        }
        return ints;
    }
    public static void main(String args[]){
       int nums1[]={1,2,1,2};
       int nums2[]={2,2};
        Solution349 solution349=new Solution349();
        System.out.println(solution349.intersection(nums1,nums2));
    }
}
