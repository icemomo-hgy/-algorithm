package Test;

import org.w3c.dom.Node;

//实现简单计算器的屎山代码
public class CaculatorDemo {
    private  int result = 0;
    public  int index = 0;
    public int tat = 1;

    boolean b = true;
    myStack num = new myStack(10);
    myStack formula = new myStack(10);
     CaculatorDemo(String str){
    while (true){
        Character c = str.substring(index,index+1).charAt(0);
        if(c>=48&&c<=57){
            int b = c;
            if(num.isEmpty()){
                num.push(b);
            }else {
                while (true){
                  if(index+1<str.length()-1){
                      int c1 = str.charAt(index + 1);
                      if(index+1<str.length()-1&&(c1>=48&&c1<=57)){
                          int data = (int)num.pop().data*10 + c1;
                          num.push(data);
                          index++;

                      }else {
                          break;
                  }
                    }
                }
            }


        } else if(c==42||c==43|| c==45 ||c == 47){
            System.out.println(123123213);
            if(formula.isEmpty()){
                formula.push(c);
            }else if(!formula.isFull()){
                if(formula.priority((Character)formula.peek().data) >= formula.priority(c)){
                    int num1 = (int)num.pop().data;
                    int num2 = (int) num.pop().data;
                    Character fo = (Character) formula.pop().data;
                    int res = num.clacular(num2,num1,fo);
                    num.push(res);
                    formula.push(c);
                }else {
                    formula.push(c);

                }
            }
        }else {
            throw new RuntimeException("字符串有误！");
        }
        index++;
        if(index>=str.length()){
            this.result =(int) num.peek().data;
            break;
        }
    }

    while (true){
        if(formula.isEmpty()){
            break;
        }
        int num1 = (int)num.pop().data;
        int num2 = (int) num.pop().data;
        Character fo = (Character) formula.pop().data;
        int res = num.clacular(num2,num1,fo);
        num.push(res);
    }

    }
    public  int getRes(){
        return  (int)num.peek().data;
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
    //判断优先级
    public int priority(char c){
        return c =='*'||c=='/'? 1:0;
    }
    public int clacular(int num1,int num2,char c){
        if(c =='*'){
            return num1*num2;
        }
        if(c =='/'){
            return num1/num2;
        }
        if(c =='+'){
            return num1+num2;
        }
        if(c =='-'){
            return num1-num2;
        }
        else {
            throw  new RuntimeException("运算错误！");
        }
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
               Node cu =  new Node(cur, t);
                current.next =cu;
                cu.prev =current;
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
                if(current.next!=null){
                    current =current.next;
                }else {
                    if(current.prev==null){
                        cur--;
                        return current;
                    }else {
                        current.prev.next = null;
                        current.prev = null;
                        cur--;
                        return current;
                    }
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
                if(current.next!=null){
                    current =current.next;
                }else {
                    Node res = current;
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
        public Node prev;
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
