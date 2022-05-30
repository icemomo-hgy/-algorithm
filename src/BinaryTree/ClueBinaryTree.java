package BinaryTree;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: BinaryTree
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/25 20:19
 * @Description:
 * @since JDK 1.8
 */
public class ClueBinaryTree {

    public static void main(String[] args) {
        Node n1 = new Node(1,"1");
        Node n3 = new Node(3,"3");
        Node n6 = new Node(6,"6");
        Node n8 = new Node(8,"8");
        Node n10 = new Node(10,"10");
        Node n14 = new Node(14,"14");
        n1.left = n3;
        n1.right = n6;
        n3.left = n8;
        n3.right = n10;
        n6.left  = n14;
        ClueTree c1 = new ClueTree(n1);
        c1.CluedTree(n1);
//        System.out.println(n10.right);
        c1.look(n1);
    }


}


class ClueTree{
    public Node head;
    public Node pre =null;
    ClueTree(Node head){
        this.head = head;
    }

    //中序遍历线序二叉树
    public void look(Node head){
        Node node =head;
        while (node!=null){
            while (node.leftType==0){
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType==1){
                node = node.right;
                System.out.println(node);
            }
            node = node.right;

        }
    }

    //线序化
    public void CluedTree(Node head){
        Node node = head;
        if(node==null){
        return;
        }
        CluedTree(node.left);
        if(node.left==null){
        node.left=pre;
        node.leftType=1;
        }
        if(pre!=null&&pre.right==null){
            pre.right=node;
            pre.rightType=1;
        }
        pre = node;
        CluedTree(node.right);
    }

}
class Node{
    public Node(int n,String name){
        this.name=name;
        this.number=n;
    }

    public int leftType = 0;
    public  int rightType = 0;
    public int number;
    public String name;
    public Node left;
    public Node right;

    @Override
    public String toString() {
        return "Node{" +
                "leftType=" + leftType +
                ", rightType=" + rightType +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
