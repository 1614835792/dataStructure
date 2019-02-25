package com.dataStructure.bst;
import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;  //元素个数
    public BST(){
        root=null;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void add(E e){
        root=add(root,e);
    }
    //向以Node为根的二分搜素树中插入元素E，递归算法
    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }
        else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }
    //二分搜索树的层序遍历
    public void levelOrder(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.remove();
            System.out.println("当前要删除的节点是："+cur.e);
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }
    }
    public boolean contains(E e){
        return contains(root,e);
    }
    //查询二分搜索树中是否包含元素e
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }
        else if(e.compareTo(node.e)<0){
            return  contains(node.left,e);
        }else{
            return  contains(node.right,e);
        }
    }
    //二分搜素树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.e+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.e+" ");
        inOrder(node.right);
    }
    public void postOrder(){
        inOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e+" ");
    }
    //寻找二分搜素树的最大元素
    public E maxmun(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return maxmun(root).e;
    }
    public Node maxmun(Node node){
        if(node.right==null){
            return node;
        }
        return  maxmun(node.right);
    }
    //寻找二分搜素树的最小元素
    public E minimum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).e;
    }
    //寻找二分搜素树的最小元素的递归
    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return  minimum(node.left);
    }
    // 从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin(){
        E ret=minimum();
        root=removeMin(root);
        return ret;
    }
    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
       if(node.left==null){
           Node rightNode=node.right;
           node.right=null;
           size--;
           return rightNode;
       }
        node.left=removeMin(node.left);
       return node;
    }
    public E removeMax(){
        E ret=minimum();
        root=removeMax(root);
        return ret;
    }
    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }
    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
       root=remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node,E e){
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
             node.left=remove(node.left,e);
             return node;
        }
        else if(e.compareTo(node.e)>0){
             node.right=remove(node.right,e);
             return node;
        }
        else{
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空的情况
            //找到比待删除节点的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }
}
