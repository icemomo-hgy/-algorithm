package Test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/9 15:19
 * @Description:
 * @since JDK 1.8
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.test( 30));
    }



    public Integer test(int n){
        if (n<2){
            return 1;
        }else {
            return test(n-1)+test(n-2);
        }

    }
}
