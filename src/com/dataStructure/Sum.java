package com.dataStructure;

public class Sum {
    public static int sum(int[]arr){
        return sum(arr,0);
    }
    //计算arr[l...n)这个区间内所有数字的和
    private  static int sum(int []arr,int l){
        if(l==arr.length){
            return 0;
        }
        return arr[l]+sum(arr,l+1);
    }

    public static void fn(int n){
         System.out.print(n%10);
         if(n>10){
            fn(n/10);
         }
    }
    //斐波那契数列
    static int fbnq(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n>=2){
            return fbnq(n-1)+fbnq(n-2);
        }
        return 0;
    }
     //打印正三角
    //第i行(n-i)个空格,2*i-1个※
    public static void sj(int n){
        //i代表行数
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //打印倒三角
    //第i行2*(n-i)+1个※，i-1个空格
    public static void dsj(int n){
        for(int i=1;i<=n;i++){
            for (int k=1;k<=i-1;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*(n-i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        /*int arr[]={1,2,3,5,6,7};
        System.out.println(sum(arr));*/
       /* fn(12345);
           System.out.println();
        System.out.println(fbnq(8));*/
        sj(6);
        System.out.println();
        System.out.println();
        dsj(4);
    }
}
