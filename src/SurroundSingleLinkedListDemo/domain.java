package SurroundSingleLinkedListDemo;

public class domain {
    public static void main(String[] args) {
        Surround s= new Surround();
        s.add(5);
//        s.readAll();
        s.Joseph(1,2);

    }
}
class Node{
    public int i;
    public Node Next;
    Node (int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "Node{" +
                "i=" + i +
                '}';
    }
}

class Surround{
    public Node first;
    public Node currNode;
    public void add(int num){
        if(num<1){
            throw new RuntimeException("不能添加小于1的数字！");
        }else {
            for (int i = 1; i <=num ; i++) {
                if(i == 1){
                  first = new Node(1);
                    first.Next=first;
                    currNode = first;
                }else {
                    Node node = new Node(i);
                    currNode.Next = node;
                    node.Next = first   ;
                    currNode = currNode.Next;
                }
            }
        }
    }

    public void readAll(){

            if(first ==null){
                System.out.println("链表为空！");

            }else {
                currNode =first;
                while (true){
                System.out.println(currNode);
                currNode = currNode.Next;
                if (currNode == first){
                    break;
                }
                }
            }

    }

    public void Joseph(int k,int m){
            Node curren = first;
            Node hellper = first;
            while (hellper.Next!=first){
                hellper = hellper.Next;
            }
        for (int i = 1; i <=k-1 ; i++) {
            curren = curren.Next;
            hellper = hellper.Next;
        }
      while (true){
          for (int i = 1; i <= m-1 ; i++) {
              curren = curren.Next;
              hellper = hellper.Next;
          }
          System.out.println(curren.i +"出局了！");
            curren = curren.Next;
            hellper.Next = curren;

        if(hellper ==curren){
            System.out.println("最后剩下"+hellper.i);
            break;
        }

      }
    }
}