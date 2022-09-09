package DoubleLinkedList;
import org.junit.jupiter.api.Test;
public class main {
    public static void main(String[] args) {
        Node n1 = new Node(1,"老大");
        Node n2 = new Node(2,"老二");
        Node n22 = new Node(1,"老datou1");
        DoubleLinked dou = new DoubleLinked();
        dou.add(n2);
        dou.add(n1);
        dou.update(n22);
//        dou.getList();
        System.out.println(dou.getNode(1).prev.next);
    }
}

 class DoubleLinked{
    private Node HeadNode = new Node(0,"");
    //返回头节点
    @Test
    public Node getHeadNode(){
        return HeadNode;
    };

    //遍历链表
    @Test
    public void getList(){
        Node temp = HeadNode;
        while (true){
            if(temp ==null){
                break;
            }else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    //添加/插入元素
    @Test
    public boolean add(Node node){
        Node Temp = HeadNode;
            while (true){
                if(node.no == Temp.no){
                    throw new RuntimeException("已存在no相同元素");
                }
                if(node.no<Temp.no){
                    node.prev = Temp.prev;
                    Temp.prev.next = node;
                    Temp.prev= node;
                    node.next = Temp;


                    return true;
                }else if(Temp.next==null){
                    Temp.next = node;
                    node.prev = Temp;
                    return true;
                }
                    Temp = Temp.next;


            }



    }

    //删除元素
    @Test
    public boolean delete(int num){
        Node temp = HeadNode;
        while (temp.no != num){
            temp = temp.next;
        }
        temp.prev.next=temp.next;
       temp.next.prev= temp.prev;
       temp.next=null;
       temp.prev=null;
        return true;
    }

    //修改元素
     public  void update(Node node){
        Node temp = HeadNode;
        while (true){
            if(temp.no==node.no){
                node.next=temp.next;
                node.prev=temp.prev;
               temp.prev.next = node;
                if( temp.next!=null){
                temp.next.prev=node;
            }
                break;
            }   else {
                temp = temp.next;
                if(temp==null){
                    System.out.println("找不到修改的元素");
                    break;
                }
            }
        }

     }

     //查询元素
     public Node getNode(int i){
        Node temp = HeadNode;
        while (true){
            if(i == temp.no){
                return temp;
            }else {
                temp = temp.next;
                if(temp == null){
                    System.out.println("没有该元素！");
                    return null;
                }
            }

        }

     }
}


class  Node{
    public int no;
    public String name;
    public Node prev;
    public Node next;
    public Node(int no ,String name){
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
