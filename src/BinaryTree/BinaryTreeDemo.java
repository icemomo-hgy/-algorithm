package BinaryTree;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: BinaryTree
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/24 20:30
 * @Description:
 * @since JDK 1.8
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1, "1");
        HeroNode h2 = new HeroNode(2, "2");
        HeroNode h3 = new HeroNode(3, "3");
        HeroNode h4 = new HeroNode(4, "4");
        HeroNode h5 = new HeroNode(5, "5");     HeroNode h6 = new HeroNode(6, "6");
        BinaryTree b = new BinaryTree(h1);
        h1.left=h2;
        h1.right=h3;
        h3.left=h6;
        h2.left = h4;
        h2.right=h5;
        b.delete(2);
        b.rear();
        System.out.println(  b.rearFind(6));
    }


}
    class BinaryTree{
        HeroNode head;
        BinaryTree(HeroNode head){
            this.head = head;
        }
        public void font(){
            if(head!=null){
                head.front();
            }else {
                System.out.println("树空！");
            }
        }
        public HeroNode frontFind(int n){
            if(head!=null){
              return   head.frontFind(n);
            }
            return null;

        }        public void middle(){
            if(head!=null){
                head.middle();

            }else {
                System.out.println("数空！");
            }
        }
        public HeroNode middleFind(int n){
            if(head!=null){
               return head.middleFind(n);
            }
            return null;

        }        public void rear(){
            if(head!= null){
                head.rear();
            }else {
                System.out.println("数空");
            }
        }
        public HeroNode rearFind(int n){
            return head.rearFind(n);
        }
        public void delete(int n){
            if(n == head.number){
                head = null;
            }else {
                head.delete(n);

            }

        }    }


    class HeroNode{
        public int number;
        public String name;
        public HeroNode left;
        public HeroNode right;
        HeroNode(int number,String name){
            this.name = name;
            this.number = number;

        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "number=" + number +
                    ", name='" + name + '\'' +
                    '}';
        }

        //前序遍历
        public void front(){
            System.out.println(this);
            if (this.left!=null){
                this.left.front();
            }
            if (this.right!=null){
                this.right.front();
            }
        }
        //前序查找
        public HeroNode frontFind(int n ){

            HeroNode res  = null;
        if(this.number == n){
            return this;
        }
        if (this.left!=null){
            res =  this.left.frontFind(n);
        }
        if(res!=null){
            return  res;

        }
        if(this.right!=null){
            res =  this.right.frontFind(n);

        }
        if(res!= null){
            return res;

        }else {
            return null;
        }
        }
        //中序遍历
        public void middle(){
            if(this.left!=null){
                this.left.middle();
            }
            System.out.println(this);
            if(this.right!=null){
                this.right.middle();
            }
        }
        //中序查找
        public HeroNode middleFind(int n){
            HeroNode res = null;
            if(this.left!=null){
                res = this.left.number==n?this.left:this.left.middleFind(n);
            }
            if(res!=null){
                return res;
            }
            if(this.number==n){
                return this;
            }
            if(this.right!=null){
                res = this.right.number==n?this.right:this.right.middleFind(n);
            }
            if(res!=null){
                return res;
            }else {
                return null;
            }
       }
        //后序遍历
        public void  rear(){
            if(this.left!=null){
                this.left.rear();
            }
            if(this.right!=null){
                this.right.rear();

            }
            System.out.println(this);
        }
        //后序查找
        public HeroNode rearFind(int n){
            HeroNode res = null;
            if(this.left!=null){
                res = this.left.number==n?this.left:this.left.rearFind(n);
            }
            if(res!=null){
                return res;
            }
            if(this.right!=null){
                res = this.right.number==n?this.right:this.right.rearFind(n);
            }
            if(res!=null){
                return res;
            }
            if(this.number==n){
                return this;
            }else {
                return null;

            }
        }
        public void delete(int n){
            if(this.left!=null&&this.left.number==n){
                this.left=null;
            }
            if(this.right!=null&&this.right.number==n){
                this.right = null;

            }
            if(this.left!=null){
                this.left.delete(n);
            }
            if(this.right!=null){
                this.right.delete(n);

            }        }
}

