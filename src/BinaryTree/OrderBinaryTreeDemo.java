package BinaryTree;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: BinaryTree
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/25 15:53
 * @Description:
 * @since JDK 1.8
 */
public class OrderBinaryTreeDemo {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        OrderBinary o = new OrderBinary(array);
        o.middleLook(0);
    }

}
class  OrderBinary {
    int[] array;

    OrderBinary(int[] array) {
        this.array = array;
    }

    void frontLook(int index) {
        System.out.println(array[index]);
        if (2 * index + 1 < array.length) {
            frontLook(2 * index + 1);
        }
        if (2 * index + 2 < array.length) {
            frontLook(2 * index + 2);
        }

    }

    void middleLook(int index) {
        if (2 * index + 1 < array.length) {
            middleLook((2 * index + 1));
        }
        System.out.println(array[index]);
        if(2*index +2< array.length){
            middleLook(2*index +2);
        }
    }
}
