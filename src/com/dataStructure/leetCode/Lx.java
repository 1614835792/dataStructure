package com.dataStructure.leetCode;

public class Lx {
    public  void text(){
        int a=-1;
        if(a>0 && a/0!=1){
            System.out.println(1);
        }else{
            System.out.println(2);
        }
        System.out.println(3);
    }
    public void text2(){
     String s[]={"爱","我","中","华"};
     String s1=new String();
     for(int i=0;i<s.length;i++){
         s1=s[i]+s1;
     }

        System.out.println(s1);
    }
    public static void main(String args[]){
        Lx lx=new Lx();
        //lx.text();
        lx.text2();
    }
}
