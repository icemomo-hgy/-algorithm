package HashTable;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: HashTable
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/23 21:16
 * @Description:
 * @since JDK 1.8
 */
public class HashTableTest {

    public static void main(String[] args) {
        TableArrays t = new TableArrays(8);
        Employe e1 = new Employe();
        e1.setId(1);
        e1.setName("Wjw");
        Employe e2= new Employe();
        e2.setId(2);
        e2.setName("Wjw2");
        t.add(e1);
        Employe e3= new Employe();
        e3.setId(9);
        e3.setName("Wjw8");
        t.add(e3);
        t.add(e2);
//           t.look();
        System.out.println(t.find(1));
    }
}

class TableArrays{
    int size = 0;
    LinkList[] array ;
    TableArrays(int size){  //初始化哈希表
        this.size = size;
        array = new LinkList[size];
        for (int i = 0; i < size; i++) {
            array[i] = new LinkList();
        }
    }
    Employe find(int id){
        int i = fineIndex(id);
        Employe employe = array[i].find(id);
        return employe;
    }
    void add(Employe employe){   //添加节点
        int i = fineIndex(employe.id);
        array[i].add(employe);

    }
    void look(){
        for (int i = 0; i < array.length; i++) {
            System.out.println("第"+i+"个链表的元素为");
            array[i].look();
        }
    }

    int fineIndex(int id){ //散列ID
        return  id % size;
    }

}
class LinkList{
    Employe head;

    public boolean isNull(){
        return head==null?true:false;
    }

    public void look(){
        if(isNull()){
            System.out.println("链表为空！");
        }else {
            Employe current = head;
          while (current!=null){
              System.out.print("id为"+current.id);
              System.out.println("姓名为"+current.name);
            current = current.next;
          }        }

    }
    public void add(Employe employe){
        if(isNull()){
            head = employe;
        }else {
            Employe current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = employe;
        }
    }
    public Employe find(int id){
        if (isNull()){
            return null;
        }else {
           Employe current = head;
           while (current.id!=id){
               current=current.next;
               if(current==null){
                   return null;
               }
           }
           return current;
        }

    }
}


class Employe{
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    int id;
    String name;
    Employe next;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
