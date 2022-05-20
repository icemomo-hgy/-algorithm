package sort.test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 13:35
 * @Description:
 * @since JDK 1.8
 */
public class InsertSortTest {
   void  InsertStart(int[] array){
       int temp = 0;
       for (int i = 0; i < array.length; i++) {
           for (int j = i; j >0 ; j--) {
               if(array[j]<array[j-1]){
                   temp = array[j] ;
                   array[j] = array[j-1];
                   array[j-1] = temp;
               }else {break;}
           }
       }
   }

    public static void main(String[] args) {
        int[] arrat = GetArrat.getArrat(80000);
        InsertSortTest insertSortTest = new InsertSortTest();
        long l = System.currentTimeMillis();
        insertSortTest.InsertStart(arrat);
        System.out.println(System.currentTimeMillis()-l+"毫秒");
//        for (int i: arrat) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }
}
