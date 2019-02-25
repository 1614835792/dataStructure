package com.dataStructure.leetCode;


import java.util.ArrayList;
import java.util.TreeMap;

public class Solution350 {
        public int[] intersect(int[] nums1, int[] nums2) {
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int num:nums1){
               if(!map.containsKey(num)){
                   map.put(num,1);
               }else{
                   map.put(num,map.get(num)+1);
               }
            }
            ArrayList<Integer> list=new ArrayList();
            for(int num:nums2){
                if(map.containsKey(num)){
                    list.add(num);
                    map.put(num,map.get(num)-1);
                    if(map.get(num)==0){
                        map.remove(num);
                    }
                }
            }
            int []ints=new int[list.size()];
            for(int i=0;i<list.size();i++){
                ints[i]=list.get(i);
            }
            return ints;
        }
    public static void main(String args[]){
        int nums1[]={1,2,1,2};
        int nums2[]={2,2};
        int nums4[]={4,9,5,9,4,9,4};
        int nums3[]={9,4,9,8,4,9};
        Solution350 solution=new Solution350();
        int[] arr=solution.intersect(nums1,nums2);
        for(int array:arr){
            System.out.print(array+" ");
        }
        System.out.println();
        int[] arr2=solution.intersect(nums3,nums4);
        for(int array:arr2){
            System.out.print(array+" ");
        }
    }
}
