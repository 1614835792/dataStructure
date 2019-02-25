package com.dataStructure.heap;

import java.util.Random;

public class Main  {
    public static void main(String args[]){
        int n=1000000;
        MaxHeap<Integer>maxHeap=new MaxHeap<>();
        Random random=new Random();
        for(int i=0;i<n;i++){
               int a=random.nextInt(Integer.MAX_VALUE);
               maxHeap.add(a);
        }
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=maxHeap.extractMax();
        }
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                throw new IllegalArgumentException("Eroor");
            }
        }
        System.out.println("Test MaxHeap completed");
    }
}
