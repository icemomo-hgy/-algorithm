package queue;

import java.lang.reflect.Array;
import java.util.Scanner;
//循环队列的实现！
public class demo {
    public static void main(String[] args) {
        queue queue = new queue(String.class,4);
      while (true){
          System.out.println("1 加入一个队列元素");
          System.out.println("2 取出一个队列元素");
          System.out.println("3 查看所有队列元素");
          System.out.println("4 查看有效队列元素个数！");
          System.out.println("5 退出！");
          int i = new Scanner(System.in).nextInt();
            switch (i){
                case 1:
                    String str = new Scanner(System.in).nextLine();
                    queue.queueAdd(str);
                    break;
                case 2:
                    Object queue1 = queue.getQueue();
                    System.out.println(queue1);
                case 3:
                    queue.getArray();
                    break;
                case 4:
                    System.out.println("有效元素为："+queue.getQueueSize());
                    break;
                case 5:
                    return;
            }
      }





    }
}

class queue<T>{
    private int real; // 指向队列末尾后一位
    private int front; // 指向队列头
    private int maxSize;  //队列最大容量
    private T[] array;
    public  queue(Class<T> clazz,int maxSize){
        this.maxSize = maxSize;
    array = (T[]) Array.newInstance(clazz,maxSize);
    }
    public queue(){
        System.out.println("无参构造");
    }
    public boolean isEmpty(){
        return real==front;  //判断队列是否为空
    }
    public boolean isFull(){
         //判断队列是否满了
        return ((real+1)%maxSize) == front;
    }
    public void  queueAdd(T t){   //队列中添加元素
        if(!isFull()){
           array[real] = t;
        real = (real+1)%maxSize;
        }else {
            System.out.println("队列满了！");
        }
    }
    public  T  getQueue(){
        if (isEmpty()){
            System.out.println("队列为空！");

        }
        T  res = array[front];
                array[front] = null;

        front  =(front+1) % maxSize;
            return res;



    }
    public int getQueueSize(){
        return  (real+maxSize-front)%maxSize;
    }
    public void getArray(){
        for (T s: array ) {
            System.out.print(s+"   ");
        }
        System.out.println();
    }
}