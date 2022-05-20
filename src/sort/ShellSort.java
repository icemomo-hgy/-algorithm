package sort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/15 14:52
 * @Description:
 * @since JDK 1.8
 */
public class ShellSort {
    public void ShellSortDemo(int[] ints){
        long l = System.currentTimeMillis();
        for (int i = ints.length/2;i > 0 ; i/=2) {
            for (int j = i; j < ints.length ; j++) {
                int temp;
                for ( int k= j; k >=0 ; k-=i) {
                    if(k-i>=0&&ints[k]<ints[k-i]){
                        temp=ints[k];
                        ints[k]=ints[k-i];
                        ints[k-i] =temp;
                    }else {break;}

                }




            }
        }
        long l1 = System.currentTimeMillis();
        for (int i: ints) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
        System.out.println(l1-l+"毫秒");
    }

    public static void main(String[] args) {
        int [] ints = new int[8];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ( (Double)(Math.random() * 800000)).intValue();
        }
        new  ShellSort().ShellSortDemo(ints);
    }

}
