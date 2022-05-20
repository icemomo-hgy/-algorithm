package Leetcode;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;

public class maxRotateFunctionDemo {




    public int maxRotateFunction(int[] nums) {
        int bestNum = 0;
        Node head = new Node(0,nums[0]);
        Node cur = head;
        for (int i = 1; i <nums.length ; i++) {
          bestNum += i * nums[i];
          Node node = new Node(i,nums[i]);
      while (true){
          if(cur.next!=null){
              cur = cur.next;
          }else {
              cur.next = node;
              node.prev = cur;
              break;
          }
      }
        }


        cur = head;
        for (int i = 0; i < nums.length; i++) {


            while (true){
                if(cur.next!=null){
                cur = cur.next;
                }else {
                    System.out.println(cur);
                    cur.prev.next = null;
                    cur.next = head;
                    head.prev = cur;
                    break;
                }
            }
                Node curr =head;
                  int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if(curr!=null){
                    sum += curr.num*j;
                    bestNum = bestNum>sum?bestNum:sum;
                    curr = curr.next;
                }
            }

        }


        return bestNum;
    }
    class Node{
        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", num=" + num +
                    ", next=" + next +
                    '}';
        }

        int index;
        int num;
        public Node next;
        public Node prev;
        Node(int index,int num){
            this.index = index;
            this.num = num;
        }
    }
}
