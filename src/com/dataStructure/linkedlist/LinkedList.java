package com.dataStructure.linkedlist;

public class LinkedList<E> {
    private Node dummyHead;  //链表虚拟的头节点（next指向链表的真正的头节点）
    private int size;  //链表个数
    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }
    //内部类 Node
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }
    //获取链表中的元素个数
    public int getSize(){
       return size;
    }
    //链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //在链表头添加元素e
       //1.将数据包装成一个节点
      // 2.该节点的next指向原来的头节点
       //3.将头节点赋值给新加的节点e，节点的长度+1
    public void addFirst(E e){
       add(0,e);
          size++;
        }
    //在链表的index位置添加新的元素e
    public void add(int index,E e){
        if(index<0 || index>size){
           throw new IllegalArgumentException("Add failed. Illegal index.");
        }
            Node prev=dummyHead;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
          /*  Node node=new Node(e);
            node.next=prev.next;
            prev.next=node.next;*/
            prev.next=new Node(e,prev.next);
            size++;
    }
    //在链表末尾添加新的元素e
    public void addList(E e){
        add(size,e);
    }
    //获得链表的第index个位置的元素
    //在链表中不是一个常用的操作，练习用：
    public E get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }
    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }
    //获得链表的最后一个元素
    public E getLast(){
        return get(size);
    }
    //修改链表的第index个位置的元素为e
    //在链表中不是一个常用的操作，练习用：
    public void set(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
       cur.e=e;
    }
    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur=dummyHead.next;
        for(int i=0;i<size;i++){
              if(cur.e.equals(e)){
                  return true;
              }
            cur=cur.next;
        }
        return false;
    }
    //从链表中删除index位置的元素，返回删除的元素
    //在链表中不是一个常用的操作，练习用：
    public E remove(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
          Node prev=dummyHead;
          for(int i=0;i<index;i++){
              prev=prev.next;
          }
          Node retNode=prev.next;
          prev.next=retNode.next;
          retNode.next=null;
          size--;
          return retNode.e;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }
    //从链表中删除元素e
    public void removeElement(E e){
        Node prev=dummyHead;
        while(prev.next!=null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev=prev.next;
        }
        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
        }
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
      /*  Node cur=dummyHead.next;
        while(cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }*/
      for(Node cur=dummyHead.next;cur!=null;cur=cur.next){
          res.append(cur+"->");
      }
        res.append("NULL");
        return res.toString();
    }
}
