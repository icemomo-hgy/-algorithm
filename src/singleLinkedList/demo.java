package singleLinkedList;

public class demo {
    public static void main(String[] args) {
        SingleList<String> s1 = new SingleList<>(1,"我是老大");
        SingleList<String> s2 = new SingleList<>(2,"我是老二");
        SingleList<String> s3 = new SingleList<>(3,"我是老三");
        SingleList<String> s4 = new SingleList<>(4,"我是老4");
        SingleList<String> s44 = new SingleList<>(4,"我是老44");

        Hero hero = new Hero();
        hero.insertList(s1);
        hero.insertList(s2); hero.insertList(s4);
        hero.insertList(s3);
        hero.updateList(s44);
//        hero.deleteList(4);
//        SingleList countDown = util.getCountDown(s1, 4);
//        System.out.println(countDown);
//        System.out.println("有效个数为"+hero.countList());
        System.out.println(   hero.reverseList(hero.selectList(0)));

    }
}
class SingleList<T>{
    public int num;
    public T data;
    public SingleList<T> next;  //指向下一个节点
    public SingleList(int num,T data){
        this.num = num;
        this.data = data;
    }

    @Override
    public String toString() {
        return "SingleList{" +
                "num=" + num +
                ", data=" + data +
                ", next=" + next +
                '}';
    }
}
 class util<T>{

    public static int getlength(SingleList<String> s){
        int length= 0;
        while (s!=null){
            length ++;
            s =s.next;
        }
        return length;
    }
    public static SingleList getCountDown(SingleList list,int k ){
        int length = getlength(list);
        int index = (length+1) - (k) ;
        while (true){
            if(list.num == index){
                break;
            }
            list = list.next;
        }
        return list;
    }
}
 class Hero<T>{
    private SingleList head = new SingleList(0,"");
     public SingleList<T> reverseList(SingleList<T> s){
         SingleList<String> reverseHead = new SingleList<>(0,"");
         SingleList<String> temp = (SingleList<String>) s.next;
         SingleList next;
         while (temp !=null){
             next = temp.next;
             temp.next = reverseHead.next;
             reverseHead.next = temp;
             temp = next;
         }
         s.next = (SingleList<T>) reverseHead.next;
         return s;
     }
//    public void addSingleList(SingleList<T> data){  //向链表中添加元素
//        SingleList temp = head;
//        while (true){
//            if(temp.next==null){
//                temp.next = data;
//                break;
//            }
//                temp = temp.next;
//        }
//    }
    public void getList(){
        SingleList temp = head;
        while (true){
          if (temp==null){
             break;
          }
            System.out.println(temp.num+""+temp.data);
          temp = temp.next;
        }

    }

    public  void insertList(SingleList<T> data){
        SingleList temp = head;
        boolean flag = false;
       while (true){
           if(temp.next ==null ||temp.next.num>data.num ){
               data.next = temp.next;
               temp.next = data;
             break;
           }   else if(temp.next.num == data.num){
               System.out.println("已存在");
               break;
           }
           temp = temp.next;
       }
    }
     public SingleList<T> selectList(int num){

        SingleList<T> temp = head;

        while (true){
            if(temp.num == num){
                return  temp;

            }
            temp = temp.next;
        }
     }
     public void updateList(SingleList<T> list){
        SingleList<T> temp = head;
        boolean flag = false;
        while (true){
            if(temp.next.num ==list.num){
                    flag = true;
                    break;
            }
            temp = temp.next;

        }
        if(flag){
            list.next = temp.next.next;
            temp.next = list;
        }
     }
     public void  deleteList(int num){
        SingleList<T> temp = head;
        boolean flag = false;
        while (true){
            if(temp.next.num == num){
                flag = true;
                break;
            }
            temp =temp.next;
        }
        if(flag){
            temp.next =temp.next.next;

        }
     }

     public int countList(){
        int count = 0;
        SingleList<T> temp = head;
        while (temp.next!=null){
                count++;
            temp = temp.next;
        }
        return count;

     }




}
