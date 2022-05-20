package Leetcode;

import java.io.Serializable;
import java.util.Stack;

public class isPalindrome {
    //int 方法
    public boolean isPalindrome(int x) {

        if(x<0||(x!=0 && x%10==0)){
            return false;
        }
        int num = 0;
        while (x>=num){
            num = x%10 + num*10;
            x = x/10;
        }

        return (num==x) || (x==num/10);

    }




        //转字符串方法
//    public boolean isPalindrome(int x) {
//        String num = Integer.valueOf(x).toString();
//        Stack stack = new Stack();
//
//        for (int i = 0; i <num.length() ; i++) {
//
//            stack.push(num.charAt(i));
//
//        }
//
//        StringBuilder res =new StringBuilder();
//        for (int i = 0; i <num.length() ; i++) {
//
//            res.append(stack.pop());
//
//        }
//
//        if (res.equals(num)){
//
//            return true;
//        }else {
//            return false;
//        }
//    }
    }
