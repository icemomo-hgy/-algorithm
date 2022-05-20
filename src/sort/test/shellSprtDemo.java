package sort.test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 14:40
 * @Description:
 * @since JDK 1.8
 */
public class shellSprtDemo {
    void ShellStart(int[] array){
        for (int i = array.length/2; i >0 ; i/=2) {
            for (int j = i; j <array.length ; j++) {

                for (int k = j; k >=0 ; k-=i) {
                    if(k-i>=0&&array[k]<array[k-i]){
                      int temp = array[k];
                        array[k] = array[k-i];
                        array[k-i] = temp;
                    }else {break;}
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arrat = GetArrat.getArrat(8000000);
        shellSprtDemo shellSprtDemo = new shellSprtDemo();
        long l = System.currentTimeMillis();
        shellSprtDemo.ShellStart(arrat);
        System.out.println(System.currentTimeMillis()-l+"毫秒");
//        for (int i: arrat) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }

}
