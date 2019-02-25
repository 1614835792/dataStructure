package com.dataStructure.queue;
//循环队列
public class LoopQueue<E> implements Queue<E> {
    private E[]data;
    private int front,tail; //分别为队列的头和尾部的索引
    private int size;
    public LoopQueue(int capacity){
         data=(E[])new Object[capacity+1];
         front=0;
         tail=0;
         size=0;
    }
    public LoopQueue(){
        this(10);
    }
    public  int getCapacity(){
        return data.length-1;
    }
    @Override
    public void enqueue(E e) {
       if((tail+1)%data.length==front){
           resize(getCapacity()*2);
       }
       data[tail]=e;
       tail=(tail+1)%data.length;
    }
 
    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }
    private void resize(int newCapacity){
        E[] newData=(E[])new Object[newCapacity+1];
        for(int i=0;i<size;i++){
              newData[i]=data[(front+i)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }
}
