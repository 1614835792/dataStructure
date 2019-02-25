package com.dataStructure.SegmentTree;

public class Main {
    public static void main(String args[]){
        Integer[]nums={-2,0,3,-5,2,-1};
        SegmentTree<Integer>segmentTree=new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merger(Integer a, Integer b) {
                return a+b;
            }
        });
        //上面可以用lamabda表达式
        // SegmentTree segmentTree1=new SegmentTree<>(nums,(a,b)->a+b);
        System.out.println(segmentTree);
    }
}
