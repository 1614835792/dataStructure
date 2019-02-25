package com.dataStructure.array;
public class Array<E> {
    private E data[];
    private int size; //size表示数组实际元素的个数
    //创建数组时的数组容量
    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }
    //默认的数组容量为10
    public Array(){
        this(10);
    }
    public Array(E []arr){
        data= (E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        size=arr.length;
    }
    //获取数组实际的长度
    public int getSize(){
        return size;
    }
    //获取数组容量
    public int getCapacity(){
       return data.length;
    }
    //数组是否为空
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    //删除最后一个元素
    public E removeLast(){
        return delete(size-1);
    }
    //删除第一个元素
    public  E removeFirst(){
       return delete(0);
    }
    //获取index索引位置的元素
    public E get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<size");
        }
        return data[index];
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return get(0);
    }
    //在数组的第index个位置添加e
    public void add(int index,E e){
         if(index<0 || index>size){
              throw new IllegalArgumentException("Add failed. Require index>=0 and index<size");
         }
         //当数组容量不够时需要进行扩容
         if(size==data.length){
             resize(2 * data.length);
         }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
    //向数组开头添加元素e
    public void addFirst(E e){
        add(0,e);
    }
    //向数组末尾添加元素e
    public void addLast(E e){
        add(size,e);
    }
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //搜索元素e
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    //删除某个位置元素
    public E delete(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<size");
        }
        E ret=data[index];
        for(int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
        data[size]=null;   //loitering objects != memory leak
        if(size<=data.length/4 && data.length /2 !=0 ){
              resize(data.length/2);
        }
        return ret;
    }
    //从数组中删除元素e
    public boolean removeElement(E e){
        int index=find(e);
        if(index!=-1){
            delete(index);
            return true;
        }
        return false;
    }
    public void set(int index,E e){
        if(index<0|| index>=size){
            throw new IllegalArgumentException("index is illegal");
        }
             data[index]=e;
    }
    public void swap(int i,int j){
        if(i<0||i>=size || j<0 ||j>=size){
          throw new IllegalArgumentException("index is illegal");
        }
        E temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    @Override
    public String toString(){
          StringBuilder sb=new StringBuilder();
          sb.append(String.format("Array: size=%d,capacity=%d\n",size,getCapacity()));
          sb.append("[");
          for(int i=0;i<size;i++){
                 sb.append(data[i]);
                 if(i!=size-1){
                     sb.append(",");
                 }
          }
        sb.append("]");
          return sb.toString();
    }
    private void resize(int newCapacity){
        E[] newData=(E[])new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
}
