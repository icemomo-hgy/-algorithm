package stack;

import org.w3c.dom.Node;

import java.util.Stack;

public class materialize {
    public static void main(String[] args) {

        myStack<String> m1  =new myStack<>(4);
            m1.push("1");
        m1.push("2");
        m1.push("3");

        m1.push("4");
        System.out.println(m1.peek());

    }
}

class  myStack<T>{
    private int maxSize;
    private int cur=0;
    private Node head;
    //初始化栈
    myStack(int maxSize){
        this.maxSize = maxSize;  //初始化栈大小
    }
    public boolean isEmpty(){
        return cur ==0;
    }
    public boolean isFull(){
        return cur == maxSize;
    }
    //入栈
    public <T>void push(T t){
        Node current = head;
        if(isFull()){
            throw new RuntimeException("栈满！");
        }else {
            if(cur ==0){
                head = new Node(cur,t);
                cur++;
            }else {
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(cur, t);
                cur++;
            }
        }

    }
    //出栈
    public Node pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空！");
        }else {
            Node current = head;
            while (true){
                if(current.next.no+1!=cur){
                    current =current.next;
                }else {
                    Node res = current.next;
                    current.next = null;
                    cur--;
                    return res;
                }

            }
        }
    }
    //返回栈顶元素
    public Node peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空！");
        }else {
            Node current = head;
            while (true){
                if(current.next.no+1!=cur){
                    current =current.next;
                }else {
                    Node res = current.next;
                    return res;
                }

            }
        }
    }

    //遍历
    public void  look(){
        Node current = head;
        while (current!=null){
            System.out.println(current);
            current=current.next;
        }
        System.out.println(head.next);
    }

    //反向遍历
    public void  reverseLook(){
        int read = maxSize-1;
        Node heleper = head;
        while (true){
            if(heleper.no!=read){
                heleper=heleper.next; //找到栈顶

            }else {
                System.out.println(heleper);
                heleper =head;
                if(read>=1){
                    read--;
                }else {
                    System.out.println("over!");
                    return;
                }

            }


        }

    }

    class Node <T>{
        public int no;
        public T data;
        public Node next;
        Node(int no,T data){
            this.no = no;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", data=" + data +
                    '}';
        }
    }
}


