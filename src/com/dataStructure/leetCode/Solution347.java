package com.dataStructure.leetCode;
import java.util.*;

public class Solution347 {
    public class Freq implements Comparable<Freq>{
        int e,freq;
        public Freq(int e,int freq){
            this.e=e;
            this.freq=freq;
        }
        @Override
        public int compareTo(Freq o) {
            if(this.freq<o.freq){
                return -1;
            }
            else if(this.freq>o.freq){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        List list=new ArrayList();
        for(int num:nums){
            if(!treeMap.containsKey(num)){
                treeMap.put(num,1);
            }else{
                treeMap.put(num,treeMap.get(num)+1);
            }
        }
        PriorityQueue <Freq>pq=new PriorityQueue();
        Iterator iterator=treeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry= (Map.Entry) iterator.next();
            Integer key=Integer.parseInt(entry.getKey().toString());
            Integer value=Integer.parseInt(entry.getValue().toString());
            Freq freq=new Freq(key,value);
            if(pq.size()<k){
                pq.add(freq);
            }else{
                if(value>pq.peek().freq){
                    pq.add(freq);
                    pq.remove();
                }
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.remove().e);
        }
        return list;
    }
    public static void main(String args[]){
       Solution347 solution=new Solution347();
        int nums[] = {1,1,1,2,2,3}, k = 2;
        System.out.println(solution.topKFrequent(nums,k));
    }
}
