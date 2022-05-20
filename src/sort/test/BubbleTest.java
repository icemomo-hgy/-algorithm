package sort.test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 13:10
 * @Description:
 * @since JDK 1.8
 */
public class BubbleTest {

    void  getBubble(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {

                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] =  array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrat = GetArrat.getArrat(80000);
        BubbleTest bubbleTest  = new BubbleTest();
        long l = System.currentTimeMillis();
        bubbleTest.getBubble(arrat);
        System.out.println(System.currentTimeMillis()-l+"毫秒");
//        for (int i : arrat) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }
}
