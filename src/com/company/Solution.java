package com.company;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> tmp = new Stack();
        int l = num.length();
        if(l == 0 || l <= k) return "0";
        for(int i = 0; i < l; i++){
            while(!stack.isEmpty() && num.charAt(i) < stack.peek()){
                tmp.push(stack.pop());
            }
            stack.push(i);
            while(!tmp.isEmpty()){
                stack.push(tmp.pop());
            }
        }
        Set<Integer> set = new HashSet();
        while(k-->0){
            set.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < l; i++){
            if(set.contains(i)){
                continue;
            }
            sb.append(num.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Set<Long> set  = new HashSet(3000000);
        System.out.println(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        for(long i = 0l; i <  5000000; i++){
            set.add(i);
        }
        System.out.println(System.currentTimeMillis() - start);

        for(long i = 100000; i < 100010; i++){
            start = System.currentTimeMillis();
            set.contains(i);
            System.out.println(System.currentTimeMillis() - start);
        }


    }
}