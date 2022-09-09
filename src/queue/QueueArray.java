package queue;

import com.sun.istack.internal.Nullable;
import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * description:  ArrayList模拟队列
 * author: 黄冠瑛
 * date: 2022/9/9 15:21
 */

public  class  QueueArray<T> {
    private int size;  //队列数组大小
    private int real  = -1; //尾指针
    private int front = -1;  //头指针
    private ArrayList<T> list ;
    //有参构造初始化队列
        QueueArray(int size){
        this.size = size;
        list = new ArrayList<T>();
    }

    public  Integer getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return  list.size()==0|| list.isEmpty();
    }
    public boolean isFull(){
        return list.size()==size;
    }
    public void addQueue(T t){
    if(isFull()){
        System.out.println("队列满");
    }else {
        list.add(t);
    }
    }

    public T outQueue(){
            if(isEmpty()){
                System.out.println("队列为空");
                return null;
            }else {
                T t = list.get(0);
                list.remove(0);
                return t;
            }
    }
    void getArray(){
            if(isEmpty()){
                System.out.println("队列空！");
                return;
            }
            list.stream().forEach(System.out::println);
    }


    public static void main(String[] args) {
        QueueArray queue = new QueueArray<String>(4);
        while (true){
            System.out.println("1 加入一个队列元素");
            System.out.println("2 取出一个队列元素");
            System.out.println("3 查看所有队列元素");
            System.out.println("5 退出！");
            int i = new Scanner(System.in).nextInt();
            switch (i){
                case 1:
                    String str = new Scanner(System.in).nextLine();
                    queue.addQueue(str);
                    break;
                case 2:
                    Object queue1 = queue.outQueue();
                    System.out.println(queue1);
                case 3:
                    queue.getArray();
                    break;
                case 5:
                    return;
            }
        }



    }
}



